package engine;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import stateStore.PubSubRedisStateStore;

import java.util.Date;


public final class DeleteStreamProducer {

//    private CurrentAgent currentAgent;
    private PubSubRedisStateStore stateStore;
    private String registeredQueryName;
    private Long emit_time_range;
    private Long timestamp_to_sync;
    private final boolean isReady;

    public DeleteStreamProducer(){
        this.isReady = initParams();
        if (this.isReady) {
            this.stateStore = new PubSubRedisStateStore(new CurrentAgent());
            this.stateStore.readState(this.registeredQueryName);
        }
    }

    private boolean initParams(){
        SeraphPayloadHandler payloadHandler = new SeraphPayloadHandler();
        SeraphPayload payload = payloadHandler.readPayloadFromKafka();
        if (payload!=null){
            this.registeredQueryName = payload.getQuery_id();
            this.emit_time_range = payload.getEmit_time_range();
            this.timestamp_to_sync = payload.getTimestamp_to_sync();
            return true;
        }
        return false;
    }

    public boolean isReady() { return this.isReady; }

    /**
     * Starting from creation records in CDC format it produces deletion records with a customized timestamp.
     * These record will be consumed by the {@link TimeManagedConsumer} to re-produce the record at proper time
     * @param builder
     * @param tmpDeleteTopicName temporary topic on which produce deletion record with custom timestamp
     */
    public void produceDelayedDeleteCdc(final StreamsBuilder builder, String tmpDeleteTopicName) {
//        PubSubRedisStateStore stateStore = new PubSubRedisStateStore(this.currentAgent);
//        stateStore.subscribeChannel(queryConfiguration.getRegisteredQueryName());
//        System.err.println("KKK_DelStreamProd:  " + this.currentAgent.getAgentName() + "  " + this.currentAgent.getStatus());
//        this.currentAgent.updateCurrentAgent(this.getClass().getSimpleName(), "started", System.currentTimeMillis());
//        System.err.println("KKK_DelStreamProd_2: " + this.currentAgent.getAgentName() + "  " + this.currentAgent.getStatus());

        System.err.println("YYY_DeleteStream:  " + "started  " + new Date(this.timestamp_to_sync));
        this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "started", this.timestamp_to_sync));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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



       KStream<String,OutputObj> stream = builder.stream("relationships", Consumed.with(Serdes.String(), neoSerde).withTimestampExtractor(new CustomerExtractor(this.emit_time_range)))
                .filter((_key, neo4jObj) -> neo4jObj!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getPayload()!=null)
                .filter((_key, neo4jObj) -> neo4jObj.getMeta().get("operation").equals("created"))
                .filter((_key, neo4jObj) -> neo4jObj.getPayload().get("start")!=null)
                .map((k,neo4jObj) -> new KeyValue<>(k, new OutputObj(neo4jObj, this.emit_time_range)));

        stream.to(tmpDeleteTopicName, Produced.with(stringSerde, outputObjSerde));

    }
}
