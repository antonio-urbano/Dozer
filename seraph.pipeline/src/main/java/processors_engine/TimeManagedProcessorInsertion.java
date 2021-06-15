package processors_engine;

import engine.CurrentAgent;
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
        offsetKvStore = (KeyValueStore) context.getStateStore("offset-store-insertion");
        kvStore = (KeyValueStore) context.getStateStore("agent-store-time-managed-insertion");

    }

    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key", "value" and topicNames
        if(currentAgent.getAgentName().equals(TimeManagedProcessorDeletion.class.getSimpleName())) {
            System.err.println("XXXXXXXXXXXX");
            Long offsetToRead = TimeManagedConsumer_2.delayedStream_seek
                    (new TopicPartition("relationships", 0),
                            "time-managed-topic", currentAgent.getTimestamp_to_sync(), this.offsetKvStore.get("value"));
            this.offsetKvStore.put("value", offsetToRead);
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestamp_to_sync());
            this.kvStore.put("key", updatedAgent);
            context.forward("key",updatedAgent);
            context.commit();
        }
        else System.err.println("XXXXX:  " + currentAgent.getAgentName());

    }

    @Override
    public void close() { }
}
