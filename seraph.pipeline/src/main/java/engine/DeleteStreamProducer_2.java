package engine;

import com.fasterxml.jackson.core.type.TypeReference;
import config.KafkaConfigProperties;
import engine.*;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.StoreBuilder;
import org.apache.kafka.streams.state.Stores;
import org.jetbrains.annotations.NotNull;
import org.springframework.kafka.support.serializer.JsonSerde;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;


public final class DeleteStreamProducer_2 {

    /**
     * Starting from creation records in CDC format it produces deletion records with a customized timestamp.
     * These record will be consumed by the {@link TimeManagedConsumer} to re-produce the record at proper time
     * @param builder
     * @param emit_time_range temporary topic on which produce deletion record with custom timestamp
     */
    static void produceDeleteRecord(final StreamsBuilder builder, Long emit_time_range) {


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

        JsonSerializer<OutputObj[]> outputObjArraySerializer = new JsonSerializer<>();
        JsonDeserializer<OutputObj[]> outputObjArrayDeserializer = new JsonDeserializer<>(
                OutputObj[].class);
        Serde<OutputObj[]> outputArrayObjSerde = Serdes.serdeFrom(outputObjArraySerializer,
                outputObjArrayDeserializer);


        final Serde<String> stringSerde = Serdes.String();



        KStream<String,OutputObj> stream = builder.stream("relationships",
                Consumed.with(Serdes.String(), neoSerde).
                        withTimestampExtractor(new CustomerExtractor(emit_time_range))) //todo window range
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj, emit_time_range)));

/*
        // create store
        StoreBuilder storeBuilder = Stores.keyValueStoreBuilder(
                Stores.persistentKeyValueStore("queue-store"),
                Serdes.String(),
                outputArrayObjSerde);
        builder.addStateStore(storeBuilder);
        stream.process(DeleteProducerByEvent::new,"queue-store");
*/

        stream.to("tmpDeleteTopic", Produced.with(stringSerde, outputObjSerde));


    }




    public static void main(final String[] args) {

        final Properties props = KafkaConfigProperties.getStreamsConfig();
        final StreamsBuilder builder = new StreamsBuilder();

        produceDeleteRecord(builder, 300000L);


        final KafkaStreams streams = new KafkaStreams(builder.build(), props);
        final CountDownLatch latch = new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-filter-seraph-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (final Throwable e) {
            System.exit(1);
        }
        System.exit(0);

    }

}
