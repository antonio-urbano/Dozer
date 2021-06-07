package engine;

import stateStore.PubSubRedisStateStore;

import java.util.Date;

public class SeraphQueryTicker extends Thread{

    private PubSubRedisStateStore stateStore;
    private CurrentAgent currentAgent;
    private String registeredQueryName;
    private Long timestamp_to_sync;
    private Long emit_time_range;
    private final boolean isReady;



    public SeraphQueryTicker(){
        this.isReady = initParams();
        if (this.isReady) {
            this.currentAgent = new CurrentAgent();
            this.stateStore = new PubSubRedisStateStore(this.currentAgent);
            this.stateStore.readState(this.registeredQueryName);
        }
    }

    private boolean initParams(){
        SeraphPayloadHandler payloadHandler = new SeraphPayloadHandler();
        SeraphPayload payload = payloadHandler.readPayloadFromKafka();
        if (payload!=null){
            this.registeredQueryName = payload.getQuery_id();
            this.timestamp_to_sync = payload.getTimestamp_to_sync();
            this.emit_time_range = payload.getEmit_time_range();
            return true;
        }
        return false;
    }


    //todo javadoc
    public void run() {
        if (currentAgent != null) {

            while (isReady) {
                if ((this.currentAgent.getAgentName().equals(DeleteStreamProducer.class.getSimpleName()))) {
                    System.err.println("YYY_Ticker:  " + "yyy_first  " + new Date(this.timestamp_to_sync));
                    this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "next", this.timestamp_to_sync));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else if (this.currentAgent.getAgentName().equals(CypherQueryHandler.class.getSimpleName()) && this.currentAgent.getStatus().equals("completed")) {
                    this.timestamp_to_sync += this.emit_time_range;
                    System.err.println("YYY_Ticker:  " + "next  " + new Date(this.timestamp_to_sync));
                    this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "next", this.timestamp_to_sync));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
