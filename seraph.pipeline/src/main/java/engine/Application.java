package engine;

import config.ConfigProperties;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Application {

    public static void main(final String[] args) {
        CurrentAgent currentAgent = new CurrentAgent();
        DeleteStreamProducer deleteStreamProducer = new DeleteStreamProducer(currentAgent);

        final Properties props = ConfigProperties.getStreamsConfig();
        final StreamsBuilder builder = new StreamsBuilder();
        SeraphQueryParser.parseQuery();
        QueryConfiguration queryConfiguration = QueryConfiguration.getQueryConfiguration();
        deleteStreamProducer.produceDelayedDeleteCdc(builder, queryConfiguration,"tmpDeleteTopic");
        Thread cypherThread = new CypherQueryHandler("bolt://localhost:7687", "neo4j", "sink", queryConfiguration, currentAgent);
        Thread delayedConsumerThread = new DelayedConsumer(currentAgent, queryConfiguration.getRegisteredQueryName());
        delayedConsumerThread.start();
        cypherThread.start();

        final KafkaStreams streams = new KafkaStreams(builder.build(), props);
        final CountDownLatch latch = new CountDownLatch(1);

        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-filter-seraph-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (final Throwable e) {
            System.exit(1);
        }
        System.exit(0);

    }
}
