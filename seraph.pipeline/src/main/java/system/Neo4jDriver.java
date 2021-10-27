package system;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;

public class Neo4jDriver implements AutoCloseable {
    private Driver neo4jDriver;

    public Neo4jDriver(String uri, String user, String password) {
        this.neo4jDriver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
        this.neo4jDriver.verifyConnectivity();
    }

    public Result runQuery(String query) {
        return this.neo4jDriver.session().run(query);
    }
    @Override
    public void close() throws Exception {
        this.neo4jDriver.close();
    }
}
