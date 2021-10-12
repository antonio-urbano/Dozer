package cdc_converter;

import custom_serdes.CdcSerde;
import custom_serdes.JsonDeserializer;
import custom_serdes.JsonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class PgJsonConsumer {

    static Properties getProperties(){
        Properties props = new Properties();

        props.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "dozer-converter-processors-app");
        props.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.putIfAbsent(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        props.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, CdcSerde.class);
        // setting offset reset to earliest so that we can re-run the demo code with the same pre-loaded data
        props.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return props;
    }

    static void convertPgToCDC(final StreamsBuilder builder) {

        JsonSerializer<JsonPG> PGJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<JsonPG> PGJsonDeserializer = new JsonDeserializer<>(
                JsonPG.class);
        Serde<JsonPG> jsonSerde = Serdes.serdeFrom(PGJsonSerializer,
                PGJsonDeserializer);


        KStream<String, JsonPG> stream = builder.stream("JsonPG-topic",
                Consumed.with(Serdes.String(), jsonSerde));
        stream.process(ProcessorConverter::new);

    }

    public static void main(final String[] args) throws FileNotFoundException {

        final StreamsBuilder builder = new StreamsBuilder();
        convertPgToCDC(builder);
        final KafkaStreams streams = new KafkaStreams(builder.build(), getProperties());
        final CountDownLatch latch = new CountDownLatch(1);


        // attach shutdown handler to catch control-c
        Runtime.getRuntime().addShutdownHook(new Thread("pg-cdc-streams-shutdown-hook") {
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
