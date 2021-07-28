package processors;

import config.KafkaConfigProperties;
import engine.CurrentAgent;
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

public class ProvaProcessor implements Processor<String, Neo4jObj> {

    private ProcessorContext context;
    private final int QUEUE_SIZE = 3;
//    private KeyValueStore<String, Queue<Neo4jObj>> msgQueueStore;
    private Queue<OutputObj> queueProva;
    Producer<String, OutputObj> kafkaProducer;

    @Override
    public void init(ProcessorContext processorContext) {
        this.context = context;
//        this.kvStore = (KeyValueStore) context.getStateStore("obj-stream-store");
//        this.msgQueueStore = (KeyValueStore) this.context.getStateStore("queue-store3");
        queueProva = new LinkedList<>();
        this.kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
    }

    @Override
    public void process(String s, Neo4jObj neo4jObj) {

        /*
                KStream<String,OutputObj> stream = builder.stream("relationships",
                Consumed.with(Serdes.String(), neoSerde).
                        withTimestampExtractor(new CustomerExtractor(0L))) //todo window range
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj)));
         */
        System.err.println("KKKKKKKKKKKK"+queueProva.size());
        OutputObj outputObj=null;
        if (neo4jObj!=null && neo4jObj.getPayload()!=null
                && neo4jObj.getMeta().get("operation").equals("created")
                && neo4jObj.getPayload().get("start")!=null)
            outputObj = new OutputObj(neo4jObj);
        if (outputObj!=null)
            queueProva.add(outputObj);
        if(queueProva.size()>QUEUE_SIZE){
            kafkaProducer.send(new ProducerRecord<>("tmpDeleteEventTopic", queueProva.remove()));
            kafkaProducer.flush();
        }
    }

    @Override
    public void close() {

    }
}
