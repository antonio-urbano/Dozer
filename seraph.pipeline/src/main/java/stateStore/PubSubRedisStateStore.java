package stateStore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import engine.CurrentAgent;
import redis.clients.jedis.JedisPubSub;

/**
 * Custom state store for writing and reading the current agent of the pipeline
 * based on PUBSUB redis paradigm {@see https://redis.io/topics/pubsub}
 */
public class PubSubRedisStateStore implements SeraphStateStore{
    final static int JEDIS_PORT = 6379;
    final static String JEDIS_HOST="localhost";


    private final CurrentAgent currentAgent;

    public PubSubRedisStateStore(CurrentAgent currentAgent){
        this.currentAgent=currentAgent;
    }

    /**
     * Write the current agent status into the channel
     * @param channel   channel name equals to the registered query name
     * @param currentAgent
     */
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

    /**
     * Subscribe to channels to read messages associated to the current agent
     * @param channel channel name equals to the registered query name
     */
    @Override
    public void readState(String channel) {
        RedisSubscriber subscriber = new RedisSubscriber(JEDIS_HOST, JEDIS_PORT);
        JedisPubSub listener = new RedisListener(this.currentAgent);
        subscriber.setChannelAndListener(listener,channel);
        subscriber.start();
    }

}
