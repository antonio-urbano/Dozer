package engine;

import cdc_converter.CdcCreateRecord;
import config.KafkaConfigProperties;
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

public class SeraphPayloadHandler {

    final static String REGISTERED_QUERIES_TOPIC="registered-queries-topic";      // todo topic name


    //todo handle read first record when neo4j is not populated
    public static Long getInitTimeToSync() {
        ConsumerRecord<String, ?> relationshipRecord =consumeFirstRecord(CdcCreateRecord.class,new TopicPartition("relationships", 0));
        if (relationshipRecord!=null)
            return relationshipRecord.timestamp();
        else return null;
    }


    public void writePayloadIntoKafka(SeraphPayload payload){
        Producer<String, SeraphPayload> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.flush();
        payload.setTimestampToSync(getInitTimeToSync());
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
