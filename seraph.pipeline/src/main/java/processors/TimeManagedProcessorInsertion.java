package processors;

import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.TimeManagedConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;


public class TimeManagedProcessorInsertion implements Processor<String, CurrentAgent> {

    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private KeyValueStore<String, Long> offsetKvStore;

    
    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        offsetKvStore = (KeyValueStore) context.getStateStore("offset-store");      // todo store name
        kvStore = (KeyValueStore) context.getStateStore("agent-store");      // todo store name
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic", agent));     //todo topic name
        kafkaProducer.flush();
        kafkaProducer.close();
    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key", "value" and topicNames
        if(currentAgent.getAgentName().equals(TimeManagedProcessorDeletion.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            Long offsetToRead = TimeManagedConsumer.delayedStream_seek
                    (new TopicPartition("relationships", 0),
                            "time-managed-topic", currentAgent.getTimestampToSync(), this.offsetKvStore.get("value-insertion"));
            this.offsetKvStore.put("value-insertion", offsetToRead);
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestampToSync());
            this.kvStore.put("key", updatedAgent);
            context.forward("key",updatedAgent);
            context.commit();
        }
    }


    @Override
    public void close() { }

}
