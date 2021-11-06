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
 * Processor to handle the consumption of the creation records in CDC format
 * at proper time by using the {@link TimeManagedConsumer}.
 * The process starts after the {@link TimeManagedProcessorInsertion} ends its process.
 */
public class TimeManagedProcessorInsertion implements Processor<String, CurrentAgent> {

    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private KeyValueStore<String, Long> offsetKvStore;

    private final String agentStoreName;
    private final String offsetStoreName;
    private TimeManagedConsumer timeManagedConsumer;

    public TimeManagedProcessorInsertion(String agentStoreName, String offsetStoreName) {
        this.agentStoreName = agentStoreName;
        this.offsetStoreName = offsetStoreName;
        this.timeManagedConsumer = new TimeManagedConsumer(
                new TopicPartition(DozerConfig.getCdcCreateRelationshipsTopic(), 0),
                "insertion");

    }

    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        offsetKvStore = (KeyValueStore) context.getStateStore(this.offsetStoreName);
        kvStore = (KeyValueStore) context.getStateStore(this.agentStoreName);
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties(this.getClass().getSimpleName()));
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(), agent));
        kafkaProducer.flush();
        kafkaProducer.close();
    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key", "value"
        if(currentAgent.getAgentName().equals(TimeManagedProcessorDeletion.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            Long offsetToRead = this.timeManagedConsumer.delayedStream_seek(
                    DozerConfig.getNeo4jPluginRelationshipsTopic(), currentAgent.getTimestampToSync(), this.offsetKvStore.get("value-insertion"), "insertion");
            this.offsetKvStore.put("value-insertion", offsetToRead);
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
