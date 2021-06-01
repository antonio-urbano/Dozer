package stateStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.CurrentAgent;
import redis.clients.jedis.JedisPubSub;

public class PubSubRedisStateStore implements SeraphStateStore{

    final static int JEDIS_PORT = 6379;
    final static String JEDIS_HOST="localhost";

    private RedisPublisher publisher;
    private RedisSubscriber subscriber;
    private ObjectMapper mapper;
    private final CurrentAgent currentAgent;

    public PubSubRedisStateStore(CurrentAgent currentAgent){
        this.mapper = new ObjectMapper();
        this.currentAgent=currentAgent;
    }

    @Override
    public void writeState(String channel, CurrentAgent currentAgent) {
        String agentString = "";
        try {
            agentString = mapper.writeValueAsString(currentAgent);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        this.publisher = new RedisPublisher(JEDIS_HOST, JEDIS_PORT);
        if (agentString!="")
            this.publisher.pub(channel, agentString);
        System.err.println("*** Class: " + agentString + "  ***");
    }

    @Override
    public void subscribeChannel(String channel) {
        this.subscriber = new RedisSubscriber(JEDIS_HOST, JEDIS_PORT);
        JedisPubSub listener = new RedisListener(this.currentAgent);
        this.subscriber.setChannelAndListener(listener,channel);
        this.subscriber.start();
    }




}
