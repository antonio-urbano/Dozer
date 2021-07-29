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

public class DeleteProducerByEventProcessor implements Processor<String, Neo4jObj> {

    private ProcessorContext context;
    private final int QUEUE_SIZE = 3;
    private KeyValueStore<String, Queue<Object>> kvStore;
    private Queue<Object> queueProva;
    Producer<String, Object> kafkaProducer;

    @Override
    public void init(ProcessorContext processorContext) {
        this.context = processorContext;
        this.kvStore = (KeyValueStore) this.context.getStateStore("queue-event-store");
        this.queueProva = this.kvStore.get("key"); //todo key
        if (this.queueProva==null)
            this.queueProva = new LinkedList<>();
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
            queueProva.add(outputObj);

        if(queueProva.size()>QUEUE_SIZE){
            kafkaProducer.send(new ProducerRecord<>("tmpDeleteTopic", queueProva.remove()));
            kafkaProducer.flush();
        }
        this.kvStore.put("key", queueProva);
        this.context.commit();
    }

    @Override
    public void close() {

    }
}
