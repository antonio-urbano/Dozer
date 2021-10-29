package dataset;

import cdc_converter.JsonPG;
import cdc_converter.PgEdge;
import cdc_converter.PgNode;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.config.TopicConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class StarDataset {
    //star-test-dataset-small: (PRODUCTION period = 30000ms), every minute 2 nodes linked to 3 other nodes per PT1H = 360 nodes
    //star-test-dataset: (PRODUCTION period = 50ms) every second 20 nodes linked to 15 other nodes per P1DT0S = 34560000 nodes in 1728000 events
    public static String TOPIC = "star-test-dataset";
    public static String BROKER = "localhost:9092";
    public static Instant START_INSTANT = Instant.parse("2021-01-01T00:00:00Z");
    public static Duration TIME_RANGE = Duration.parse("P1DT0S");
    public static Long PRODUCTION_PERIOD_MS = 50L;
    public final static int RELATIONSHIPS_PER_NODE = 20;


    public static void main(String[] args) {

        Properties adminClientProps = new Properties();
        adminClientProps.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER);

        AdminClient adminClient = KafkaAdminClient.create(adminClientProps);

        NewTopic kafkaTopic = new NewTopic(TOPIC, 1, (short) 1);
        kafkaTopic.configs(Map.of(TopicConfig.RETENTION_MS_CONFIG, "-1"));

        try {
            DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(List.of(TOPIC));
            while (!deleteTopicsResult.all().isDone()) {};
            CreateTopicsResult createTopicsResult = adminClient.createTopics(List.of(kafkaTopic));
            while(!createTopicsResult.all().isDone()) {};
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        Properties producerProps = new Properties();
        producerProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER);
        producerProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producerProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        producerProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 200000);
        producerProps.put(ProducerConfig.LINGER_MS_CONFIG, 100);
        producerProps.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "lz4");

        Producer<String, JsonPG> kafkaProducer = new KafkaProducer<>(producerProps);

        AtomicLong initTimestamp = new AtomicLong(START_INSTANT.toEpochMilli());

        int txEventNodeId = 0;
        int txEventEdgeId = 0;
        int internalNodeCounter = 0;
        int internalEdgeCounter = 1;
        int endId = 1;


        ArrayList<String> labelsPerson = new ArrayList<>();
        labelsPerson.add("Person");
        Map<String, ArrayList<Object>> propertiesPerson = new HashMap<>();
        ArrayList<Object> nameProperties;
//        nameProperties.add("P" + txEventNodeId);
        ArrayList<Object> timestampProperties;
//        timestampProperties.add(initTimestamp.get());
//        propertiesPerson.put("name", nameProperties);
//        propertiesPerson.put("timestamp", timestampProperties);
//        PgNode node = new PgNode(txEventNodeId.get(), labelsPerson, propertiesPerson);
//        ArrayList<PgNode> nodes = new ArrayList<>();
//        nodes.add(node);
//        JsonPG jsonPG = new JsonPG(nodes, new ArrayList<>());
        ArrayList<PgNode> nodes;
        ArrayList<PgEdge> edges;
        JsonPG jsonPG;
//
//        kafkaProducer.send(new ProducerRecord<>(TOPIC,
//                0,
//                initTimestamp.get(),
//                null,
//                jsonPG));
//        kafkaProducer.flush();

        while (initTimestamp.get() < START_INSTANT.plus(TIME_RANGE).toEpochMilli()) {
            nodes = new ArrayList<>();
            edges = new ArrayList<>();

            timestampProperties = new ArrayList<>();
            initTimestamp.set(initTimestamp.get() + PRODUCTION_PERIOD_MS);
            timestampProperties.add(0, initTimestamp.get());

            for (int i =0; i<RELATIONSHIPS_PER_NODE;i++) {
                if (i>0)
                    internalNodeCounter++;
                nameProperties = new ArrayList<>();
                nameProperties.add(0,"P" + (txEventNodeId + internalNodeCounter));
                propertiesPerson = new HashMap<>();
                propertiesPerson.put("name", nameProperties);
                propertiesPerson.put("timestamp", timestampProperties);

                PgNode node = new PgNode((txEventNodeId + internalNodeCounter), labelsPerson, propertiesPerson);
                nodes.add(node);
            }
            for (int i =0; i<RELATIONSHIPS_PER_NODE;i++) {
                Map<String, ArrayList<Object>> propertiesEdge = new HashMap<>();
                propertiesEdge.put("timestamp", timestampProperties);
                ArrayList<String> labelsEdge = new ArrayList<>();
                labelsEdge.add("IS_WITH");
                PgEdge edge = new PgEdge((txEventEdgeId+internalEdgeCounter), txEventEdgeId, endId, labelsEdge, propertiesEdge);
                edges.add(edge);
                endId++;
                if (i>0 && i<(RELATIONSHIPS_PER_NODE-1))
                    internalEdgeCounter++;
            }
            jsonPG = new JsonPG(nodes, edges);
            kafkaProducer.send(new ProducerRecord<>(TOPIC,
                    0,
                            initTimestamp.get(),
                        null,
                            jsonPG));
            kafkaProducer.flush();

            txEventNodeId++;
            txEventEdgeId++;
        }
//        timestampProperties = new ArrayList<>();
//        initTimestamp.set(START_INSTANT.plus(TIME_RANGE).toEpochMilli());
//        timestampProperties.add(0, initTimestamp.get());
//
//        nameProperties = new ArrayList<>();
//        nameProperties.add(0,"P" + (txEventNodeId + internalNodeCounter));
//        propertiesPerson = new HashMap<>();
//        propertiesPerson.put("name", nameProperties);
//        propertiesPerson.put("timestamp", timestampProperties);
//
//        PgNode node = new PgNode((txEventNodeId + internalNodeCounter), labelsPerson, propertiesPerson);
//        nodes = new ArrayList<>();
//        nodes.add(node);
//        kafkaProducer.send(new ProducerRecord<>(TOPIC,
//                0,
//                initTimestamp.get(),
//                null,
//                new JsonPG(nodes, new ArrayList<>())));
//        kafkaProducer.flush();
    }
}
