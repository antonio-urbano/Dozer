package processors;

import cdc_converter.CdcCreateRecord;
import config.DozerConfig;
import config.KafkaConfigProperties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.time.Duration;
import java.util.Collections;

/**
 * This class is used by the {@link SyncGeneratorProcessorEvent} to handle the timestampToSync, i.e.
 * the timestamp to which all the components have to synchronize, in the case in which
 * the EVERY operator is defined in terms of number of events.
 */
/*
classe utilizzata dal ticker processor event
legge da input topic delle relazioni (partendo da offset_to_read)
Ha un contatore interno, quando raggiunge il treshold (window_event_range)
aggiorna il timestamp_to_synch e l'offset_to_read
 */

public class SyncEventInputReader {

    /**
     * Method called by the {@link SyncGeneratorProcessorEvent} to read from the CDC "create events" stream,
     * starting from the offsetToRead.
     * Every time a new record is read, an internal counter is incremented. Once the counter is equal
     * to the emitEveryEventRange, the method returns both the updated offsetToRead and the timestamp associated
     * to the last consumed record
     * @param topicPartition associated to the input topic from which consume
     * @param emitEveryEventRange defines the frequency of the evaluation process
     * @param offsetToRead offset from which start to read (initially set to 0)
     * @return both the updated offsetToRead and the timestamp associated to the last consumed record
     */
    static Long[] readCreateEvent(TopicPartition topicPartition, Long emitEveryEventRange, Long offsetToRead) {

        ConsumerFactory<String, CdcCreateRecord> cf = new DefaultKafkaConsumerFactory<>(KafkaConfigProperties.getKafkaConsumerProperties(CdcCreateRecord.class, "syncEventRead"));
        Consumer<String, CdcCreateRecord> consumer = cf.createConsumer(); //todo
        consumer.assign(Collections.singletonList(topicPartition));


        if(offsetToRead==null)
            offsetToRead=consumer.beginningOffsets(Collections.singletonList(topicPartition)).get(topicPartition);


        consumer.seek(topicPartition, offsetToRead);
        Long counter=0L;
        Long[] return_values = new Long[2];
        while (true) {
            ConsumerRecords<String, CdcCreateRecord> records = consumer.poll(Duration.ofMillis(600));
            if (!records.isEmpty()) {
                for (ConsumerRecord<String, CdcCreateRecord> r : records.records(topicPartition)) {
                    if (counter<emitEveryEventRange) {
                        counter++;
                        offsetToRead = r.offset() + 1;
                    }
                    else{
                        return_values[0] = r.timestamp();
                        return_values[1] = offsetToRead;
                        return return_values;
                    }
                }
            }
        }

    }

}