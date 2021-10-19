package seraphGrammar;

public class RegisterQuery extends Query {
    private SeraphQuery seraphQuery;

    public RegisterQuery(String queryID, SeraphQuery seraphQuery) {
        super(QueryType.REGISTER, queryID);
        this.seraphQuery = seraphQuery;
    }

    public SeraphQuery getSeraphQuery() {
        return seraphQuery;
    }
}
