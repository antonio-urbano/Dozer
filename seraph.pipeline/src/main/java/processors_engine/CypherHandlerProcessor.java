package processors_engine;

import engine.CurrentAgent;
import engine.CypherQueryHandler;
import engine.SeraphPayloadHandler;
import engine.SeraphQueryParser;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

public class CypherHandlerProcessor implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore("agent-store-cypher-handler");
    }

    @Override
    public void process(String key, CurrentAgent currentAgent) {
        if(currentAgent.getAgentName().equals(TimeManagedProcessor.class.getSimpleName())) {
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", (currentAgent.getTimestamp_to_sync()));
            CypherQueryHandler_2 cypherHandler = new CypherQueryHandler_2("bolt://localhost:7687", "neo4j", "sink");
            cypherHandler.cypherResultIntoKafka();
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }
    }

    @Override
    public void close() { }
}
