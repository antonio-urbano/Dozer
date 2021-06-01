package engine;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CurrentAgent {

    private String agent;
    private String status;
    private long timestamp;

    @JsonIgnore
    public synchronized CurrentAgent getCurrentAgent(){ return this;}

    @JsonIgnore
    public synchronized void updateCurrentAgent(String agent, String status, long timestamp){
        this.agent = agent;
        this.status = status;
        this.timestamp = timestamp;
    }

    /*
   @Override
    public String toString() {
        return "{" +
                "agent=" + agent +
                ", status='" + status +
                ", timestamp='" + timestamp +
                '\'' +
                '}';
    }*/

    public synchronized String getAgent() { return agent; }

    public synchronized void setAgent(String agent) { this.agent = agent; }

    public synchronized String getStatus() { return status;  }

    public synchronized void setStatus(String status) { this.status = status; }

    public synchronized long getTimestamp() { return timestamp; }

    public synchronized void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}