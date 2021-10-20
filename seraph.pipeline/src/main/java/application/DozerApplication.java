package application;

import cdc_converter.CdcDeleteRecord;
import cdc_converter.CdcCreateRecord;
import cdc_converter.JsonPG;
import cdc_converter.ProcessorConverter;
import config.KafkaConfigProperties;
import custom_serdes.CdcSerde;
import custom_serdes.CurrentAgentSerde;
import custom_serdes.JsonDeserializer;
import custom_serdes.JsonSerializer;
import engine.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.Stores;
import org.springframework.web.client.support.RestGatewaySupport;
import processors.*;
import seraphGrammar.*;
import seraphGrammar.SeraphQueryParser;

import java.sql.Time;
import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

//todo javadoc
public class DozerApplication {

    static Properties getStreamProperties(String applicationId, String bootstrapServer, String keySerde, Class<?> valueSerde) {
        Properties props = new Properties();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, applicationId); //todo
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, keySerde);
        props.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, valueSerde);
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    static void convertPgToCDC(final StreamsBuilder builder, String inputStream) {

        JsonSerializer<JsonPG> PGJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<JsonPG> PGJsonDeserializer = new JsonDeserializer<>(
                JsonPG.class);
        Serde<JsonPG> jsonSerde = Serdes.serdeFrom(PGJsonSerializer,
                PGJsonDeserializer);

        KStream<String, JsonPG> stream = builder.stream(inputStream,
                Consumed.with(Serdes.String(), jsonSerde));
        stream.process(ProcessorConverter::new);
    }


    static void produceDeleteRecordByTime(final StreamsBuilder builder, Long emit_time_range) {


        JsonSerializer<CdcCreateRecord> cdcCreateSerializer = new JsonSerializer<>();
        JsonDeserializer<CdcCreateRecord> cdcCreateDeserializer = new JsonDeserializer<>(
                CdcCreateRecord.class);
        Serde<CdcCreateRecord> cdcCreateSerde = Serdes.serdeFrom(cdcCreateSerializer,
                cdcCreateDeserializer);

        JsonSerializer<CdcDeleteRecord> cdcDeleteSerializer = new JsonSerializer<>();
        JsonDeserializer<CdcDeleteRecord> cdcDeleteDeserializer = new JsonDeserializer<>(
                CdcDeleteRecord.class);
        Serde<CdcDeleteRecord> cdcDeleteSerde = Serdes.serdeFrom(cdcDeleteSerializer,
                cdcDeleteDeserializer);

        final Serde<String> stringSerde = Serdes.String();


        KStream<String, CdcDeleteRecord> stream = builder.stream(DozerConfig.getCdcCreateRelationshipsTopic(),
                        Consumed.with(Serdes.String(), cdcCreateSerde).
                                withTimestampExtractor(new CustomerExtractor(emit_time_range)))
                .filter((_key, cdcCreateRecord) -> cdcCreateRecord != null)
                .filter((_key, cdcCreateRecord) -> cdcCreateRecord.getPayload() != null)
                .filter((_key, cdcCreateRecord) -> cdcCreateRecord.getMeta().get("operation").equals("created"))
                .filter((_key, cdcCreateRecord) -> cdcCreateRecord.getPayload().get("start") != null)
                .map((k, cdcCreateRecord) -> new KeyValue<>(k, new CdcDeleteRecord(cdcCreateRecord, emit_time_range)));

        stream.to(DozerConfig.getCdcDeleteRelationshipsTopic(), Produced.with(stringSerde, cdcDeleteSerde));

    }

    static void produceDeleteRecordByEvent(final Topology topology, String queryID, EventRange eventRange) {

        final String KEY_STORE = queryID + "queue-event-store";

        JsonSerializer<Queue> queueSer = new JsonSerializer<>();
        JsonDeserializer<Queue> queueDeser = new JsonDeserializer<>(
                Queue.class);
        Serde<Queue> queueSerde = Serdes.serdeFrom(queueSer,
                queueDeser);

        topology.addSource("RelationshipsSource", DozerConfig.getCdcCreateRelationshipsTopic());
        topology.addProcessor("DeleteProducerByEventProcessor",
                () -> new DeleteProducerByEventProcessor(eventRange, DozerConfig.getCdcDeleteRelationshipsTopic(), KEY_STORE),
                "RelationshipsSource");
        topology.addStateStore(Stores.keyValueStoreBuilder(
                        Stores.inMemoryKeyValueStore(KEY_STORE),
                        Serdes.String(),
                        queueSerde),
                "DeleteProducerByEventProcessor");

    }


    public static void main(final String[] args) throws Exception {

        if (DozerConfig.getSeraphQuery().getQueryType() == QueryType.UNREGISTER) {
            throw new Exception("Got an UNREGISTER QUERY");
        }

        final RegisterQuery registerQuery = (RegisterQuery) DozerConfig.getSeraphQuery();

        JsonSerializer<CurrentAgent> agentJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<CurrentAgent> agentJsonDeserializer = new JsonDeserializer<>(
                CurrentAgent.class);
        Serde<CurrentAgent> agentSerde = Serdes.serdeFrom(agentJsonSerializer,
                agentJsonDeserializer);

        Serde<Long> longSerde = Serdes.Long();

        final Topology builder = new Topology();
        final StreamsBuilder builder_deleteRecordByTime = new StreamsBuilder();
        final Topology deleteByEvent_topology = new Topology();

        if (registerQuery.getSeraphQuery().getWindow().getRange().isTimeRange()) {
            TimeRange timeRange = (TimeRange) registerQuery.getSeraphQuery().getWindow().getRange();
            produceDeleteRecordByTime(
                    builder_deleteRecordByTime,
                    timeRange.getDuration().toMillis()
                    );
        }
        if (registerQuery.getSeraphQuery().getWindow().getRange().isEventRange()) {
            EventRange eventRange = (EventRange) registerQuery.getSeraphQuery().getWindow().getRange();
            produceDeleteRecordByEvent(
                    deleteByEvent_topology,
                    registerQuery.getQueryID(),
                    eventRange
            );
        }

        builder.addSource("Source", DozerConfig.getWorkFlowTopic());

        final String AGENT_STORE = registerQuery.getQueryID() + "agent-store";
        final String OFFSET_STORE = registerQuery.getQueryID() + "offset-store";

        if (registerQuery.getSeraphQuery().getReport().getRange().isTimeRange()) {
            TimeRange timeRange = (TimeRange) registerQuery.getSeraphQuery().getReport().getRange();
            builder.addProcessor("TickerProcessor", () -> new TickerProcessorTime(timeRange.getDuration().toMillis(), AGENT_STORE, OFFSET_STORE), "Source");
        }
        if (registerQuery.getSeraphQuery().getReport().getRange().isEventRange()) {
            EventRange eventRange = (EventRange) registerQuery.getSeraphQuery().getReport().getRange();
            builder.addProcessor("TickerProcessor", () -> new TickerProcessorEvent(eventRange.getSize(), AGENT_STORE, OFFSET_STORE), "Source");
        }


        builder.addProcessor("TimeManagedProcessorDeletion", () -> new TimeManagedProcessorDeletion(AGENT_STORE, OFFSET_STORE), "Source");
        builder.addProcessor("TimeManagedProcessorInsertion", () -> new TimeManagedProcessorInsertion(AGENT_STORE, OFFSET_STORE), "Source");
        builder.addProcessor("CypherHandlerProcessor", ()->new CypherHandlerProcessor(AGENT_STORE), "Source");


        builder.addStateStore(Stores.keyValueStoreBuilder(
                        Stores.inMemoryKeyValueStore(AGENT_STORE),
                        Serdes.String(),
                        agentSerde),
                "TickerProcessor", "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "CypherHandlerProcessor");


        builder.addStateStore(Stores.keyValueStoreBuilder(
                        Stores.inMemoryKeyValueStore(OFFSET_STORE),
                        Serdes.String(),
                        longSerde),
                "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "TickerProcessor");

        builder.addSink("Sink", DozerConfig.getWorkFlowTopic(), "TickerProcessor", "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "CypherHandlerProcessor");

        final CountDownLatch latch = new CountDownLatch(3);
        final KafkaStreams streams = new KafkaStreams(builder, getStreamProperties(
                registerQuery.getQueryID() + "_dozer-processors-app", DozerConfig.getKafkaBroker(),
                Serdes.String().getClass().getName(), CurrentAgentSerde.class));
        final KafkaStreams streamsDeleteProducer;

        if (registerQuery.getSeraphQuery().getWindow().getRange().isTimeRange())
            streamsDeleteProducer = new KafkaStreams(builder_deleteRecordByTime.build(),
                    getStreamProperties(registerQuery.getQueryID() +"_dozer-delete-stream-time-app", DozerConfig.getKafkaBroker(),
                            Serdes.String().getClass().getName(), CdcSerde.class));
        else
            streamsDeleteProducer = new KafkaStreams(deleteByEvent_topology,
                    getStreamProperties(registerQuery.getQueryID() +"_dozer-delete-stream-event-app", DozerConfig.getKafkaBroker(),
                            Serdes.String().getClass().getName(), CdcSerde.class));

        final StreamsBuilder converterBuilder = new StreamsBuilder();
        convertPgToCDC(converterBuilder, registerQuery.getSeraphQuery().getInputStream());
        final KafkaStreams streamsConverter = new KafkaStreams(converterBuilder.build(),
                getStreamProperties(registerQuery.getQueryID() +"_dozer-converter-processors-app", DozerConfig.getKafkaBroker(),
                        Serdes.String().getClass().getName(), CdcSerde.class));

        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(),
                new CurrentAgent("SERAPH_QUERY_PARSED",
                        "completed", SeraphPayloadHandler.getInitTimeToSync(registerQuery.getSeraphQuery().getInputStream()))));
        kafkaProducer.flush();
        kafkaProducer.close();

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread(registerQuery.getQueryID() +"_dozer-streams-shutdown-hook") {
            @Override
            public void run() {
                streamsConverter.close();
                streams.close();
                streamsDeleteProducer.close();
                latch.countDown();
            }
        });

        try {
            streamsConverter.start();
            streams.start();
            streamsDeleteProducer.start();
            latch.await();
        } catch (final Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}

