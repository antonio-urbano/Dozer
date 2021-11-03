package config;

import seraphGrammar.Query;
import seraphGrammar.SeraphQueryParser;

import java.util.Objects;

public class DozerConfig {
    public static Query getSeraphQuery() {
        return SeraphQueryParser.parse(System.getenv("SERAPH_QUERY"));
    }

    private static String getEnv(String name) {
        String value = System.getenv(name);
        Objects.requireNonNull(value, name + " env variable not set!");
        System.out.println(name + " : " + value);
        return value;
    }

    public static String getKafkaBroker() {
        // expecting something like localhost:9092
        return getEnv("KAFKA_BROKER");
    }

    public static String getKafkaBrokerConnector() {
        // expecting something like localhost:9093
        return getEnv("KAFKA_BROKER_CONNECTOR");
    }

    public static String getKafkaConnect() {
        // expecting something like localhost:8083
        return getEnv("KAFKA_CONNECT");
    }

    public static String getNeo4jHostname() {
        // expecting something like localhost
        return getEnv("NEO4J_HOSTNAME");
    }

    public static String getNeo4jBolt() {
        // expecting something like bolt://localhost:7687
        return getEnv("NEO4J_BOLT");
    }

    public static String getKafkaConnectNeo4jBolt() {
        // expecting something like bolt://localhost:7687
        return getEnv("KAFKA_CONNECT_NEO4J_BOLT");
    }

    public static String getStopDatetime() {
        // expecting something like 2021-01-01T00:00:00Z or -1
        return getEnv("STOP_DATETIME");
    }

    public static String isSummaryTest() {
        // expecting "true" or "false"
        return getEnv("IS_SUMMARY_TEST");
    }

    public static String getNeo4jUsername() {
        return getEnv("NEO4J_USERNAME");
    }

    public static String getNeo4jPassword() {
        return getEnv("NEO4J_PASSWORD");
    }

    public static Boolean getForceRestart() {
        return Boolean.valueOf(getEnv("FORCE_RESTART"));
    }

    public static String getCdcDeleteRelationshipsTopic() {
        return "CDC_DELETE_RELATIONSHIPS_TOPIC";
    }

    public static String getCdcCreateRelationshipsTopic() {
        return "CDC_CREATE_RELATIONSHIPS_TOPIC";
    }

    public static String getCdcCreateNodesTopic() {
        return "NEO4J_PLUGIN_NODES_TOPIC";
    }

    public static String getNeo4jPluginRelationshipsTopic() {
        return "NEO4J_PLUGIN_RELATIONSHIPS_TOPIC";
    }

    public static String getWorkFlowTopic() {
        return "WORKFLOW_TOPIC";
    }
}
