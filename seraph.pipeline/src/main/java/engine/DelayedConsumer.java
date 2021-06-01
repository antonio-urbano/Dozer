package engine;

import config.ConfigProperties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import stateStore.PubSubRedisStateStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DelayedConsumer extends Thread {

    private PubSubRedisStateStore stateStore;
    private final CurrentAgent currentAgent;


    public DelayedConsumer(CurrentAgent currentAgent){
        this.currentAgent = currentAgent;
        this.stateStore = new PubSubRedisStateStore(this.currentAgent);
        this.stateStore.subscribeChannel("globalStateStore");
    }



/*
    static void delayedStream_seek(TopicPartition topicPartition, String outputTopic) {

        ConsumerFactory<String, Neo4jObj> cf = new DefaultKafkaConsumerFactory<>(ConfigProperties.getKafkaConsumerProperties());
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

    public void run(){
        this.stateStore.subscribeChannel("globalStateStore");
        while (!isInterrupted()){
            synchronized (currentAgent){
                if((currentAgent.getAgent().equals("DeleteStreamProducer"))
                        || (currentAgent.getAgent().equals("CypherHandler") && currentAgent.getStatus().equals("completed"))){
                    this.currentAgent.updateCurrentAgent("DelayedConsumer", "started", System.currentTimeMillis());
                    this.stateStore.writeState("globalStateStore", this.currentAgent);
                    //Blocco lavoro
                    this.currentAgent.updateCurrentAgent("DelayedConsumer", "completed", System.currentTimeMillis());
                    this.stateStore.writeState("globalStateStore", this.currentAgent);
                    System.err.println("YYY_DelayedConsumer:  " + "DelayedConsumer completed");
                }
                currentAgent.notifyAll();
                try {
                    currentAgent.wait();
                } catch (InterruptedException e) {
                    /* TODO
                    writeState(Cypher completed or interrupted)
                     */
                    e.printStackTrace();
                    interrupt();
                }
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
