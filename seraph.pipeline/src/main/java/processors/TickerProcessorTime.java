package processors;

import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.SeraphQueryParser;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;


public class TickerProcessorTime implements Processor<String, CurrentAgent> {
    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private final long windowTimeRange =120000L;   // todo time range value



    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        this.kvStore = (KeyValueStore) context.getStateStore("agent-store2"); //todo name state store
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("processor-topic1", agent));
        kafkaProducer.flush();
        kafkaProducer.close();
        //CurrentAgent agent = this.kvStore.get("key");
        /*
        if(agent!=null){
            if (agent.getAgentName().equals(this.getClass().getSimpleName())) {
                System.err.println("XXXXXXXX Ticker:  " + agent.getAgentName() + "  " + agent.getTimestamp_to_sync());

                Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
                kafkaProducer.send(new ProducerRecord<>("processor-topic2", agent));
                kafkaProducer.flush();
                kafkaProducer.close();

            }
        }
         */


        /*if(this.context!=null) {
//            if (agent != null)
//                updateAgentKvStore("key", agent);
            this.context.schedule(Duration.ofMillis(windowRange), PunctuationType.WALL_CLOCK_TIME, (timestamp) -> {
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
        }*/

        /*if(this.context!=null) {
            KeyValueIterator<String, CurrentAgent> iter = this.kvStore.all();
            KeyValue<String, CurrentAgent> entry = null;
            while (iter.hasNext())
                entry = iter.next();
            if (entry!=null && this.context!=null && agent!=null)
                    this.context.forward(entry.key, entry.value);
            iter.close();

            // commit the current processing progress
            this.context.commit();
        }*/
//        else System.err.println("KKKKKKKKKK null");


//            System.err.println("XXXXXXXX Ticker:  " + agent.getAgentName() + "  " + agent.getTimestamp_to_sync());
//            updateAgentKvStore("key", agent);

//        if (agent!=null && agent.getAgentName().equals(this.getClass().getSimpleName())){
//            this.context.forward("key", agent);
//            this.context.commit();
//        }

    }

    private void updateAgentKvStore(String key, CurrentAgent currentAgent) {
        if (currentAgent.getAgentName().equals(SeraphQueryParser.class.getSimpleName())
        && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestamp_to_sync());
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();

        }
        else if(currentAgent.getAgentName().equals(CypherHandlerProcessor.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", currentAgent.getTimestamp_to_sync() + windowTimeRange);
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
