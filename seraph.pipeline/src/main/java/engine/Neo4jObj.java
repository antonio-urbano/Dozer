package engine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This class is used to (de)serialize the record in CDC format
 * {@see https://neo4j.com/labs/kafka/4.0/producer/}
 */
@JsonRootName("neo4jObj")
public class Neo4jObj implements Serializable {

    private Map meta = new LinkedHashMap();
    private Map payload = new LinkedHashMap();
    private Map schema = new LinkedHashMap();



    public Neo4jObj() {

    }

    @JsonCreator
    public Neo4jObj(@JsonProperty("meta") Map meta,
                    @JsonProperty("payload") Map payload,
                    @JsonProperty("schema") Map schema){
        this.meta = meta;
        this.payload = payload;
        this.schema = schema;
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

}