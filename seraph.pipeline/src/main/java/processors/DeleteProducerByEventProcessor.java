package processors;

import cdc_converter.CdcCreateRecord;
import cdc_converter.CdcDeleteRecord;
import config.KafkaConfigProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Processor used to generate the {@link CdcDeleteRecord} instances, i.e. deletion records in CDC format,
 * starting from {@link CdcCreateRecord} instances, i.e. creation records in CDC format.
 * These records will be published into a temporary kafka topic consumed by the {@link TimeManagedProcessorDeletion}.
 * The frequency of publication into the temporary topic depends on the window range defined into the seraph
 * query in terms of number of events.
 */
public class DeleteProducerByEventProcessor implements Processor<String, CdcCreateRecord> {

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
    public void process(String s, CdcCreateRecord cdcCreateRecord) {
        CdcDeleteRecord cdcDeleteRecord =null;
        if (cdcCreateRecord!=null && cdcCreateRecord.getPayload()!=null
                && cdcCreateRecord.getMeta().get("operation").equals("created")
                && cdcCreateRecord.getPayload().get("start")!=null)
            cdcDeleteRecord = new CdcDeleteRecord(cdcCreateRecord, 0L);
        if (cdcDeleteRecord !=null)
            eventQueue.add(cdcDeleteRecord);

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
