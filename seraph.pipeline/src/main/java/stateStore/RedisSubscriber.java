package stateStore;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSubscriber extends Thread{
    private Jedis jedis;
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
//            System.out.println();
//            System.out.println("---------SUBSCRIBE begins-------");
            subscribe();
//            System.out.println("----------SUBSCRIBE ends-------");
//            System.out.println();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}