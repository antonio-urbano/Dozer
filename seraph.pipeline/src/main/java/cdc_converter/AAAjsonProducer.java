package cdc_converter;

import com.google.gson.Gson;
import config.KafkaConfigProperties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AAAjsonProducer {
    public static void main(final String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("/home/antonio/Scrivania/personPgJson.json"));
        JsonPG pg = new Gson().fromJson(br, JsonPG.class);
        final Producer<String, JsonPG> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("eventtopic", pg));
        kafkaProducer.flush();
        kafkaProducer.close();
    }
}
