package config;

import seraphGrammar.Query;
import seraphGrammar.SeraphQueryParser;

public class DozerConfig {
    public static Query getSeraphQuery() {
        return SeraphQueryParser.parse(System.getenv("SERAPH_QUERY"));
    }

    public static String getKafkaBroker() {
        // expecting something like localhost:9092
        return System.getenv("KAFKA_BROKER");
    }

    public static String getKafkaBrokerConnector() {
        // expecting something like localhost:9093
        return System.getenv("KAFKA_BROKER_CONNECTOR");
    }

    public static String getKafkaConnect() {
        // expecting something like localhost:8083
        return System.getenv("KAFKA_CONNECT");
    }

    public static String getNeo4jHostname() {
        // expecting something like localhost
        return System.getenv("NEO4J_HOSTNAME");
    }

    public static String getNeo4jBolt() {
        // expecting something like bolt://localhost:7687
        return System.getenv("NEO4J_BOLT");
    }

    public static String getNeo4jUsername() {
        return System.getenv("NEO4J_USERNAME");
    }

    public static String getNeo4jPassword() {
        return System.getenv("NEO4J_PASSWORD");
    }

    public static Boolean getForceRestart() {
        return Boolean.valueOf(System.getenv("FORCE_RESTART"));
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
