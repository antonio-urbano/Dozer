package processors;

import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.CypherQueryHandler;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;


public class CypherHandlerProcessor implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private CypherQueryHandler cypherHandler;
    private KeyValueStore<String, CurrentAgent> kvStore;

    
    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore("agent-store");     //todo store name
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic", agent));     // todo topic name
        kafkaProducer.flush();
        kafkaProducer.close();

        //todo neo4j connection
        this.cypherHandler = new CypherQueryHandler("bolt://localhost:7687", "neo4j", "sink");

    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key" and topicNames
        if(currentAgent.getAgentName().equals(TimeManagedProcessorInsertion.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", (currentAgent.getTimestampToSync()));
            cypherHandler.cypherResultIntoKafka();
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();
        }    }

    @Override
    public void close() { }
}
