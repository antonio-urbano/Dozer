package engine;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;


public class CustomerExtractor implements TimestampExtractor {
    long window_range;

    public CustomerExtractor(long window_range) {
        this.window_range = window_range;
    }

    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long l) {
        return consumerRecord.timestamp() + this.window_range;
    }
}