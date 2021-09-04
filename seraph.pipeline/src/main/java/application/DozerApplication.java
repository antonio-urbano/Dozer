package application;

import engine.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.Stores;
import processors.*;

import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class DozerApplication {

    static Properties getProcessorProperties(){
        Properties props = new Properties();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "dozer-processors-app");
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, CurrentAgentSerde.class);
        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    static Properties getStreamDeleteByEventProperties(){
        Properties props = new Properties();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "dozer-delete-stream-event-app");
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Neo4jObjSerde.class);
        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    static Properties getStreamDeleteByTimeProperties(){
        Properties props = new Properties();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "dozer-delete-stream-time-app");
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    static void produceDeleteRecordByTime(final StreamsBuilder builder, Long emit_time_range) {


        JsonSerializer<Neo4jObj> neoJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<Neo4jObj> neoJsonDeserializer = new JsonDeserializer<>(
                Neo4jObj.class);
        Serde<Neo4jObj> neoSerde = Serdes.serdeFrom(neoJsonSerializer,
                neoJsonDeserializer);

        JsonSerializer<OutputObj> outputSer = new JsonSerializer<>();
        JsonDeserializer<OutputObj> outputDeser = new JsonDeserializer<>(
                OutputObj.class);
        Serde<OutputObj> outputObjSerde = Serdes.serdeFrom(outputSer,
                outputDeser);

        final Serde<String> stringSerde = Serdes.String();


        KStream<String,OutputObj> stream = builder.stream("relationships",
                Consumed.with(Serdes.String(), neoSerde).
                        withTimestampExtractor(new CustomerExtractor(emit_time_range)))
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj, emit_time_range)));

        stream.to("tmpDeleteTopic", Produced.with(stringSerde, outputObjSerde));

    }

    static void produceDeleteRecordByEvent(final Topology topology) {

        JsonSerializer<Queue> queueSer = new JsonSerializer<>();
        JsonDeserializer<Queue> queueDeser = new JsonDeserializer<>(
                Queue.class);
        Serde<Queue> queueSerde = Serdes.serdeFrom(queueSer,
                queueDeser);

        topology.addSource("RelationshipsSource", "relationships");
        topology.addProcessor("DeleteProducerByEventProcessor", DeleteProducerByEventProcessor::new, "RelationshipsSource");
        topology.addStateStore(Stores.keyValueStoreBuilder(
                Stores.inMemoryKeyValueStore("queue-event-store"),
                Serdes.String(),
                queueSerde),
                "DeleteProducerByEventProcessor");

    }



        public static void main(final String[] args) {

            JsonSerializer<CurrentAgent> agentJsonSerializer = new JsonSerializer<>();
            JsonDeserializer<CurrentAgent> agentJsonDeserializer = new JsonDeserializer<>(
                    CurrentAgent.class);
            Serde<CurrentAgent> agentSerde = Serdes.serdeFrom(agentJsonSerializer,
                    agentJsonDeserializer);

            Serde<Long> longSerde = Serdes.Long();


            final Topology builder = new Topology();
            final Topology deleteByEvent_topology = new Topology();
            final StreamsBuilder builder_deleteRecordByTime = new StreamsBuilder();

//        produceDeleteRecordByTime(builder_deleteRecordByTime, 300000L);
        produceDeleteRecordByEvent(deleteByEvent_topology);


        builder.addSource("Source", "processor-topic1");


        builder.addProcessor("TickerProcessorTime", TickerProcessorTime::new, "Source");
//        builder.addProcessor("TickerProcessorEvent", TickerProcessorEvent::new, "Source");
        builder.addProcessor("TimeManagedProcessorDeletion", TimeManagedProcessorDeletion::new, "Source");
        builder.addProcessor("TimeManagedProcessorInsertion", TimeManagedProcessorInsertion::new, "Source");
        builder.addProcessor("CypherHandlerProcessor", CypherHandlerProcessor::new, "Source");



        builder.addStateStore(Stores.keyValueStoreBuilder(
                Stores.inMemoryKeyValueStore("agent-store2"),
                Serdes.String(),
                agentSerde),
                "TickerProcessorTime", "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "CypherHandlerProcessor");


        builder.addStateStore(Stores.keyValueStoreBuilder(
                Stores.inMemoryKeyValueStore("offset-store2"),
                Serdes.String(),
                longSerde),
                "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "TickerProcessorTime");



        builder.addSink("Sink", "processor-topic1","TickerProcessorTime", "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "CypherHandlerProcessor");


        final KafkaStreams streams = new KafkaStreams(builder, getProcessorProperties());
        final KafkaStreams streams_delete_byEvent = new KafkaStreams(deleteByEvent_topology, getStreamDeleteByEventProperties());
//        final CountDownLatch delete_latch = new CountDownLatch(1);
//        final KafkaStreams streams_delete_byTime = new KafkaStreams(builder_deleteRecordByTime.build(), getStreamDeleteByTimeProperties());
        final CountDownLatch latch = new CountDownLatch(2);




        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
            @Override
            public void run() {
                streams.close();

//                streams_delete_byTime.close();
                streams_delete_byEvent.close();

                latch.countDown();
            }
        });

//        Runtime.getRuntime().addShutdownHook(new Thread("delete-thread-shutdown-hook") {
//            @Override
//            public void run() {
//                streams_delete_byTime.close();
////                streams.close();
//                delete_latch.countDown();
//            }
//        });

        try {
            streams.start();

//            streams_delete_byTime.start();
            streams_delete_byEvent.start();

            latch.await();
//            delete_latch.await();
        } catch (final Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}

