package engine;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonRootName("outputObj")
public class OutputObj implements Serializable {


    /**
     *
     */
    private Map meta;
    private Map payload;
    private Map schema;
    private Neo4jObj neo4jObj;


    @JsonCreator
    public OutputObj(@JsonProperty("neo4jObj") Neo4jObj neo4jObj){
        this.neo4jObj = neo4jObj;
        this.meta = this.neo4jObj.getMeta();
        this.payload = this.neo4jObj.getPayload();
        this.schema = this.neo4jObj.getSchema();
        this.setBefore((Map) this.neo4jObj.getPayload().get("after"));
        this.setAfter(null);
        this.meta.put("operation", "deleted");
        this.meta.computeIfPresent("timestamp", (k,v)-> ((long)v)+60000);

    }




    public Map getMeta() {
        return this.meta;
    }

    public Map getPayload() {
        return this.payload;
    }

    public Map getSchema() {
        return this.schema;
    }


    private void setAfter(Map afterRecord) {this.payload.put("after", afterRecord); }
    private void setBefore(Map beforeRecord) {this.payload.put("before", beforeRecord); }

}
