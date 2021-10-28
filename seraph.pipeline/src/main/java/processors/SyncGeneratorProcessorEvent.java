package processors;

import config.DozerConfig;
import config.KafkaConfigProperties;
import engine.CurrentAgent;
import engine.CypherQueryHandler;
import engine.SeraphPayloadHandler;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import seraphGrammar.Start;

import java.time.Instant;


/**
 * Processor to handle the synchronization between all the processors in the topology according to the EVERY
 * operator defined in terms of number of events.
 * The processor initialize the timestampToSync, i.e. the timestamp to which all the components have to synchronize,
 * after the {//todo @link }
 * ends to parse the seraph query.
 * Later, every time the {@link CypherQueryHandler} ends its process, it updates the timestampToSync by using
 * the {@link SyncEventInputReader} which takes care of the frequency of the evaluation process based on EVERY operator.
 */
public class SyncGeneratorProcessorEvent implements Processor<String, CurrentAgent> {

    private ProcessorContext context;
    private KeyValueStore<String, CurrentAgent> kvStore;
    private KeyValueStore<String, Long> offsetKvStore;
    private Long[] timestampToSync_offsetToRead;
    private final Long emitEveryEventRange;
    private final String agentStoreName;
    private final String offsetStoreName;
    private final String inputStream;
    private final Start windowStart;

    public SyncGeneratorProcessorEvent(Long emitEveryEventRange, String agentStoreName,
                                       String offsetStoreName, String inputStream, Start windowStart) {
        this.emitEveryEventRange = emitEveryEventRange;
        this.agentStoreName = agentStoreName;
        this.offsetStoreName = offsetStoreName;
        this.inputStream = inputStream;
        this.windowStart = windowStart;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        this.context = context;
        offsetKvStore = (KeyValueStore) context.getStateStore(this.offsetStoreName);
        this.timestampToSync_offsetToRead = new Long[2];
        kvStore = (KeyValueStore) context.getStateStore(this.agentStoreName);
        CurrentAgent agent = new CurrentAgent(this.getClass().getSimpleName(),
                "started", 0L);
        Producer<String, CurrentAgent> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties(this.getClass().getSimpleName()));
        kafkaProducer.send(new ProducerRecord<>(DozerConfig.getWorkFlowTopic(), agent));
        kafkaProducer.flush();
        kafkaProducer.close();
    }


    @Override
    public void process(String key, CurrentAgent currentAgent) {
        //todo handle "key", "value"
        if (currentAgent.getAgentName().equals("SERAPH_QUERY_PARSED")
                && currentAgent.getStatus().equals("completed")){
            CurrentAgent updatedAgent = null; //todo handle empty stream, Todo STARTING FROM
            try {
                updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                        "completed", SeraphPayloadHandler.getInitTimeToSync(this.inputStream, this.windowStart));
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key", updatedAgent);
            this.context.commit();

        }
        if(currentAgent.getAgentName().equals(CypherHandlerProcessor.class.getSimpleName())
                && currentAgent.getStatus().equals("completed")){
            this.timestampToSync_offsetToRead = SyncEventInputReader.readCreateEvent
                    (new TopicPartition(DozerConfig.getCdcCreateRelationshipsTopic(), 0),
                            this.emitEveryEventRange, this.offsetKvStore.get("value-sync-generator-event"));

            Long timestampToSync = this.timestampToSync_offsetToRead[0];
            Long offsetToRead = this.timestampToSync_offsetToRead[1];

            this.offsetKvStore.put("value-sync-generator-event", offsetToRead);
            CurrentAgent updatedAgent = new CurrentAgent(this.getClass().getSimpleName(),
                    "completed", timestampToSync);
            if (!DozerConfig.getStopDatetime().equals("-1")){
                if (updatedAgent.getTimestampToSync() > Instant.parse(DozerConfig.getStopDatetime()).toEpochMilli()){
                    System.out.println("Terminating because i reached the STOP_DATETIME!");
                    System.exit(0);
                }
            }
            this.kvStore.put("key", updatedAgent);
            this.context.forward("key",updatedAgent);
            this.context.commit();

        }
    }


    @Override
    public void close() { }
}
