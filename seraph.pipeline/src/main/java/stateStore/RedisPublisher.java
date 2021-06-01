package stateStore;


import redis.clients.jedis.Jedis;

public class RedisPublisher {
    private Jedis jedis;



    public RedisPublisher(String host,int port){ this.jedis = new Jedis(host,port); }


    public void pub(String channel,String message){ this.jedis.publish(channel, message); }

//    public void close(String channel){ jedis.publish(channel, "quit"); }
}
