package stateStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.CurrentAgent;
import redis.clients.jedis.JedisPubSub;

public class PubSubRedisStateStore implements SeraphStateStore{


    final static int JEDIS_PORT = 6379;
    final static String JEDIS_HOST="localhost";


    private final CurrentAgent currentAgent;

    public PubSubRedisStateStore(CurrentAgent currentAgent){
        this.currentAgent=currentAgent;
    }

    @Override
    public void writeState(String channel, CurrentAgent currentAgent) {
        RedisPublisher publisher = new RedisPublisher(JEDIS_HOST,JEDIS_PORT);
        String agentString;
        ObjectMapper mapper = new ObjectMapper();
        try {
            agentString = mapper.writeValueAsString(currentAgent);
            publisher.pub(channel, agentString);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void subscribeChannel(String channel) {
        RedisSubscriber subscriber = new RedisSubscriber(JEDIS_HOST, JEDIS_PORT);
        JedisPubSub listener = new RedisListener(this.currentAgent);
        subscriber.setChannelAndListener(listener,channel);
        subscriber.start();
    }

}
