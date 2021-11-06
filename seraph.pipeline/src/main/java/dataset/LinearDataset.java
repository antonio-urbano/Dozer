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

public class LinearDataset {
    //linear-test-dataset-small: (PRODUCTION period = 15000ms), every minute 4 new links per PT1H = 240 nodes
    //linear-test-dataset: (PRODUCTION period = 500ms) every second 2 new links per P7DT0S = (7*24*60*60*2) = 1209600 nodes
    public static String TOPIC = "linear-test-dataset-small";
    public static String BROKER = "localhost:9092";
    public static Instant START_INSTANT = Instant.parse("2021-01-01T00:00:00Z");
    public static Duration TIME_RANGE = Duration.parse("P7DT0S");
    public static Long PRODUCTION_PERIOD_MS = 500L;

    public static void main(String[] args) {
        System.out.println("BROKER: " + BROKER);
        System.out.println("TOPIC: " + TOPIC);
        System.out.println("START INSTANT: " + START_INSTANT.toString());
        System.out.println("TIME RANGE: " + TIME_RANGE.toString());

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

        AtomicInteger personID = new AtomicInteger(0);
        AtomicInteger edgeId = new AtomicInteger(0);
        ArrayList<String> labelsPerson = new ArrayList<>();
        labelsPerson.add("Person");
        Map<String, ArrayList<Object>> propertiesPerson = new HashMap<>();
        ArrayList<Object> nameProperties = new ArrayList<>();
        nameProperties.add("P" + personID.toString());
        ArrayList<Object> timestampProperties = new ArrayList<>();
        timestampProperties.add(initTimestamp.get());
        propertiesPerson.put("name", nameProperties);
        propertiesPerson.put("timestamp", timestampProperties);
        PgNode node = new PgNode(personID.get(), labelsPerson, propertiesPerson);
        ArrayList<PgNode> nodes = new ArrayList<>();
        nodes.add(node);
        JsonPG jsonPG;


        while (initTimestamp.get() < START_INSTANT.plus(TIME_RANGE).toEpochMilli()) {

            nameProperties = new ArrayList<>();
            nameProperties.add("P" + (personID.get()+1));

            timestampProperties = new ArrayList<>();
            initTimestamp.set(initTimestamp.get() + PRODUCTION_PERIOD_MS);
            timestampProperties.add(0, initTimestamp.get());

            propertiesPerson.put("name", nameProperties);
            propertiesPerson.put("timestamp", timestampProperties);

            node = new PgNode(personID.get() + 1, labelsPerson, propertiesPerson);
            nodes.set(0, node);

            Map<String, ArrayList<Object>> propertiesEdge = new HashMap<>();
            propertiesEdge.put("timestamp", timestampProperties);
            ArrayList<String> labelsEdge = new ArrayList<>();
            labelsEdge.add("IS_WITH");
            PgEdge edge = new PgEdge(edgeId.get(), personID.get(), personID.get() + 1, labelsEdge, propertiesEdge);
            edgeId.set(edgeId.get() + 1);
            ArrayList<PgEdge> edges = new ArrayList<>();
            edges.add(edge);

            jsonPG = new JsonPG(nodes, edges);
            kafkaProducer.send(new ProducerRecord<>(TOPIC,
                    0,
                    initTimestamp.get(),
                    null,
                    jsonPG));
            kafkaProducer.flush();

            personID.set(personID.get() + 1);
        }
    }
}
