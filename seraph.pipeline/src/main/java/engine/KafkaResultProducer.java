package engine;

import config.KafkaConfigProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.json.JSONObject;

import java.util.Map;


public class KafkaResultProducer {

    private final Producer<String, Map<String,Object>> kafkaProducer;

    public KafkaResultProducer(String applicationId){
        this.kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties(applicationId));
    }

    /**
     * Produce the cypherResult into the kafka topic
     * @param outputTopic name of the output topic defined into the register seraph query
     * @param cypherResult the json object corresponding to the cypher query result
     */
    public void producerResultRecord(String outputTopic, JSONObject cypherResult) {
        this.kafkaProducer.send(new ProducerRecord<>(outputTopic, cypherResult.toMap()));
        this.kafkaProducer.flush();
        this.kafkaProducer.close();
    }

}
