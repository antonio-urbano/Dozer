package processors_engine;

import engine.CurrentAgent;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.PunctuationType;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.KeyValueStore;

import java.time.Duration;

public class TimeManagedProcessor implements Processor<String, String> {

    private ProcessorContext context;
    private KeyValueStore<String, String> kvStore;
    private KeyValueStore<String, String> offsetKvStore;


    @Override
    @SuppressWarnings("unchecked")
    public void init(ProcessorContext context) {
        // keep the processor context locally because we need it in punctuate() and commit()
        this.context = context;

        // retrieve the key-value store named "Counts"
        offsetKvStore = (KeyValueStore) context.getStateStore("offset-store");

        kvStore = (KeyValueStore) context.getStateStore("agent-store-time-managed");


//        // schedule a punctuate() method every second based on event-time
//        this.context.schedule(Duration.ofSeconds(1), PunctuationType.STREAM_TIME, (timestamp) -> {
//            KeyValueIterator<String, CurrentAgent> iter = this.kvStore.all();
//            while (iter.hasNext()) {
//                KeyValue<String, CurrentAgent> entry = iter.next();
//                context.forward(entry.key, entry.value.toString());
//            }
//            iter.close();
//
//            // commit the current processing progress
//            context.commit();
//        });
    }

    @Override
    public void process(String key, String timestampToSync) {
//        if(currentAgent.getAgentName().equals(TickerProcessor.class.getSimpleName())) {
            String offsetToRead = this.offsetKvStore.get("value");
            if (offsetToRead==null)
                offsetToRead="0";
            System.err.println("XXX: " + offsetToRead + "   " + timestampToSync);
            Long l = TimeManagedConsumer_2.delayedStream_seek
                    (new TopicPartition("tmpDeleteTopic", 0),
                            "DelayedDelete11", Long.parseLong(timestampToSync), Long.parseLong(offsetToRead));
            this.offsetKvStore.put("value", l.toString());

            this.kvStore.put("key", timestampToSync);
            context.forward("key",timestampToSync);
            context.commit();
//        }
    }

    @Override
    public void close() {

    }
}
