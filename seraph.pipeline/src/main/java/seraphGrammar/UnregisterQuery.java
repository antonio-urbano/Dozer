package seraphGrammar;

public class UnregisterQuery extends Query {
    public UnregisterQuery(String queryID) {
        super(QueryType.UNREGISTER, queryID);
    }
}
