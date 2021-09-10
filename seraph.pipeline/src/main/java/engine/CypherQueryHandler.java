package engine;

import org.json.JSONObject;
import org.neo4j.driver.*;
import org.neo4j.driver.Record;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.util.Pair;

import java.util.List;

public class CypherQueryHandler implements AutoCloseable{

    private Driver driver;
    private String cypherQuery = "MATCH  (patient:Patient)-[t:TESTED_FOR {positive:true}]->(virus:Virus) RETURN DISTINCT patient.name, virus.name;";    //todo
    private String kafkaTopic = "resulttopic2"; //todo


    public CypherQueryHandler(String uri, String user, String password)
    {
        this.driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    /**
     * Establish the connection with the neo4j instance and run the cypher query
     * The result is then transformed in proper json format {@link CypherResultRecord}
     * @return the result of the cypher query as JSONObject format
     */
    private JSONObject runQuery() {
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
     * Write the result record into kafka
     */
    public void cypherResultIntoKafka(){
        KafkaResultProducer kafkaResultProducer = new KafkaResultProducer();
        JSONObject jsonQueryResult = runQuery();
        if (jsonQueryResult==null)
            System.err.println("Null query result");        //todo null query result
        else  kafkaResultProducer.producerResultRecord(this.kafkaTopic, jsonQueryResult);

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



}
