package engine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is used as token to synchronize the several components
 * </p>
 * <p>
 * Every time a component is in charge to perform actions will write its status
 * on the Seraph state store.
 * A component must read the current agent from the seraph state store to understand if it is
 * its turn or not {@link stateStore.SeraphStateStore}
 * </p>
 */

public class CurrentAgent implements Serializable {

    private String agentName;
    private String status;
    private Long timestamp_to_sync;
//    private Map<String,Object> payload;


    @JsonCreator
    public CurrentAgent(){}

    @JsonCreator
    public CurrentAgent(@JsonProperty("agentName") String agent,
                        @JsonProperty("status") String status,
                        @JsonProperty("timestamp_to_sync") Long timestamp_to_sync){
        this.agentName = agent;
        this.status = status;
        this.timestamp_to_sync = timestamp_to_sync;
//        this.payload = new HashMap<>();
    }


    /**
     * This method is called every time a component read from the state store
     * @param agent     the class name of the component currently performing operations
     * @param status    the status of the current components -- may be "started" or "completed"
     * @param timestamp_to_sync the timestamp when the current component has written on the seraph state store its status
     */
    @JsonIgnore
    public void updateCurrentAgent(String agent, String status, Long timestamp_to_sync){
        this.agentName = agent;
        this.status = status;
        this.timestamp_to_sync = timestamp_to_sync;
    }

    public String getAgentName() { return agentName; }
    public String getStatus() { return status;  }
    public Long getTimestamp_to_sync() { return timestamp_to_sync; }
//    public Map<String, Object> getPayload() { return payload; }


}