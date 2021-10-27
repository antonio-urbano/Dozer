package cdc_converter;

import config.DozerConfig;
import config.KafkaConfigProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProcessorConverter implements Processor<String, JsonPG> {

    private ProcessorContext context;
    private Producer<String, CdcCreateRecord> kafkaProducer;

    @Override
    public void init(final ProcessorContext context) {
        this.context = context;
        this.kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties("converter"));
    }

    @Override
    public void process(String key, JsonPG pg) {
        Integer txEventsCount = pg.getNodes().size() + pg.getEdges().size();
        for (PgNode node:pg.getNodes()){//todo params meta
            CdcCreateRecord cdcNode = new CdcCreateRecord(generateMeta(DozerConfig.getNeo4jUsername(), node.getId(),
                    pg.getNodes().indexOf(node), txEventsCount, DozerConfig.getNeo4jHostname()),
                    generateNodePayload(node), generateSchema(node));
            kafkaProducer.send(new ProducerRecord<>(DozerConfig.getCdcCreateNodesTopic(), 0, this.context.timestamp(), key,cdcNode));
            kafkaProducer.flush();
        }
        for (PgEdge edge:pg.getEdges()){//todo params meta
            CdcCreateRecord cdcEdge = new CdcCreateRecord(generateMeta(DozerConfig.getNeo4jUsername(), edge.getId(),
                    pg.getEdges().indexOf(edge)+pg.getNodes().size(),
                    txEventsCount, DozerConfig.getNeo4jHostname()),
                    generateRelationshipPayload(edge), generateSchema(edge));
            kafkaProducer.send(new ProducerRecord<>(DozerConfig.getCdcCreateRelationshipsTopic(), 0,this.context.timestamp(), key,cdcEdge));
            kafkaProducer.flush();
        }

    }

    @Override
    public void close() { this.kafkaProducer.close(); }


    private Map generateMeta(String username, Integer txId, Integer txEventId, Integer txEventsCount,
                        String hostname){
        Map meta = new HashMap();
        meta.put("timestamp", this.context.timestamp());
        meta.put("username", username);
        meta.put("txId", txId);
        meta.put("txEventId", txEventId);
        meta.put("txEventsCount", txEventsCount);
        meta.put("operation", "created");
        Map source =new HashMap();
        source.put("hostname", hostname);
        meta.put("source", source);

        return meta;
    }

    private Map generateNodePayload(PgNode node){
        Map payload = new HashMap();

        payload.put("id", Integer.toString(node.getId()));
        payload.put("before", null);
        Map after = new HashMap();
        Map<String,Object> properties = new LinkedHashMap();
        if (node.getProperties()!=null)
            node.getProperties().forEach((k,v) -> properties.computeIfAbsent(k, x ->v.get(0)));
        after.put("properties", properties);
        after.put("labels", node.getLabels());
        payload.put("after", after);
        payload.put("type", "node");

        return payload;
    }

    private Map generateRelationshipPayload(PgEdge edge){
        Map payload = new HashMap();

        //"payload":{"id":"1",
        // "start":{"id":"2","labels":["Patient"],"ids":{}},
        // "end":{"id":"3","labels":["Virus"],"ids":{}}
        // ,"before":null,
        // "after":{"properties":{"positive":true}},
        // "label":"TESTED_FOR","type":"relationship"}
        payload.put("id", Integer.toString(edge.getId()));
        payload.put("start", getStartNode(edge));
        payload.put("end", getEndNode(edge));
        payload.put("before", null);
        Map after = new HashMap();
        Map<String,Object> properties = new LinkedHashMap();
        if (edge.getProperties()!=null)
            edge.getProperties().forEach((k,v) -> properties.computeIfAbsent(k, x ->v.get(0)));
        after.put("properties", properties);
        payload.put("after", after);
        payload.put("label", edge.getLabels().get(0));
        payload.put("type", "relationship");

        return payload;
    }
    private static Map getStartNode(PgEdge edge){
        Map start = new HashMap();
        start.put("id", Integer.toString(edge.getFrom()));
        Map ids = new HashMap();
        start.put("ids", ids);  //todo ids if constraints
        ArrayList<String> labels = new ArrayList<>();
        start.put("labels", labels);//todo labels
        return start;
    }
    private static Map getEndNode(PgEdge edge){
        Map end = new HashMap();
        end.put("id", Integer.toString(edge.getTo()));
        Map ids = new HashMap();
        end.put("ids", ids);  //todo ids if constraints
        ArrayList<String> labels = new ArrayList<>();
        end.put("labels", labels);//todo labels
        return end;
    }


    public Map generateSchema(PgNode node){
        Map schema = new HashMap();
        Map<String,Object> properties = new HashMap<>();
        if (node.getProperties()!=null)
            node.getProperties().forEach((k,v) -> properties.computeIfAbsent(k, x ->v.get(0).getClass().getSimpleName()));
        schema.put("properties", properties);
        schema.put("constraints", new ArrayList<>()); //todo constraints
        return schema;
    }

    public Map generateSchema(PgEdge edge){
        Map schema = new HashMap();
        Map<String,Object> properties = new HashMap<>();
        if (edge.getProperties()!=null)
            edge.getProperties().forEach((k,v) -> properties.computeIfAbsent(k, x ->v.get(0).getClass().getSimpleName()));
        schema.put("properties", properties);
        schema.put("constraints", new ArrayList<>()); //todo constraints
        return schema;
    }

}
