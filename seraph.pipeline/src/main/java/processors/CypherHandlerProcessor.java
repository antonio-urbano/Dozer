package processors;

import config.DozerConfig;
import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.CypherQueryHandler;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

/**
 * Processor to handle the cypher query.
 * Once the {@link TimeManagedProcessorInsertion} ends its process, it uses the
 * {@link CypherQueryHandler} to run the cypher query associated parsed from the seraph query
 * and write the result into a kafka topic
 */
public class CypherHandlerProcessor implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private CypherQueryHandler cypherHandler;
    private KeyValueStore<String, CurrentAgent> kvStore;

    private final String agentStoreName;

    public CypherHandlerProcessor(String agentStoreName) {
        this.agentStoreName = agentStoreName;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore(this.agentStoreName);
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(), agent));
        kafkaProducer.flush();
        kafkaProducer.close();

        this.cypherHandler = new CypherQueryHandler(DozerConfig.getNeo4jBolt(), DozerConfig.getNeo4jUsername(), DozerConfig.getNeo4jPassword());

    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key"
        if(currentAgent.getAgentName().equals(TimeManagedProcessorInsertion.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", (currentAgent.getTimestampToSync()));
            cypherHandler.cypherResultIntoKafka();
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }
    }

    @Override
    public void close() { }
}
