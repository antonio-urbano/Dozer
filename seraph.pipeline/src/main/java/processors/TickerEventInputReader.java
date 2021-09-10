package processors;

import config.KafkaConfigProperties;
import engine.Neo4jObj;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.time.Duration;
import java.util.Collections;

/**
 * This class is used by the {@link TickerProcessorEvent} to handle the timestampToSync, i.e.
 * the timestamp to which all the components have to synchronize, in the case in which
 * the EVERY operator is defined in terms of number of events.
 */
/*
classe utilizzata dal ticker processor event
legge da input topic delle relazioni (partendo da offset_to_read)
Ha un contatore interno, quando raggiunge il treshold (window_event_range)
aggiorna il timestamp_to_synch e l'offset_to_read
 */

public class TickerEventInputReader {

    /**
     * Method called by the {@link TickerProcessorEvent} to read from the input topic starting from the
     * offsetToRead.
     * Every time a new input record is read an internal counter is incremented and once the counter is equal
     * to the windowEventRange the methods returns both the updated offsetToRead and the timestamp associated
     * to the last consumed record
     * @param topicPartition associated to the input topic from which consume
     * @param windowEventRange defines the frequency of the evaluation process
     * @param offsetToRead offset from which start to read (initially set to 0)
     * @return both the updated offsetToRead and the timestamp associated to the last consumed record
     */
    static Long[] readCreateEvent(TopicPartition topicPartition, Long windowEventRange, Long offsetToRead) {

        ConsumerFactory<String, Neo4jObj> cf = new DefaultKafkaConsumerFactory<>(KafkaConfigProperties.getKafkaConsumerProperties(Neo4jObj.class));
        Consumer<String, Neo4jObj> consumer = cf.createConsumer();
        consumer.assign(Collections.singletonList(topicPartition));


        if(offsetToRead==null)
            offsetToRead=consumer.beginningOffsets(Collections.singletonList(topicPartition)).get(topicPartition);


        consumer.seek(topicPartition, offsetToRead);
        Long counter=0L;
        Long[] return_values = new Long[2];
        while (true) {
            ConsumerRecords<String, Neo4jObj> records = consumer.poll(Duration.ofMillis(100));
            if (!records.isEmpty()) {
                for (ConsumerRecord<String, Neo4jObj> r : records.records(topicPartition)) {
                    if (counter<windowEventRange) {
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