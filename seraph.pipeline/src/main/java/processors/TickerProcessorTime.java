package processors;

import config.DozerConfig;
import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.CypherQueryHandler;
import engine.SeraphPayloadHandler;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

/**
 * Processor to handle the synchronization between all the processors in the topology according to the EVERY
 * operator defined in terms of time expressed as Milliseconds.
 * The processor initialize the timestampToSync, i.e. the timestamp to which all the components have to synchronize,
 * after the {//todo change the link for Parser}
 * ends to parse the seraph query.
 * Later, every time the {@link CypherQueryHandler} ends its process, it updates the timestampToSync
 */
public class TickerProcessorTime implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private final long emitEveryTimeRange;
    private final String agentStoreName;
    private final String inputStream;

    public TickerProcessorTime(long emitEveryTimeRange, String agentStoreName, String inputStream) {
        this.emitEveryTimeRange = emitEveryTimeRange;
        this.agentStoreName = agentStoreName;
        this.inputStream = inputStream;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        this.kvStore = (KeyValueStore) context.getStateStore(this.agentStoreName);
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(), agent));
        kafkaProducer.flush();
        kafkaProducer.close();
    }

    @Override
    public void process(String key, CurrentAgent currentAgent) { //todo key
        if (currentAgent.getAgentName().equals("SERAPH_QUERY_PARSED")
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", SeraphPayloadHandler.getInitTimeToSync(this.inputStream)); //todo handle empty stream
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();

        }
        else if(currentAgent.getAgentName().equals(CypherHandlerProcessor.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestampToSync() + this.emitEveryTimeRange);
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }
    }


    @Override
    public void close() { }
}
