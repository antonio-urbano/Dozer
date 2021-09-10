package engine;

import application.DozerApplication;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * This class is used as token to synchronize the several processors in the topology of
 * the Dozer Application {@link DozerApplication}
 */

public class CurrentAgent implements Serializable {

    private String agentName;
    private String status;
    private Long timestampToSync;


    @JsonCreator
    public CurrentAgent(){}

    /**
     * @param agent     the class name of the component currently performing operations
     * @param status    the status of the current components -- may be "started" or "completed"
     * @param timestampToSync the last timestamp to which all the components has to synchronize
     */
    @JsonCreator
    public CurrentAgent(@JsonProperty("agentName") String agent,
                        @JsonProperty("status") String status,
                        @JsonProperty("timestampToSync") Long timestampToSync){
        this.agentName = agent;
        this.status = status;
        this.timestampToSync = timestampToSync;
    }

    public String getAgentName() { return agentName; }
    public String getStatus() { return status;  }
    public Long getTimestampToSync() { return timestampToSync; }

}