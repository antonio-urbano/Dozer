package engine;

import config.DozerConfig;
import org.json.JSONObject;
import org.neo4j.driver.Record;
import org.neo4j.driver.*;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.summary.ResultSummary;
import org.neo4j.driver.util.Pair;
import seraphGrammar.RegisterQuery;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProvaResultSummary{

    public static void main(String[] args) {
        Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j", "sink"));
        final String cypherQuery = "MATCH (n:Person)-[r:IS_WITH]->(p:Person) RETURN n,r,p";
        try (Session session = driver.session()) {
//            Result result = session.run(cypherQuery);

            //https://neo4j.com/docs/api/java-driver/current/org/neo4j/driver/summary/ResultSummary.html
            ResultSummary summary = session.run(cypherQuery).consume();

            System.out.println("--------------- SUMMARY -------------");
            System.out.println(summary.toString());
            System.out.println("--------------- Available after -------------");
            System.out.println(summary.resultAvailableAfter(TimeUnit.MICROSECONDS));
            System.out.println("--------------- Consumed after -------------");
            System.out.println(summary.resultConsumedAfter(TimeUnit.MICROSECONDS));



        }
        driver.close();
    }



}
