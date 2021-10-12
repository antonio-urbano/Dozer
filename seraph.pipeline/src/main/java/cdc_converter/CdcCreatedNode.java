package cdc_converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CdcCreatedNode {
    Map meta;
    Map payload;
    Map schema;

    @JsonCreator
    public CdcCreatedNode(){
        this.meta = new HashMap();
        this.payload = new HashMap();
        this.schema = new HashMap();
    }

    @JsonIgnore
    public void setMeta(String username, Integer txId, Integer txEventId, Integer txEventsCount,
                        String hostname){
        this.meta.put("timestamp", System.currentTimeMillis());
        this.meta.put("username", username);
        this.meta.put("txId", txId);
        this.meta.put("txEventId", txEventId);
        this.meta.put("txEventsCount", txEventsCount);
        this.meta.put("operation", "created");
        Map source =new HashMap();
        source.put("hostname", hostname);
        this.meta.put("source", source);
    }

    @JsonIgnore
    public void setPayload(String id, Map properties, ArrayList labels){
        this.payload.put("id", id);
        this.payload.put("before", null);
        Map after = new HashMap();
        after.put("properties", properties);
        after.put("labels", labels);
        this.payload.put("after", after);
        this.payload.put("type", "node");
    }

    @JsonIgnore
    public void setSchema(Map properties, ArrayList constraints){
        this.schema.put("properties", properties);
        this.schema.put("constraints", constraints);
    }

    public Map getMeta() {
        return meta;
    }

    public Map getPayload() {
        return payload;
    }

    public Map getSchema() {
        return schema;
    }
}
