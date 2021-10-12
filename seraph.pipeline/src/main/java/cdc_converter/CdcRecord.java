package cdc_converter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonRootName("cdcRecord")
public class CdcRecord implements Serializable {
    Map meta;
    Map payload;
    Map schema;

    @JsonCreator
    public CdcRecord(@JsonProperty("meta") Map meta,
                     @JsonProperty("payload") Map payload,
                     @JsonProperty("schema") Map schema){
        this.meta = meta;
        this.payload = payload;
        this.schema = schema;
    }

    public Map getMeta() {
        return meta;
    }

    @JsonIgnore
    public void setMeta(Map meta) {
        this.meta = meta;
    }

    public Map getPayload() {
        return payload;
    }

    @JsonIgnore
    public void setPayload(Map payload) {
        this.payload = payload;
    }

    public Map getSchema() {
        return schema;
    }

    @JsonIgnore
    public void setSchema(Map schema) {
        this.schema = schema;
    }
}
