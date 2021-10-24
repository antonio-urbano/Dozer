package processors;

import config.DozerConfig;
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
 * It corresponds to the first processor triggered after the SyncGeneratorProcessor ends its process.
 */
public class TimeManagedProcessorDeletion implements Processor<String, CurrentAgent> {

    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private KeyValueStore<String, Long> offsetKvStore;

    private final String agentStoreName;
    private final String offsetStoreName;

    public TimeManagedProcessorDeletion(String agentStoreName, String offsetStoreName) {
        this.agentStoreName = agentStoreName;
        this.offsetStoreName = offsetStoreName;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        offsetKvStore = (KeyValueStore) context.getStateStore(this.offsetStoreName);
        kvStore = (KeyValueStore) context.getStateStore(this.agentStoreName);
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(), agent));
        kafkaProducer.flush();
        kafkaProducer.close();

    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key", "value"
        if((currentAgent.getAgentName().equals(SyncGeneratorProcessorEvent.class.getSimpleName())
                || currentAgent.getAgentName().equals(SyncGeneratorProcessorTime.class.getSimpleName()))
                && currentAgent.getStatus().equals("completed")){
            Long offsetToRead = TimeManagedConsumer.delayedStream_seek
                    (new TopicPartition(DozerConfig.getCdcDeleteRelationshipsTopic(), 0),
                            DozerConfig.getNeo4jPluginRelationshipsTopic(), currentAgent.getTimestampToSync(), this.offsetKvStore.get("value-deletion"));
            this.offsetKvStore.put("value-deletion", offsetToRead);
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestampToSync());
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key",updatedAgent);
            this.context.commit();
        }
    }


        @Override
    public void close() { }
}
