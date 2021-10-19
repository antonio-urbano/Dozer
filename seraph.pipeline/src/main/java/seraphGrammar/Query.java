package seraphGrammar;

public abstract class Query {
    private QueryType queryType;
    private String queryID;

    public Query(QueryType queryType, String queryID) {
        this.queryType = queryType;
        this.queryID = queryID;
    }

    public QueryType getQueryType() {
        return queryType;
    }

    public String getQueryID() {
        return queryID;
    }
}
