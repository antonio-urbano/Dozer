package config;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * This class provides a set of method for the Kafka configuration
 */
public class KafkaConfigProperties {

    /**
     * @return the properties associated to the streams config {@link StreamsConfig}
     */
    public static Properties getStreamsConfig() {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "seraph-engine-app");
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        return properties;
    }

    /**
     * @return the kafka producer configs {@link ProducerConfig}
     */
    public static Properties getKafkaProducerProperties() {
        Properties properties = getStreamsConfig();
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());
        return properties;
    }

    /**
     * The consumer will be built using the ConsumerFactory pattern {@link org.springframework.kafka.core.ConsumerFactory}
     * to allow to consume complex records where the value corresponds to the CdcCreateRecord object
     * @return the kafka consumer configs {@link ConsumerConfig}
     */
    public static Map<String, Object> getKafkaConsumerProperties(Class<?> deserializerClass) {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "delayed-consumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.VALUE_DEFAULT_TYPE, deserializerClass);

        return props;
    }


}
