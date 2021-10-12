package processors;

import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.CypherQueryHandler;
import engine.SeraphQueryParser;
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
 * after the {@link SeraphQueryParser} ends to parse the seraph query.
 * Later, every time the {@link CypherQueryHandler} ends its process, it updates the timestampToSync
 */
public class TickerProcessorTime implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private long emitEveryTimeRange =120000L;   // todo time range value



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        this.kvStore = (KeyValueStore) context.getStateStore("agent-store3"); //todo name state store
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic3", agent)); //todo topic name
        kafkaProducer.flush();
        kafkaProducer.close();
    }

    //todo "key"
    private void updateAgentKvStore(String key, CurrentAgent currentAgent) {
        if (currentAgent.getAgentName().equals(SeraphQueryParser.class.getSimpleName())
        && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestampToSync());
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();

        }
        else if(currentAgent.getAgentName().equals(CypherHandlerProcessor.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestampToSync() + emitEveryTimeRange);
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }
    }

    @Override
    public void process(String key, CurrentAgent currentAgent) {
        updateAgentKvStore(key,currentAgent);
    }


    @Override
    public void close() { }
}
