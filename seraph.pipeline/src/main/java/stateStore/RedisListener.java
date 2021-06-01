package stateStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.CurrentAgent;
import redis.clients.jedis.JedisPubSub;

public class RedisListener extends JedisPubSub {

    private final CurrentAgent currentAgent;


    public RedisListener(CurrentAgent currentAgent){
        this.currentAgent = currentAgent;
    }

    @Override
    public void onMessage(String channel, String message) {
        CurrentAgent currentAgent;
        ObjectMapper mapper = new ObjectMapper();
        try {
            currentAgent = mapper.readValue(message,CurrentAgent.class);
            this.currentAgent.updateCurrentAgent(currentAgent.getAgentName(),currentAgent.getStatus(),currentAgent.getTimestamp());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if(message.equalsIgnoreCase("quit"))
            this.unsubscribe(channel);
    }


}
