package cdc_converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import config.KafkaConfigProperties;
import engine.KafkaResultProducer;
import engine.Neo4jObj;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class PgCdcConverter {
    public static Map generateMeta(){
        Map meta = new LinkedHashMap();
        meta.put("timestamp", System.currentTimeMillis());
        //"username":"neo4j","txId":9,"txEventId":0,"txEventsCount":3,
        meta.put("username", "neo4j"); //todo
        meta.put("txId", 9); //todo
        meta.put("txEventId", 0); //todo
        meta.put("txEventsCount", 3); //todo
        meta.put("operation", "created");
        //"source":{"hostname":"neo4j-source"}} todo
        Map source = new LinkedHashMap();
        source.put("hostname", "neo4j-source");
        meta.put("source", source);
        return meta;
    }

    public static Map generatePayload(PgNode node) {
        Map payload = new LinkedHashMap();
        payload.put("id", node.getId());
        payload.put("before", null);
        payload.put("after", getAfterPayload(node));
        payload.put("type", "node");
        return payload;
    }
    public static Map generatePayload(PgEdge edge) {
        Map payload = new LinkedHashMap();
        payload.put("id", edge.getId());
        payload.put("start", getStartNode(edge));
        payload.put("end", getEndNode(edge));
        payload.put("before", null);
        payload.put("after", getAfterPayload(edge));
        payload.put("label", edge.getLabels());
        payload.put("type", "relationship");
        return payload;
    }

    public static Map getAfterPayload(PgNode node) {
        Map after = new LinkedHashMap();
        //properties
        Map<String,Object> properties = new LinkedHashMap();
        if (node.getProperties()!=null)
            node.getProperties().forEach((k,v) -> properties.computeIfAbsent(k, x ->v.get(0)));
        after.put("properties", properties);
        after.put("labels", node.getLabels());
        return after;
    }

    public static Map getAfterPayload(PgEdge edge) {
        Map after = new LinkedHashMap();
        Map<String,Object> properties = new LinkedHashMap();
        if (edge.getProperties()!=null)
            edge.getProperties().forEach((k,v) -> properties.computeIfAbsent(k, x ->v.get(0)));
        after.put("properties", properties);
        return after;
    }
    private static Map getStartNode(PgEdge edge){
        Map start = new LinkedHashMap();
        start.put("id", edge.getFrom());
        Map ids = new LinkedHashMap();
        start.put("id", ids);  //todo ids if constraints
        ArrayList<String> labels = new ArrayList<>();
        start.put("labels", labels);//todo labels
        return start;
    }
    private static Map getEndNode(PgEdge edge){
        Map end = new LinkedHashMap();
        end.put("id", edge.getTo());
        Map ids = new LinkedHashMap();
        end.put("id", ids);  //todo ids if constraints
        ArrayList<String> labels = new ArrayList<>();
        end.put("labels", labels);//todo labels
        return end;
    }

    public static Map generateSchema(PgNode node) {
        Map schema = new LinkedHashMap();
        Map<String,Object> propertiesSchema = new LinkedHashMap();
        if (node.getProperties()!=null)
            node.getProperties().forEach((k,v) -> propertiesSchema.computeIfAbsent(k, x ->v.get(0).getClass().getSimpleName()));
        schema.put("properties", propertiesSchema);
        schema.put("constraints", new ArrayList<>()); //todo constraints
        return schema;
    }
    public static Map generateSchema(PgEdge edge) {
        Map schema = new LinkedHashMap();
        Map<String,Object> propertiesSchema = new LinkedHashMap();
        if (edge.getProperties()!=null)
            edge.getProperties().forEach((k,v) -> propertiesSchema.computeIfAbsent(k, x ->v.get(0).getClass().getSimpleName()));
        schema.put("properties", propertiesSchema);
        schema.put("constraints", new ArrayList<>());  //todo constraints
        return schema;
    }

    public static Map<String,ArrayList<Object>> jsonToPGpropertiesMap(JSONObject JSONpropertiesPG){
        Iterator<String> keys = JSONpropertiesPG.keys();
        Map<String, ArrayList<Object>> properties = new HashMap<>();
        while(keys.hasNext()) {
            String key = keys.next();
            if(JSONpropertiesPG.get(key) instanceof JSONArray){
                ArrayList<Object> tempPropArray = new ArrayList<>();
                JSONArray jArray = (JSONArray)JSONpropertiesPG.get(key);
                if (jArray != null) {
                    for (int i=0;i<jArray.length();i++){
                        tempPropArray.add(jArray.get(i));
                    }
                }
                properties.put(key, tempPropArray);
            }
        }
        return properties;
    }

    public static void main(final String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("/home/antonio/Scrivania/test_2.json"));
        PropertyGraph pg = new Gson().fromJson(br, PropertyGraph.class);

        System.out.println(new JSONObject(pg));
        System.out.println(pg.getNodes().size() + "   " + pg.getEdges().size());
        System.out.println("-------------- Node -----------------");
        final Producer<String, Neo4jObj> prod = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());

        for (int i=0;i<pg.getNodes().size();i++) {
            PgNode pgNode= pg.getNodes().get(i);
            if (pgNode!=null) {
                Neo4jObj createNodeRecord = new Neo4jObj(generateMeta(), generatePayload(pgNode), generateSchema(pgNode));
                System.out.println(new JSONObject(createNodeRecord));
                System.out.println(" ");
                prod.send(new ProducerRecord<>("time-managed-topic", createNodeRecord));
                prod.flush();
            }
        }
        System.out.println("--------------Edge ---------------");
        for (int i=0;i<pg.getEdges().size();i++) {
            PgEdge pgEdge = pg.getEdges().get(i);
            if (pgEdge != null) {
                Neo4jObj createEdgeRecord = new Neo4jObj(generateMeta(), generatePayload(pgEdge), generateSchema(pgEdge));
                System.out.println(new JSONObject(createEdgeRecord));
                prod.send(new ProducerRecord<>("time-managed-topic", createEdgeRecord));
                prod.flush();

            }
        }
            /*
        Map<String,Object> prop = new LinkedHashMap();
        prop.put("name", "Antonio");
        prop.put("last_name", "Urbano");
        prop.put("age", 25L);
        Map<String, ArrayList<Object>> propertiesPG = new HashMap<>();
        prop.forEach((k,v)-> propertiesPG.computeIfAbsent(k, x ->new ArrayList<>()).add(v));
        System.out.println("-------- Properties in Cdc ------------");
        System.out.println(new JSONObject(prop));
        System.out.println("---------------------------------------");
        System.out.println("-------- Properties in PG ------------");
        System.out.println(new JSONObject(propertiesPG));
        System.out.println("---------------------------------------");

        Map<String,ArrayList<Object>> properties = new HashMap<>();
        JSONObject propPgJSON = new JSONObject(propertiesPG);
        properties = jsonToPGpropertiesMap(propPgJSON);
        Map<String,Object> result = new LinkedHashMap();
        properties.forEach((k,v) -> result.computeIfAbsent(k, x ->v.get(0).getClass().getSimpleName()));
        System.out.println("-------- Properties in PG nuovamente ------------");
        System.out.println(new JSONObject(properties));
        System.out.println("---------------------------------------");
        System.out.println("-------- Properties in CDC nuovamente ------------");
        System.out.println(new JSONObject(result));
        System.out.println("---------------------------------------");
        Map schema = new LinkedHashMap();
        schema.put("properties", result);
        schema.put("constraints", new ArrayList<>());
        System.out.println(new JSONObject(schema));
        */
//        BufferedReader br_cdc = new BufferedReader(new FileReader("/home/antonio/Scrivania/cdcRecord.json"));
//        Neo4jObj neo = new Gson().fromJson(br_cdc, Neo4jObj.class);
//        final Producer<String, Map<String,Object>> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
//        prod.producerResultRecord("time-managed-topic", neo);
        BufferedReader br_cdc = new BufferedReader(new FileReader("/home/antonio/Scrivania/test_cdc.json"));
        Neo4jObj neo = new Gson().fromJson(br_cdc, Neo4jObj.class);
        prod.send(new ProducerRecord<>("time-managed-topic", neo));
        prod.flush();
    }
}
