package application;

import config.DozerConfig;
import config.KafkaConfigProperties;
import engine.CurrentAgent;
import okhttp3.*;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.config.TopicConfig;
import org.json.JSONObject;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import seraphGrammar.RegisterQuery;
import system.Neo4jDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class DozerSetup {
    public static final String START_AGENT_NAME = "SERAPH_QUERY_PARSED";
    public static final String CONNECTOR_NAME = "dozerconnector";

    public static boolean isFreshStart() {
        final String WORKFLOW_TOPIC = DozerConfig.getWorkFlowTopic();
        final TopicPartition TOPIC_PARTITION = new TopicPartition(WORKFLOW_TOPIC, 0);

        ConsumerFactory<String, Object> cf = new DefaultKafkaConsumerFactory<>(KafkaConfigProperties.getKafkaConsumerProperties(CurrentAgent.class));
        Consumer<String, Object> consumer = cf.createConsumer();
        consumer.assign(Collections.singletonList(TOPIC_PARTITION));

        consumer.seek(
                TOPIC_PARTITION,
                consumer.beginningOffsets(Collections.singletonList(TOPIC_PARTITION)).get(TOPIC_PARTITION));

        ConsumerRecords<String, Object> records;
        do {
            records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, Object> record : records.records(TOPIC_PARTITION)) {
                CurrentAgent currentAgent = (CurrentAgent) record.value();
                if (currentAgent.getAgentName().equals(START_AGENT_NAME)) {
                    consumer.close();
                    return false;
                }
            }
        } while (!records.isEmpty());

        return true;
    }

    public static void createStartMessage() {
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties("parser")); //todo
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(),
                new CurrentAgent(START_AGENT_NAME,
                        "completed", 0L))); //todo move this in BullDozer
        kafkaProducer.flush();
        kafkaProducer.close();
    }

    public static void deleteTopics() {
        Properties adminClientProps = new Properties();
        adminClientProps.put("bootstrap.servers", DozerConfig.getKafkaBroker());

        AdminClient adminClient = KafkaAdminClient.create(adminClientProps);

        try {
            DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(List.of(
                    DozerConfig.getCdcCreateRelationshipsTopic(),
                    DozerConfig.getCdcDeleteRelationshipsTopic(),
                    DozerConfig.getCdcCreateNodesTopic(),
                    DozerConfig.getWorkFlowTopic(),
                    DozerConfig.getNeo4jPluginRelationshipsTopic(),
                    ((RegisterQuery) DozerConfig.getSeraphQuery()).getSeraphQuery().getOutputStream()
            ));
            while (!deleteTopicsResult.all().isDone()) {};
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static NewTopic createTopicWithInfiniteRetention(String topicName) {
        NewTopic kafkaTopic = new NewTopic(topicName, 1, (short) 1);
        kafkaTopic.configs(Map.of(TopicConfig.RETENTION_MS_CONFIG, "-1"));
        return kafkaTopic;
    }

    public static void createTopics() {
        Properties adminClientProps = new Properties();
        adminClientProps.put("bootstrap.servers", DozerConfig.getKafkaBroker());

        AdminClient adminClient = KafkaAdminClient.create(adminClientProps);

        try {
            CreateTopicsResult createTopicsResult = adminClient.createTopics(List.of(
                    createTopicWithInfiniteRetention(DozerConfig.getCdcCreateRelationshipsTopic()),
                    createTopicWithInfiniteRetention(DozerConfig.getCdcDeleteRelationshipsTopic()),
                    createTopicWithInfiniteRetention(DozerConfig.getCdcCreateNodesTopic()),
                    createTopicWithInfiniteRetention(DozerConfig.getWorkFlowTopic()),
                    createTopicWithInfiniteRetention(DozerConfig.getNeo4jPluginRelationshipsTopic()),
                    createTopicWithInfiniteRetention(((RegisterQuery) DozerConfig.getSeraphQuery()).getSeraphQuery().getOutputStream())
            ));
            while(!createTopicsResult.all().isDone()) {};
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void deleteAllFromNeo4j() {
        final String QUERY = "MATCH(n) DETACH DELETE n;";
        Neo4jDriver driver = new Neo4jDriver(DozerConfig.getNeo4jBolt(),DozerConfig.getNeo4jUsername(), DozerConfig.getNeo4jPassword());

        Result result = driver.runQuery(QUERY);
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void deleteNeo4jPlugin() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        Request request = new Request.Builder()
                .url("http://" + DozerConfig.getKafkaConnect() + "/connectors/" + CONNECTOR_NAME)
                .method("DELETE", RequestBody.create(new byte[]{}))
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void createNeo4jPlugin() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/json");
        String bodyString = getKafkaConnectRequestBody().toString();
        RequestBody body = RequestBody.create(mediaType,
                getKafkaConnectRequestBody().toString());

        Request request = new Request.Builder()
                .url("http://" + DozerConfig.getKafkaConnect() + "/connectors")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            assert response.isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static JSONObject getKafkaConnectRequestBody() {

        Map connector = new HashMap();
        connector.put("name", CONNECTOR_NAME);

        Map config = new HashMap();
        config.put("connector.class", "streams.kafka.connect.sink.Neo4jSinkConnector");
        config.put("key.converter", "org.apache.kafka.connect.storage.StringConverter");
        config.put("value.converter", "org.apache.kafka.connect.json.JsonConverter");
        config.put("value.converter.schemas.enable", false);
        config.put("topics", DozerConfig.getCdcCreateNodesTopic() + "," + DozerConfig.getNeo4jPluginRelationshipsTopic());
        config.put("neo4j.topic.cdc.sourceId", DozerConfig.getCdcCreateNodesTopic() + ";" + DozerConfig.getNeo4jPluginRelationshipsTopic());
        config.put("errors.retry.timeout", "-1");
        config.put("errors.retry.delay.max.ms", "1000");
        config.put("errors.tolerance", "all");
        config.put("errors.log.enable", true);
        config.put("errors.log.include.messages", true);
        config.put("neo4j.server.uri", DozerConfig.getKafkaConnectNeo4jBolt());
        config.put("neo4j.authentication.basic.username", DozerConfig.getNeo4jUsername());
        config.put("neo4j.authentication.basic.password", DozerConfig.getNeo4jPassword());
        config.put("neo4j.encryption.enabled", false);
        config.put("kafka.bootstrap.servers", DozerConfig.getKafkaBrokerConnector());
        connector.put("config", config);

        return new JSONObject(connector);
    }
}
