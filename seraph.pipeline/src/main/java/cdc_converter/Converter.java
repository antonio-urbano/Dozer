package cdc_converter;

import custom_serdes.CurrentAgentSerde;
import custom_serdes.JsonDeserializer;
import custom_serdes.JsonSerializer;
import engine.Neo4jObj;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Converter {

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

    static void readKeyType(final StreamsBuilder builder, CdcCreatedNode node) {

        JsonSerializer<Neo4jObj> neoJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<Neo4jObj> neoJsonDeserializer = new JsonDeserializer<>(
                Neo4jObj.class);
        Serde<Neo4jObj> neoSerde = Serdes.serdeFrom(neoJsonSerializer,
                neoJsonDeserializer);

        JsonSerializer<CdcCreatedNode> cdcSer = new JsonSerializer<>();
        JsonDeserializer<CdcCreatedNode> cdcDeser = new JsonDeserializer<>(
                CdcCreatedNode.class);
        Serde<CdcCreatedNode> cdcSerde = Serdes.serdeFrom(cdcSer,
                cdcDeser);

        final Serde<String> stringSerde = Serdes.String();


//        KStream<String,CdcCreatedNode> stream = builder.stream("nodes",
//                Consumed.with(Serdes.String(), neoSerde))
//                .filter((_key, neo4jObj) -> neo4jObj!=null)
//                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
//                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
//                .map((k,neo4jObj) -> new KeyValue<>(k, node));

        KStream<String,CdcCreatedNode> stream = builder.stream("provaT4",
                Consumed.with(Serdes.String(), stringSerde))
                .map((k,v) -> new KeyValue<>(k, node));

        stream.to("provaT3", Produced.with(stringSerde, cdcSerde));

    }

    public static void main(final String[] args)  {

        CdcCreatedNode node = new CdcCreatedNode();
        node.setMeta("neo4j", 16, 0, 3, "neo4j-source");

        Map properties = new HashMap();
        properties.put("name", "PatZZZZ");
        properties.put("id", 17L);
        ArrayList labels = new ArrayList();
        labels.add("Patient");
        node.setPayload("17", properties,labels);

        Map<String, String> schemaProperties = new HashMap<>();
        schemaProperties.put("name", "String");
        schemaProperties.put("id", "Long");
        node.setSchema(schemaProperties, new ArrayList());

        final StreamsBuilder builder = new StreamsBuilder();
        readKeyType(builder,node);
        final KafkaStreams streams = new KafkaStreams(builder.build(), getProcessorProperties());
        final CountDownLatch latch = new CountDownLatch(1);


        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("dozer-streams-shutdown-hook") {
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
