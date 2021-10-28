package dataset;

import cdc_converter.JsonPG;
import cdc_converter.PgEdge;
import cdc_converter.PgNode;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class LinearDataset {
    public static String TOPIC = "test-dataset-small";
    public static String BROKER = "ec2-15-160-92-234.eu-south-1.compute.amazonaws.com:9092";
    public static Instant START_INSTANT = Instant.parse("2021-01-01T00:00:00Z");
    public static Duration TIME_RANGE = Duration.parse("PT1H");
    public static Long PRODUCTION_PERIOD_MS = 15000L;

    public static void main(String[] args) {
        System.out.println("BROKER: " + BROKER);
        System.out.println("TOPIC: " + TOPIC);
        System.out.println("START INSTANT: " + START_INSTANT.toString());
        System.out.println("TIME RANGE: " + TIME_RANGE.toString());

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
        JsonPG jsonPG = new JsonPG(nodes, new ArrayList<>());

        while (initTimestamp.get() < START_INSTANT.plus(TIME_RANGE).toEpochMilli()) {

            timestampProperties = new ArrayList<>();
            initTimestamp.set(initTimestamp.get() + PRODUCTION_PERIOD_MS);
            timestampProperties.add(0, initTimestamp.get());

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
