package engine;

import cdc_converter.CdcCreateRecord;
import config.KafkaConfigProperties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.time.Duration;
import java.util.Collections;

public class SeraphPayloadHandler {

    //todo handle read first record when neo4j is not populated
    public static Long getInitTimeToSync(String inputStream) {
        ConsumerRecord<String, ?> relationshipRecord =consumeFirstRecord(CdcCreateRecord.class,new TopicPartition(inputStream, 0));
        if (relationshipRecord!=null)
            return relationshipRecord.timestamp();
        else return null;
    }

    private static ConsumerRecord<String, ?> consumeFirstRecord(Class<?> classToConsume, TopicPartition topicPartitionToConsume){
        ConsumerFactory<String, ?> cf = new DefaultKafkaConsumerFactory<>(KafkaConfigProperties.getKafkaConsumerProperties(classToConsume));
        Consumer<String, ?> consumer = cf.createConsumer();
        consumer.assign(Collections.singletonList(topicPartitionToConsume));

        consumer.seek(topicPartitionToConsume, consumer.beginningOffsets(Collections.singletonList(topicPartitionToConsume)).get(topicPartitionToConsume));
        ConsumerRecords<String, ?> records = consumer.poll(Duration.ofMillis(100));
        if(!records.isEmpty())
            return records.records(topicPartitionToConsume).get(0);
        else return null;
    }
}
