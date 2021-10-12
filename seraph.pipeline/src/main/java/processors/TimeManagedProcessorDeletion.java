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

/**
 * Processor to handle the consumption of the deletion records in CDC format
 * at proper time by using the {@link TimeManagedConsumer}.
 * It corresponds to the first processor triggered after the TickerProcessor ends its process.
 */
public class TimeManagedProcessorDeletion implements Processor<String, CurrentAgent> {

    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private KeyValueStore<String, Long> offsetKvStore;

    
    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        offsetKvStore = (KeyValueStore) context.getStateStore("offset-store3");  //todo store name
        kvStore = (KeyValueStore) context.getStateStore("agent-store3");         //todo store name
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic3", agent));     //todo topic name
        kafkaProducer.flush();
        kafkaProducer.close();

    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key", "value" and topicNames
        if((currentAgent.getAgentName().equals(TickerProcessorEvent.class.getSimpleName())
                || currentAgent.getAgentName().equals(TickerProcessorTime.class.getSimpleName()))
                && currentAgent.getStatus().equals("completed")){
            Long offsetToRead = TimeManagedConsumer.delayedStream_seek
                    (new TopicPartition("tmpDeleteTopic", 0),
                            "time-managed-topic", currentAgent.getTimestampToSync(), this.offsetKvStore.get("value-deletion"));
            this.offsetKvStore.put("value-deletion", offsetToRead);
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
