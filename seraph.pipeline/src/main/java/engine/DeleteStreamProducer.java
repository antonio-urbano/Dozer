package engine;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import stateStore.PubSubRedisStateStore;


public final class DeleteStreamProducer {

    private final CurrentAgent currentAgent;
    private final PubSubRedisStateStore stateStore;
    private final String registeredQueryName;
    private final long windowRange;

    public DeleteStreamProducer(){
        this.currentAgent = new CurrentAgent();
        this.stateStore = new PubSubRedisStateStore(this.currentAgent);
        this.registeredQueryName = QueryConfiguration.getQueryConfiguration().getRegisteredQueryName();
        this.stateStore.readState(this.registeredQueryName);
        this.windowRange = QueryConfiguration.getQueryConfiguration().getWindow_time_range();

    }

    /**
     * Starting from creation records in CDC format it produces deletion records with a customized timestamp.
     * These record will be consumed by the {@link DelayedConsumer} to re-produce the record at proper time
     * @param builder
     * @param tmpDeleteTopicName temporary topic on which produce deletion record with custom timestamp
     */
    public void produceDelayedDeleteCdc(final StreamsBuilder builder, String tmpDeleteTopicName) {
//        PubSubRedisStateStore stateStore = new PubSubRedisStateStore(this.currentAgent);
//        stateStore.subscribeChannel(queryConfiguration.getRegisteredQueryName());
//        System.err.println("KKK_DelStreamProd:  " + this.currentAgent.getAgentName() + "  " + this.currentAgent.getStatus());
//        this.currentAgent.updateCurrentAgent(this.getClass().getSimpleName(), "started", System.currentTimeMillis());
//        System.err.println("KKK_DelStreamProd_2: " + this.currentAgent.getAgentName() + "  " + this.currentAgent.getStatus());
        this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "started"));

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
