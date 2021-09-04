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

/*
classe utilizzata dal ticker processor event
legge da input topic delle relazioni (partendo da offset_to_read)
Ha un contatore interno, quando raggiunge il treshold (window_event_range)
aggiorna il timestamp_to_synch e l'offset_to_read
 */

public class TickerEventInputReader {

    static Long[] readCreateEvent(TopicPartition topicPartition, Long eventRange, Long offsetToRead) {

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
                    if (counter<eventRange) {
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