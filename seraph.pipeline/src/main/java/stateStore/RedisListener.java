package stateStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.CurrentAgent;
import redis.clients.jedis.JedisPubSub;

public class RedisListener extends JedisPubSub {

    private final CurrentAgent currentAgent;
    private ObjectMapper mapper;


    public RedisListener(CurrentAgent currentAgent){
        this.currentAgent = currentAgent;
        this.mapper = new ObjectMapper();
    }

    @Override
    public void onMessage(String channel, String message) {
        CurrentAgent currentAgent = null;
        try {
            currentAgent = mapper.readValue(message,CurrentAgent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        if (currentAgent!=null)
            this.currentAgent.updateCurrentAgent(currentAgent.getAgent(),currentAgent.getStatus(),currentAgent.getTimestamp());
        if(message.equalsIgnoreCase("quit")){
            this.unsubscribe(channel);
        }
    }


}
