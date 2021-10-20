package application;

import seraphGrammar.Query;
import seraphGrammar.SeraphQueryParser;

public class DozerConfig {
    public static Query getSeraphQuery() {
        return SeraphQueryParser.parse(System.getenv("SERAPH_QUERY"));
    }

    public static String getKafkaBroker() {
        return System.getenv("KAFKA_BROKER");
    }

    public static String getCdcDeleteRelationshipsTopic() {
        return System.getenv("CDC_DELETE_RELATIONSHIPS_TOPIC");
    }

    public static String getCdcCreateRelationshipsTopic() {
        return System.getenv("CDC_CREATE_RELATIONSHIPS_TOPIC");
    }

    public static String getCdcCreateNodesTopic() {
        return System.getenv("NEO4J_PLUGIN_NODES_TOPIC");
    }

    public static String getNeo4jHostname() {
        return System.getenv("NEO4J_HOSTNAME");
    }
    public static String getNeo4jBolt() {
        return System.getenv("NEO4J_BOLT");
    }

    public static String getNeo4jUsername() {
        return System.getenv("NEO4J_USERNAME");
    }

    public static String getNeo4jPassword() {
        return System.getenv("NEO4J_PASSWORD");
    }

    public static String getNeo4jPluginNodesTopic() {
        return System.getenv("NEO4J_PLUGIN_NODES_TOPIC");
    }

    public static String getNeo4jPluginRelationshipsTopic() {
        return System.getenv("NEO4J_PLUGIN_RELATIONSHIPS_TOPIC");
    }

    public static String getWorkFlowTopic() {
        return System.getenv("WORKFLOW_TOPIC");
    }
}
