package cdc_converter;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Map;

/**
 * This class is used to serialize/deserialize the deletion record in CDC format.
 * The deletion record is generated starting from the {@link CdcCreateRecord} object.
 */
@JsonRootName("cdcDelete")
public class CdcDeleteRecord implements Serializable {

    private Map meta;
    private Map payload;
    private Map schema;
    private CdcCreateRecord cdcCreate;


    /**
     * The outputObj corresponds to the "deletion" record in CDC format. It is built
     * starting from the cdcCreateRecord
     * @param cdcCreate object corresponding to the "creation" record in CDC format
     * @param windowTimeRange size of the window for delaying the deletion
     */
    @JsonCreator
    public CdcDeleteRecord(@JsonProperty("cdcCreate") CdcCreateRecord cdcCreate, @JsonProperty("windowTimeRange") Long windowTimeRange){
        if (cdcCreate!=null) {
            this.cdcCreate = cdcCreate;
            this.meta = this.cdcCreate.getMeta();
            this.payload = this.cdcCreate.getPayload();
            this.schema = this.cdcCreate.getSchema();
            this.setBefore((Map) this.cdcCreate.getPayload().get("after"));
            this.setAfter(null);
            this.meta.put("operation", "deleted");
            this.meta.computeIfPresent("timestamp", (k, v) -> ((long) v) + windowTimeRange);
        }
    }

    public Map getMeta() { return this.meta; }
    public Map getPayload() { return this.payload; }
    public Map getSchema() { return this.schema; }

    private void setAfter(Map afterRecord) {this.payload.put("after", afterRecord); }
    private void setBefore(Map beforeRecord) {this.payload.put("before", beforeRecord); }
}
