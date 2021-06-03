package engine;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import seraphGrammar.SeraphLexer;
import seraphGrammar.SeraphParser;
import stateStore.PubSubRedisStateStore;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;


public final class DeleteStreamProducer {

    private final CurrentAgent currentAgent;
    private final PubSubRedisStateStore stateStore;
    private final String registeredQueryName;
    private final long windowRange;

    public DeleteStreamProducer(CurrentAgent currentAgent){
        this.currentAgent = currentAgent;
        this.stateStore = new PubSubRedisStateStore(this.currentAgent);
        this.registeredQueryName = QueryConfiguration.getQueryConfiguration().getRegisteredQueryName();
        this.stateStore.subscribeChannel(this.registeredQueryName);
        this.windowRange = QueryConfiguration.getQueryConfiguration().getWindow_time_range();

    }

    public void produceDelayedDeleteCdc(final StreamsBuilder builder, String tmpDeleteTopicName) {
//        PubSubRedisStateStore stateStore = new PubSubRedisStateStore(this.currentAgent);
//        stateStore.subscribeChannel(queryConfiguration.getRegisteredQueryName());
        this.currentAgent.updateCurrentAgent(this.getClass().getSimpleName(), "started", System.currentTimeMillis());
        stateStore.writeState(this.registeredQueryName, this.currentAgent);

        JsonSerializer<Neo4jObj> neoJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<Neo4jObj> neoJsonDeserializer = new JsonDeserializer<>(
                Neo4jObj.class);
        Serde<Neo4jObj> neoSerde = Serdes.serdeFrom(neoJsonSerializer,
                neoJsonDeserializer);

        JsonSerializer<OutputObj> outputSer = new JsonSerializer<>();
        JsonDeserializer<OutputObj> outputDeser = new JsonDeserializer<>(
                OutputObj.class);
        Serde<OutputObj> outputObjSerde = Serdes.serdeFrom(outputSer,
                outputDeser);
        final Serde<String> stringSerde = Serdes.String();
//        long window_range = queryConfiguration.getWindow_time_range();



       KStream<String,OutputObj> stream = builder.stream("relationships", Consumed.with(Serdes.String(), neoSerde).withTimestampExtractor(new CustomerExtractor(this.windowRange)))
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj)));

        stream.to(tmpDeleteTopicName, Produced.with(stringSerde, outputObjSerde));

    }
}
