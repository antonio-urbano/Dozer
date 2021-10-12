package processors;

import config.KafkaConfigProperties;
import engine.Neo4jObj;
import engine.OutputObj;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Processor used to generate the {@link OutputObj} instances, i.e. deletion records in CDC format,
 * starting from {@link Neo4jObj} instances, i.e. creation records in CDC format.
 * These records will be published into a temporary kafka topic consumed by the {@link TimeManagedProcessorDeletion}.
 * The frequency of publication into the temporary topic depends on the window range defined into the seraph
 * query in terms of number of events.
 */
public class DeleteProducerByEventProcessor implements Processor<String, Neo4jObj> {

    private ProcessorContext context;
    private final int windowEventRange = 3;       //todo
    private KeyValueStore<String, Queue<Object>> kvStore;
    private Queue<Object> eventQueue;
    Producer<String, Object> kafkaProducer;

    @Override
    public void init(ProcessorContext processorContext) {
        this.context = processorContext;
        this.kvStore = (KeyValueStore) this.context.getStateStore("queue-event-store3");     //todo store name
        this.eventQueue = this.kvStore.get("key"); //todo key
        if (this.eventQueue ==null)
            this.eventQueue = new LinkedList<>();
        this.kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
    }

    @Override
    public void process(String s, Neo4jObj neo4jObj) {
        OutputObj outputObj=null;
        if (neo4jObj!=null && neo4jObj.getPayload()!=null
                && neo4jObj.getMeta().get("operation").equals("created")
                && neo4jObj.getPayload().get("start")!=null)
            outputObj = new OutputObj(neo4jObj, 0L);
        if (outputObj!=null)
            eventQueue.add(outputObj);

        if(eventQueue.size()> windowEventRange){
            kafkaProducer.send(new ProducerRecord<>("tmpDeleteTopic", eventQueue.remove()));    //todo tmpDeleteTopic
            kafkaProducer.flush();
        }
        this.kvStore.put("key", eventQueue);
        this.context.commit();
    }

    @Override
    public void close() {

    }
}
