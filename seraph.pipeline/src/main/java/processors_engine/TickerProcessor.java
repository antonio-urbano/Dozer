package processors_engine;

import engine.CurrentAgent;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class TickerProcessor implements Processor<String, String> {
    private ProcessorContext context;
    private KeyValueStore<String, String> kvStore;



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        // keep the processor context locally because we need it in punctuate() and commit()
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore("agent-store-ticker");


    }

    @Override
    public void process(String key, String s) {
        System.err.println("XXXXXXXX");
        Long l = System.currentTimeMillis()+60000L;
        this.context.forward("key",l.toString());
        this.context.commit();

    }

    @Override
    public void close() {

    }
}
