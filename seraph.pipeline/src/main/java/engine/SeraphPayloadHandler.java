package engine;

import config.KafkaConfigProperties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
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
import java.util.Map;

public class SeraphPayloadHandler {

    final static String REGISTERED_QUERIES_TOPIC="registered-queries-topic15";

    public void updateTimeToSync(SeraphPayload payload){
        if (payload.getTimestamp_to_sync()==null)
            payload.setTimestamp_to_sync(readFirstTimestampToSync());
        else payload.setTimestamp_to_sync(payload.getTimestamp_to_sync()+payload.getEmit_time_range());
    }

    private Long readFirstTimestampToSync() {
        ConsumerRecord<String, ?> relationshipRecord =consumeFirstRecord(Neo4jObj.class,new TopicPartition("relationships", 0));
        if (relationshipRecord!=null)
            return relationshipRecord.timestamp();
        else return null;
    }


    public void writePayloadIntoKafka(SeraphPayload payload){
        Producer<String, SeraphPayload> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.flush();
        kafkaProducer.send(new ProducerRecord<>(REGISTERED_QUERIES_TOPIC, payload));
    }

    public SeraphPayload readPayloadFromKafka(){
        //todo handle which record to consume
        //todo maybe last component can write somewhere last read payload
        ConsumerRecord<String, ?> payloadRecord=consumeFirstRecord(SeraphPayload.class,new TopicPartition(REGISTERED_QUERIES_TOPIC, 0));
        if (payloadRecord!=null)
            return (SeraphPayload) payloadRecord.value();
        else return null;

    }

    private ConsumerRecord<String, ?> consumeFirstRecord(Class<?> classToConsume, TopicPartition topicPartitionToConsume){
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
