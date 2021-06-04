package engine;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

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

public class CurrentAgent {

    private String agentName;
    private String status;
    private long timestamp;


    @JsonCreator
    public CurrentAgent(){}

    @JsonIgnore
    public CurrentAgent(String agent, String status){
        this.agentName = agent;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * This method is called every time a component read from the state store
     * @param agent     the class name of the component currently performing operations
     * @param status    the status of the current components -- may be "started" or "completed"
     * @param timestamp the timestamp when the current component has written on the seraph state store its status
     */
    @JsonIgnore
    public void updateCurrentAgent(String agent, String status, long timestamp){
        this.agentName = agent;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getAgentName() { return agentName; }
    public String getStatus() { return status;  }
    public long getTimestamp() { return timestamp; }
}