package processors_engine;

import engine.CurrentAgent;
import engine.CypherQueryHandler;
import engine.SeraphPayloadHandler;
import engine.SeraphQueryParser;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class TickerProcessor implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private final long windowRange=120000L;   // todo



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore("agent-store-ticker");
    }

    @Override
    public void process(String key, CurrentAgent currentAgent) {

        if (currentAgent.getAgentName().equals(SeraphQueryParser.class.getSimpleName())) {
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", 1623770700000L);//(SeraphPayloadHandler.getInitTimeToSync()));
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }
        //todo handle read first record when neo4j is not populated
        //todo handle window range
        else if(currentAgent.getAgentName().equals(CypherHandlerProcessor.class.getSimpleName())) {
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", (currentAgent.getTimestamp_to_sync() + windowRange));
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }

    }

    @Override
    public void close() { }
}
