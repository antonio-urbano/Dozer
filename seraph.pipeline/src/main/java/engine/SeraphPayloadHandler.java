package engine;

import cdc_converter.CdcCreateRecord;
import config.DozerConfig;
import config.KafkaConfigProperties;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import seraphGrammar.Event;
import seraphGrammar.EventStart;
import seraphGrammar.Start;
import seraphGrammar.TimeStart;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SeraphPayloadHandler {

    //todo handle read first record when neo4j is not populated
    public static Long getInitTimeToSync(String inputStream, Start windowStart) throws Exception {
        if (windowStart instanceof EventStart){
            Event event = ((EventStart) windowStart).getEvent();
            ConsumerRecord<String, ?> relationshipRecord = null;
            if (event.equals(Event.Earliest))
                relationshipRecord = consumeFirstRecord(CdcCreateRecord.class,new TopicPartition(inputStream, 0));
            else if (event.equals(Event.Latest))
                return System.currentTimeMillis();//relationshipRecord = consumeLastRecord(CdcCreateRecord.class,new TopicPartition(inputStream, 0));

            if (relationshipRecord!=null)
                return relationshipRecord.timestamp();
            else throw new Exception("Cannot consume fisrt record!");
        }
        else
            return ((TimeStart) windowStart).getInstant().toEpochMilli();
    }

    public static Map<String, Object> getKafkaConsumerProperties(Class<?> deserializerClass) {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, DozerConfig.getKafkaBroker());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, DozerConfig.getSeraphQuery().getQueryID() + "_timeToSyncInitializer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, deserializerClass);

        return props;
    }

    //todo close consumer
    private static ConsumerRecord<String,?> consumeLastRecord(Class<?> classToConsume, TopicPartition topicPartitionToConsume){
        ConsumerFactory<String, ?> cf = new DefaultKafkaConsumerFactory<>(getKafkaConsumerProperties(classToConsume));
        Consumer<String, ?> consumer = cf.createConsumer(); //todo groupId, client
        consumer.assign(Collections.singletonList(topicPartitionToConsume));

        consumer.seek(topicPartitionToConsume, consumer.endOffsets(Collections.singletonList(topicPartitionToConsume)).get(topicPartitionToConsume)-1);
        ConsumerRecords<String, ?> records = consumer.poll(Duration.ofMillis(100));
        if(!records.isEmpty())
            return records.records(topicPartitionToConsume).get(0);
        else return null;       //todo handle empty record
    }

    private static ConsumerRecord<String, ?> consumeFirstRecord(Class<?> classToConsume, TopicPartition topicPartitionToConsume){
        ConsumerFactory<String, ?> cf = new DefaultKafkaConsumerFactory<>(getKafkaConsumerProperties(classToConsume));
        Consumer<String, ?> consumer = cf.createConsumer(); //todo group, client
        consumer.assign(Collections.singletonList(topicPartitionToConsume));

        consumer.seek(topicPartitionToConsume, consumer.beginningOffsets(Collections.singletonList(topicPartitionToConsume)).get(topicPartitionToConsume));
        ConsumerRecords<String, ?> records = consumer.poll(Duration.ofMillis(600));
        consumer.close();
        if(!records.isEmpty())
            return records.records(topicPartitionToConsume).get(0);
        else return null;       //todo handle empty record
    }
}
