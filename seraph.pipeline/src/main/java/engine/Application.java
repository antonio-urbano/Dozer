package engine;

import config.KafkaConfigProperties;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Application {

    public static void main(final String[] args) {
        final Properties props = KafkaConfigProperties.getStreamsConfig();
        final StreamsBuilder builder = new StreamsBuilder();

        SeraphQueryParser seraphQueryParser = new SeraphQueryParser();
        seraphQueryParser.parseQuery();

        Thread seraphQueryTicker = new SeraphQueryTicker();
        DeleteStreamProducer deleteStreamProducer = new DeleteStreamProducer();
        Thread cypherThread = new CypherQueryHandler("bolt://localhost:7687", "neo4j", "sink");
        Thread timeManagedConsumer = new TimeManagedConsumer();

        if (deleteStreamProducer.isReady()) // todo else case
            deleteStreamProducer.produceDelayedDeleteCdc(builder,"tmpDeleteTopic4");

        //todo handle thread and isReady
        seraphQueryTicker.start();
        timeManagedConsumer.start();
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
