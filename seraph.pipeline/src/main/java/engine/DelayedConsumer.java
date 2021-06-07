package engine;

import stateStore.PubSubRedisStateStore;

/**
 * Component for delaying the consumption of the deletion records.
 * It maintains the nodes and relationships of the neo4j instance constantly updated,
 * by consuming records produced with a customized delayed timestamp by the {@link DeleteStreamProducer}
 * and re-producing these records into another topic at proper time
 */
public class DelayedConsumer extends Thread {

    private PubSubRedisStateStore stateStore;
    private CurrentAgent currentAgent;
    private String registeredQueryName;
    private Long timestamp_to_sync;
    private final boolean isReady;



    public DelayedConsumer(){
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
            return true;
        }
        return false;
    }

    public boolean isReady() { return this.isReady; }


/*
    static void delayedStream_seek(TopicPartition topicPartition, String outputTopic) {

        ConsumerFactory<String, Neo4jObj> cf = new DefaultKafkaConsumerFactory<>(KafkaConfigProperties.getKafkaConsumerProperties());
        Consumer<String, Neo4jObj> consumer = cf.createConsumer();
        consumer.assign(Collections.singletonList(topicPartition));

        Producer<String, Neo4jObj> producer = new KafkaProducer<>(getProducerConfig());

        long offset_to_read = consumer.beginningOffsets(Collections.singletonList(topicPartition)).get(topicPartition);
        long last_pushed_offset = -1;
        boolean seek_flag = true;


        while (true){
            if (seek_flag)
                consumer.seek(topicPartition, offset_to_read);
            ConsumerRecords<String, Neo4jObj> records = consumer.poll(Duration.ofMillis(100));
            if(!records.isEmpty()) {
                for (ConsumerRecord<String, Neo4jObj> r : records.records(topicPartition)) {
                    if (r.timestamp() < System.currentTimeMillis()) {
                        if(r.offset()!=last_pushed_offset)
                            producer.send(new ProducerRecord<>(outputTopic, r.key(), r.value()));
                        last_pushed_offset = r.offset();
                        offset_to_read = r.offset();
                        seek_flag = false;
                    }
                    else seek_flag = true;
                }
            }
        }

    }*/

/*    public void run(){
        TopicPartition topicPartition = new TopicPartition("tmpDeleteTopic", 0);
        String outputTopic = "delayedDelete";
        ConsumerFactory<String, Neo4jObj> cf = consumerFactory();
        Consumer<String, Neo4jObj> consumer = cf.createConsumer();
        consumer.assign(Collections.singletonList(topicPartition));

        Producer<String, Neo4jObj> producer = new KafkaProducer<>(getProducerConfig());

        long offset_to_read = consumer.beginningOffsets(Collections.singletonList(topicPartition)).get(topicPartition);
        long last_pushed_offset = -1;
        boolean seek_flag = true;
        this.stateStore.readState("globalStateStore");

        while (true) {
            synchronized (monitor) {
                while (CurrentAgent.getCurrentAgent()==null || CurrentAgent.getCurrentAgent().equals("start delete producer")){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                monitor.notifyAll();
                if (seek_flag)
                    consumer.seek(topicPartition, offset_to_read);
                ConsumerRecords<String, Neo4jObj> records = consumer.poll(Duration.ofMillis(100));
                if (!records.isEmpty()) {
                    for (ConsumerRecord<String, Neo4jObj> r : records.records(topicPartition)) {
                        if (r.timestamp() < System.currentTimeMillis()) {
                            if (r.offset() != last_pushed_offset)
                                producer.send(new ProducerRecord<>(outputTopic, r.key(), r.value()));
                            last_pushed_offset = r.offset();
                            offset_to_read = r.offset();
                            seek_flag = false;
                        }
                        this.stateStore.writeState("globalStateStore", DelayedConsumer.class.getName());
                        seek_flag = true;
                    }
                }else {
                    this.stateStore.writeState("globalStateStore", DelayedConsumer.class.getName());
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }*/

    //todo javadoc
    public void run(){
        while (true){
            if((this.currentAgent.getAgentName().equals(DeleteStreamProducer.class.getSimpleName()))
                    || (this.currentAgent.getAgentName().equals(CypherQueryHandler.class.getSimpleName()) && this.currentAgent.getStatus().equals("completed"))){
                this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "started", this.timestamp_to_sync));
                System.err.println("YYY_DelCons:  " + "DelayedCons started");
                //Blocco lavoro
                this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "completed", this.timestamp_to_sync));
                System.err.println("YYY_DelCons:  " + "DelayedCOns completed");
            }
        }
    }

    /*public void run(){
        while (true) {
            synchronized (monitor) {
                this.stateStore.writeState("globalStateStore", "DelayedCons");
                this.stateStore.readState("globalStateStore");
                if (CurrentAgent.getCurrentAgent() != null)
                    System.err.println("XXX_DelCons: " + CurrentAgent.getCurrentAgent());
                else System.err.println("XXX_DelCons: " + "null");
            }
        }
    }
*/

    /*public static void main(final String[] args) {
        delayedStream_seek(new TopicPartition("tmpDeleteTopic", 0), "delayedDelete");

    }*/


}
