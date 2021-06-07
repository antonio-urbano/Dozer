package engine;

import org.json.JSONObject;
import org.neo4j.driver.Record;
import org.neo4j.driver.*;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.util.Pair;
import stateStore.PubSubRedisStateStore;

import java.util.List;

/**
 * Component in charge of handling the cypher query
 */

public class CypherQueryHandler extends Thread implements AutoCloseable{

    private Driver driver;
    private String cypherQuery;
    private String kafkaTopic;
    private String registeredQueryName;
    private Long timestamp_to_sync;
    private PubSubRedisStateStore stateStore;
    private CurrentAgent currentAgent;
    private final boolean isReady;

    public CypherQueryHandler(String uri, String user, String password)
    {
        this.isReady = initParams();
        if (this.isReady) {
//            QueryConfiguration qc = QueryConfiguration.getQueryConfiguration();
            this.driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
            this.currentAgent = new CurrentAgent();
            this.stateStore = new PubSubRedisStateStore(this.currentAgent);
            this.stateStore.readState(this.registeredQueryName);
        }
    }

    private boolean initParams(){
        SeraphPayloadHandler payloadHandler = new SeraphPayloadHandler();
        SeraphPayload payload = payloadHandler.readPayloadFromKafka();
        if (payload!=null){
            this.registeredQueryName = payload.getQuery_id();
            this.kafkaTopic = payload.getOutput_stream_topic();
            this.cypherQuery = payload.getCypher_query();
            this.timestamp_to_sync = payload.getTimestamp_to_sync();
            return true;
        }
        return false;
    }

    public boolean isReady() { return isReady; }

    /**
     * Establish the connection with the neo4j instance and run the cypher query
     * The result is then transformed in proper json format {@link CypherResultRecord}
     * @return
     */
    public JSONObject runQuery() {
        try (Session session = driver.session()) {
            Result result = session.run(this.cypherQuery);
            JSONObject jsonResultRecord = null;
            CypherResultRecord cypherResultRecord;

            if (result.hasNext())
                cypherResultRecord = checkRecordType(result.peek().fields());
            else return null;

            while (result.hasNext()) {
                Record record = result.next();
                jsonResultRecord = cypherResultRecord != null ? cypherResultRecord.produceRecord(record.fields()) : null;

            }

            return jsonResultRecord;
        }
    }

    /**
     * <p>
     * This method inspects the fields of the cypher query and it establishes
     * the record type
     * </p>
     * We can have the following cases:
     * <ul>
     * <li>All the fields belong to the allowed type list and so the result record will contain only projections over node/relationships attributes</li>
     * <li>All the fields are Node and/or Relationships and so the result must have a Property Graph format</li>
     * <li>Some fields belong to the exception type list, the engine will raise an exception</li>
     * <li>The fields contain both projection and Nodes/Relationships </li> //todo write how we handle the case
     * </ul>
     * @param fields
     * @return the record type to decide later the proper output json format
     */
    private CypherResultRecord checkRecordType(List<Pair<String, Value>> fields) {
        CypherResultRecord cypherResultRecord = new CypherResultRecord();
        boolean propertyGraph_flag = false;
        boolean projection_flag = false;
        boolean exception_flag = false;

        if(fields.stream().anyMatch(v -> v.value() instanceof NodeValue)
                || fields.stream().anyMatch(v -> v.value() instanceof RelationshipValue))
            propertyGraph_flag = true;
        if (fields.stream().anyMatch(v -> cypherResultRecord.getExceptionTypeList().contains(v.value().getClass())))
            exception_flag = true;
        if (fields.stream().anyMatch(v -> cypherResultRecord.getAllowedTypeList().contains(v.value().getClass())))
            projection_flag = true;

        if (exception_flag)
            return new ExceptionCypherResult();         //TODO handle exception case
        else if(propertyGraph_flag && projection_flag)
            return null;                                //TODO handle this case
        else if(propertyGraph_flag)
            return new PropertyGraphResultRecord();
        else if (projection_flag)
            return new ProjectionResultRecord();
        else return null;
    }



    @Override
    public void close() { driver.close(); }

    /*
    public void run() {
        System.out.println("Query Handler Thread started");
        PubSubRedisStateStore stateStore = new PubSubRedisStateStore();
        while (PubSubRedisStateStore.getAgentName() != null) {
            stateStore.readState(DeleteStreamProducer.class.getName());
                System.err.println("PPPPPPPPP: " + PubSubRedisStateStore.getAgentName());
                while (!PubSubRedisStateStore.getAgentName().equals("completed")) {
                    try {
                        synchronized (monitor) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                while (PubSubRedisStateStore.getAgentName().equals("completed")) {
                    System.err.println("HHH: " + PubSubRedisStateStore.getAgentName());
                    JSONObject jsonQueryResult = runQuery();
                    if (jsonQueryResult == null)
                        System.err.println("Null query result");
                    else KafkaResultProducer.producerResultRecord(this.kafkaTopic, jsonQueryResult);
                }
        }
    }
     */

    /*public void run() {
        this.stateStore.readState("globalStateStore");
        while (true) {
            synchronized (monitor) {
                    while (!CurrentAgent.getCurrentAgent().equals(DelayedConsumer.class.getName())) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    monitor.notifyAll();
                    System.err.println("HHH_CypherHandler: " + CurrentAgent.getCurrentAgent());
                    JSONObject jsonQueryResult = runQuery();
                    if (jsonQueryResult == null)
                        System.err.println("Null query result");
                    else KafkaResultProducer.producerResultRecord(this.kafkaTopic, jsonQueryResult);
                }
        }
    }*/


    // TODO javadoc
    public void run(){
        System.err.println("KKKK: " + this.currentAgent.getAgentName());
        while (true){
            if(this.currentAgent.getAgentName().equals(DelayedConsumer.class.getSimpleName()) && this.currentAgent.getStatus().equals("completed")){
                this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "started", this.timestamp_to_sync));
                System.err.println("YYY_CypherHandler:  " + "CypherHandler started");
                //blocco lavoro
                this.stateStore.writeState(this.registeredQueryName, new CurrentAgent(this.getClass().getSimpleName(), "completed", this.timestamp_to_sync));
                System.err.println("YYY_CypherHandler:  " + "CypherHandler completed");
            }
        }
    }
}
