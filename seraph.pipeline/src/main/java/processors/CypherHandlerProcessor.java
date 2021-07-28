package processors;

import config.KafkaConfigProperties;
import engine.CurrentAgent;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;

public class CypherHandlerProcessor implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        kvStore = (KeyValueStore) context.getStateStore("agent-store2");
//        CurrentAgent agent = this.kvStore.get("key");
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic1", agent));
        kafkaProducer.flush();
        kafkaProducer.close();
//        if(agent!=null){
//            if (agent.getAgentName().equals(this.getClass().getSimpleName())) {
//                System.err.println("XXXXXXXX CypherHandler:  " + agent.getAgentName() + "  " + agent.getTimestamp_to_sync());
//                Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
//                kafkaProducer.send(new ProducerRecord<>("processor-topic2", agent));
//                kafkaProducer.flush();
//                kafkaProducer.close();
//            }
//        }

/*
        if(this.context!=null) {
//            if (agent != null)
//                updateAgentKvStore("key", agent);
            this.context.schedule(Duration.ofMillis(120000L), PunctuationType.WALL_CLOCK_TIME, (timestamp) -> {
                KeyValueIterator<String, CurrentAgent> iter = this.kvStore.all();
                KeyValue<String, CurrentAgent> entry = null;
                while (iter.hasNext()) {
                    entry = iter.next();
                }
                if (entry!=null)
                    context.forward(entry.key, entry.value);
                iter.close();

                // commit the current processing progress
                context.commit();
            });
        }
*/
         /*

        if(this.context!=null) {
            KeyValueIterator<String, CurrentAgent> iter = this.kvStore.all();
            KeyValue<String, CurrentAgent> entry = null;
            while (iter.hasNext())
                entry = iter.next();
            if (entry!=null && this.context!=null && agent!=null)
                this.context.forward(entry.key, entry.value);
            iter.close();

            // commit the current processing progress
            this.context.commit();
        }

          */
//        else System.err.println("KKKKKKKKKK null");
//            System.err.println("XXXXXXXX CypherHandler:  " + agent.getAgentName() + "  " + agent.getTimestamp_to_sync());
//            updateAgentKvStore("key", agent);
//        if (agent!=null && agent.getAgentName().equals(this.getClass().getSimpleName())){
//            this.context.forward("key", agent);
//            this.context.commit();
//        }
    }

    private void updateAgentKvStore(String key, CurrentAgent currentAgent) {
        if(currentAgent.getAgentName().equals(TimeManagedProcessorInsertion.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
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
    public void process(String key, CurrentAgent currentAgent) {
        updateAgentKvStore(key,currentAgent);
    }

    @Override
    public void close() { }
}
