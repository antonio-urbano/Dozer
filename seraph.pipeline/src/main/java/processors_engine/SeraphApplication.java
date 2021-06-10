package processors_engine;

import engine.CurrentAgent;
import engine.JsonDeserializer;
import engine.JsonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.state.Stores;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class SeraphApplication {

    public static void main(final String[] args) {
        final Properties props = new Properties();

        JsonSerializer<CurrentAgent> agentJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<CurrentAgent> agentJsonDeserializer = new JsonDeserializer<>(
                CurrentAgent.class);
        Serde<CurrentAgent> agentSerde = Serdes.serdeFrom(agentJsonSerializer,
                agentJsonDeserializer);

        Serde<Long> longSerde = Serdes.Long();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "streams-seraph-processors");
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        props.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());


        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        final Topology builder = new Topology();

        builder.addSource("Source", "processor-topic15");

        builder.addProcessor("TickerProcessor", TickerProcessor::new, "Source");
        builder.addProcessor("TimeManagedProcessor", TimeManagedProcessor::new, "Source");

        builder.addStateStore(Stores.keyValueStoreBuilder(
                Stores.inMemoryKeyValueStore("agent-store-ticker"),
                Serdes.String(),
                Serdes.String()),
                "TickerProcessor");

        builder.addStateStore(Stores.keyValueStoreBuilder(
                Stores.inMemoryKeyValueStore("agent-store-time-managed"),
                Serdes.String(),
                Serdes.String()),
                "TimeManagedProcessor");

        builder.addStateStore(Stores.keyValueStoreBuilder(
                Stores.inMemoryKeyValueStore("offset-store"),
                Serdes.String(),
                Serdes.String()),
                "TimeManagedProcessor");


        builder.addSink("Sink", "processor-topic15","TickerProcessor", "TimeManagedProcessor");

        final KafkaStreams streams = new KafkaStreams(builder, props);
        final CountDownLatch latch = new CountDownLatch(1);

        System.out.println("----------------------------");
        System.out.println(builder.describe());
        System.out.println("----------------------------");


        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("streams-wordcount-shutdown-hook") {
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

