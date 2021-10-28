package cdc_converter;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.config.TopicConfig;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class deleteTopic {
    public static void main(String[] args) {
        final String topicName = "dataset-small";
        final String bootstrapServers =  "ec2-15-160-92-234.eu-south-1.compute.amazonaws.com:9092";
        Properties adminClientProps = new Properties();
        adminClientProps.put("bootstrap.servers",bootstrapServers);

        AdminClient adminClient = KafkaAdminClient.create(adminClientProps);

        try {
            DeleteTopicsResult deleteTopicsResult = adminClient.deleteTopics(List.of(topicName));
            while (!deleteTopicsResult.all().isDone()) {};
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
