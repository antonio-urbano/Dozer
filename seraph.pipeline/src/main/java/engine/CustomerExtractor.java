package engine;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.streams.processor.TimestampExtractor;

/**
 * Custom timestamp extractor {@link TimestampExtractor}
 * to add a delay equals to the window time range to the kafka record built-in timestamp
 */
public class CustomerExtractor implements TimestampExtractor {
    long windowTimeRange;

    public CustomerExtractor(long windowTimeRange) {
        this.windowTimeRange = windowTimeRange;
    }

    @Override
    public long extract(ConsumerRecord<Object, Object> consumerRecord, long l) {
        return consumerRecord.timestamp() + this.windowTimeRange;
    }
}