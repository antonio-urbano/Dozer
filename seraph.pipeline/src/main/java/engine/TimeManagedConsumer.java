package engine;

import cdc_converter.CdcCreateRecord;
import config.DozerConfig;
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

/**
 * This class is used to handle the consumption from Kafka at proper timestamp
 */
public class TimeManagedConsumer {
    private Consumer<String, Object> consumer;
    private TopicPartition topicPartition;
    public TimeManagedConsumer(TopicPartition topicPartition, String consumerDelayedType){
        this.topicPartition = topicPartition;
        ConsumerFactory<String, Object> cf = new DefaultKafkaConsumerFactory<>(KafkaConfigProperties.getKafkaConsumerProperties(CdcCreateRecord.class, consumerDelayedType));
        this.consumer = cf.createConsumer(); //todo
        consumer.assign(Collections.singletonList(topicPartition));
    }

    /**
     * This method consumes all the records with a timestamp less than the timestampToSync and send them to the outputTopic.
     * It stops to consume when a record with a greater timestamp is found and
     * it returns the corresponding offsetToRead
    //todo * @param topicPartition topic partition from which consume

     * @param outputTopic topic name to which publish the consumed records at proper timestamp
     * @param timestampToSync the last timestamp to which all the components has to synchronize
     * @param offsetToRead offset from which start to read (initially set to 0)
     * @return the update offsetToRead value, corresponding to the offset of the record
     * with a timestamp greater than the timestampToSync
     */

    public Long delayedStream_seek(String outputTopic, Long timestampToSync, Long offsetToRead, String typeDelayed) {


        Producer<String, Object> producer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties("time_managed_consumer_"+typeDelayed));//todo

        if(offsetToRead==null)
            offsetToRead=consumer.beginningOffsets(Collections.singletonList(topicPartition)).get(topicPartition);


        consumer.seek(topicPartition, offsetToRead);
        while (true) {
            ConsumerRecords<String, Object> records = consumer.poll(Duration.ofMillis(2000));   //todo
            if (!records.isEmpty()) {
                for (ConsumerRecord<String, Object> r : records.records(topicPartition)) {
                    if (r.timestamp() < timestampToSync) {
                        producer.send(new ProducerRecord<>(outputTopic, 0, r.timestamp(), r.key(), r.value()));
                        producer.flush();
                        offsetToRead = r.offset() + 1;
                    }
                    else {
                        producer.close();
                        return offsetToRead;
                    }
                }
            }
        }

    }

}