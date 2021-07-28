package processors;

import config.KafkaConfigProperties;
import engine.OutputObj;
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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DeleteProducerByEvent implements Processor<String, OutputObj> {

    private ProcessorContext context;
    private final int QUEUE_SIZE = 4;
//    private KeyValueStore<String, OutputObj[]> kvStore;
    private KeyValueStore<String, Queue> msgQueueStore;
    private Queue<OutputObj> queueProva;
    Producer<String, Object> kafkaProducer;


    @Override
    public void init(ProcessorContext context) {
        this.context = context;
//        this.kvStore = (KeyValueStore) context.getStateStore("obj-stream-store");
        this.msgQueueStore = (KeyValueStore) this.context.getStateStore("queue-store3");
        queueProva = new LinkedList<>();
        this.kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
    }

    @Override
    public void process(String key, OutputObj outputObj) {
//        Queue msgQueue = this.msgQueueStore.get("key");
//        if (msgQueue==null)
//            msgQueue=new LinkedList<>();
//        msgQueue.add(outputObj);

        kafkaProducer.send(new ProducerRecord<>("provaTopic", outputObj));
        kafkaProducer.flush();
        queueProva.add(outputObj);
//        LinkedHashMap mappa = (LinkedHashMap) msgQueue.remove();
//        System.err.println("PPPPPPP keySet: " + mappa.keySet());
//        System.err.println("PPPPPPP value: " + mappa.values());
//        System.err.println("KKKKKKKKKK " + outputObj );
//        System.err.println("XXXXXXX size: " + msgQueue.size());
//        while (!msgQueue.isEmpty())
//            System.err.println(msgQueue.remove());
//        if (msgQueue.size()>QUEUE_SIZE) {
        if(queueProva.size()>QUEUE_SIZE){
            kafkaProducer.send(new ProducerRecord<>("tmpDeleteEventTopic", queueProva.remove()));
            kafkaProducer.flush();
        }
//        this.msgQueueStore.put("key", msgQueue);
        this.context.commit();
    }

    @Override
    public void close() {

    }
}
