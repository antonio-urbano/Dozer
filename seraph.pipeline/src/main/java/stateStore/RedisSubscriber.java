package stateStore;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSubscriber extends Thread{
    private final Jedis jedis;
    private String channel;
    private JedisPubSub listener;

    public RedisSubscriber(String host,int port){ this.jedis = new Jedis(host,port); }

    public void setChannelAndListener(JedisPubSub listener,String channel){
        this.listener=listener;
        this.channel=channel;
    }
    private void subscribe(){
        if(this.listener==null || this.channel==null)
            System.err.println("Error:SubClient> listener or channel is null");
        //When the receiver is listening for subscribed messages, the process is blocked until the quit message is received (in a passive manner) or the subscription is actively canceled.
        this.jedis.subscribe(listener, channel);
    }
    public void unsubscribe(String channel){ listener.unsubscribe(channel); }


    @Override
    public void run() {
        try{
            subscribe();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}