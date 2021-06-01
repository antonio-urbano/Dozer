package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CurrentAgent {

    private String agentName;
    private String status;
    private long timestamp;

    @JsonIgnore
    public synchronized void updateCurrentAgent(String agent, String status, long timestamp){
        this.agentName = agent;
        this.status = status;
        this.timestamp = timestamp;
    }

    @JsonIgnore
    public synchronized void updateCurrentAgent(CurrentAgent currentAgent){
        this.agentName = currentAgent.getAgentName();
        this.status = currentAgent.getStatus();
        this.timestamp = currentAgent.getTimestamp();
    }

    public synchronized String getAgentName() { return agentName; }
    public synchronized String getStatus() { return status;  }
    public synchronized long getTimestamp() { return timestamp; }
}