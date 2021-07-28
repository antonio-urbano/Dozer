package processors;

import engine.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;

import java.util.Properties;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class SeraphApplication {

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

    static Properties getStreamDeleteProperties(){
        Properties props = new Properties();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "dozer-delete-stream-app");
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    static void produceDeleteRecord(final StreamsBuilder builder) {


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


        JsonSerializer<OutputObj[]> outputArraySer = new JsonSerializer<>();
        JsonDeserializer<OutputObj[]> outputArrayDeser = new JsonDeserializer<>(
                OutputObj[].class);
        Serde<OutputObj[]> outputObjArraySerde = Serdes.serdeFrom(outputArraySer,
                outputArrayDeser);


        JsonSerializer<Queue> queueSer = new JsonSerializer<>();
        JsonDeserializer<Queue> queueDeser = new JsonDeserializer<>(
                Queue.class);
        Serde<Queue> queueSerde = Serdes.serdeFrom(queueSer,
                queueDeser);


        final Serde<String> stringSerde = Serdes.String();


        KStream<String,OutputObj> stream = builder.stream("relationships",
                Consumed.with(Serdes.String(), neoSerde).
                        withTimestampExtractor(new CustomerExtractor(300000L))) //todo window range
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj)));

/*
//        // create store
//        StoreBuilder storeBuilder = Stores.keyValueStoreBuilder(
//                Stores.persistentKeyValueStore("obj-stream-store"),
//                Serdes.String(),
//                outputObjArraySerde);
//        builder.addStateStore(storeBuilder);
        //
        StoreBuilder queueStoreBuilder = Stores.keyValueStoreBuilder(
                Stores.persistentKeyValueStore("queue-store3"),
                Serdes.String(),
                queueSerde);
        builder.addStateStore(queueStoreBuilder);
        stream.process(DeleteProducerByEvent::new,"queue-store3");//,"obj-stream-store");
*/

        stream.to("tmpDeleteTopic", Produced.with(stringSerde, outputObjSerde));


    }

    public static void main(final String[] args) {



        JsonSerializer<CurrentAgent> agentJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<CurrentAgent> agentJsonDeserializer = new JsonDeserializer<>(
                CurrentAgent.class);
        Serde<CurrentAgent> agentSerde = Serdes.serdeFrom(agentJsonSerializer,
                agentJsonDeserializer);

        Serde<Long> longSerde = Serdes.Long();



//        final StreamsBuilder streamsBuilder = new StreamsBuilder();
//        produceDeleteRecord(streamsBuilder);
//        final Topology builder = streamsBuilder.build();
//rops
        final Topology builder = new Topology();
        final StreamsBuilder streamsBuilder = new StreamsBuilder();
        produceDeleteRecord(streamsBuilder);


        builder.addSource("Source", "processor-topic1");
//        builder.addSource("RelationshipsSource", new StringDeserializer(), new Neo4jObjSerde().deserializer(),"relationships");

//        builder.addProcessor("provaProcessor", ProvaProcessor::new, "RelationshipsSource");


        builder.addProcessor("TickerProcessorTime", TickerProcessorTime::new, "Source");
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
                "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion");



        builder.addSink("Sink", "processor-topic1","TickerProcessorTime", "TimeManagedProcessorDeletion", "TimeManagedProcessorInsertion", "CypherHandlerProcessor");


        final KafkaStreams streams = new KafkaStreams(builder, getProcessorProperties());
//        final CountDownLatch delete_latch = new CountDownLatch(1);
        final KafkaStreams streams_delete = new KafkaStreams(streamsBuilder.build(), getStreamDeleteProperties());
        final CountDownLatch latch = new CountDownLatch(2);




        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                streams_delete.close();
                latch.countDown();
            }
        });

//        Runtime.getRuntime().addShutdownHook(new Thread("delete-thread-shutdown-hook") {
//            @Override
//            public void run() {
//                streams_delete.close();
////                streams.close();
//                delete_latch.countDown();
//            }
//        });

        try {
            streams.start();
            streams_delete.start();
            latch.await();
//            delete_latch.await();
        } catch (final Throwable e) {
            System.exit(1);
        }
        System.exit(0);
    }
}

