package engine;

import config.ConfigProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import java.util.Map;

public class KafkaResultProducer {

    private final Producer<String, Map<String,Object>> kafkaProducer;

    public KafkaResultProducer(){
        this.kafkaProducer = new KafkaProducer<>(ConfigProperties.getKafkaProducerProperties());
    }

    public void producerResultRecord(String outputTopic, JSONObject message) {
        this.kafkaProducer.send(new ProducerRecord<>(outputTopic, message.toMap()));
    }

}
