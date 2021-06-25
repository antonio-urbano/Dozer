package processors;

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


import java.util.Properties;
import java.util.concurrent.CountDownLatch;


public final class DeleteStreamProducer_2 {

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


        final Serde<String> stringSerde = Serdes.String();



        KStream<String,OutputObj> stream = builder.stream("relationships",
                Consumed.with(Serdes.String(), neoSerde).
                        withTimestampExtractor(new CustomerExtractor(300000L))) //todo window range
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj)));


        stream.to("tmpDeleteTopic", Produced.with(stringSerde, outputObjSerde));


    }




    public static void main(final String[] args) {

        final Properties props = KafkaConfigProperties.getStreamsConfig();
        final StreamsBuilder builder = new StreamsBuilder();

        produceDeleteRecord(builder);


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
