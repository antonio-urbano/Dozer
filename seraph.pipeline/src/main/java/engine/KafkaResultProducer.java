package engine;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsConfig;
import org.json.JSONObject;

import java.util.Map;
import java.util.Properties;

public class KafkaResultProducer {

    static Properties getProducerConfig(){

        final Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-filter-seraph");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName());

        return props;
    }

    static void producerResultRecord(String outputTopic, JSONObject message) {
        Producer<String, Map<String,Object>> producer = new KafkaProducer<>(getProducerConfig());
        producer.send(new ProducerRecord<>(outputTopic, message.toMap()));

    }
}
