package processors_engine;

import engine.CurrentAgent;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class TickerProcessor implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        // keep the processor context locally because we need it in punctuate() and commit()
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore("agent-store-ticker");


    }

    @Override
    public void process(String key, CurrentAgent currentAgent) {
        System.err.println("XXXXXXXX");
        this.context.forward("key",new CurrentAgent(this.getClass().getSimpleName(),"ready", System.currentTimeMillis()+60000L));
        this.context.commit();

    }

    @Override
    public void close() {

    }
}
