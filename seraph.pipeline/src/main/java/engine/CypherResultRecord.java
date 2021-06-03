package engine;

import org.json.JSONObject;
import org.neo4j.driver.Value;
import org.neo4j.driver.internal.value.*;
import org.neo4j.driver.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * General class for the cypher result,
 * extended by {@link ExceptionCypherResult}, {@link PropertyGraphResultRecord} and {@link ProjectionResultRecord}
 * </p>
 */
public class CypherResultRecord {

    /**
     * List of allowed type both in seraph and cypher
     */
    private final List<Object> allowedTypeList;
    /**
     * List of types that are allowed in cypher but not in seraph.
     * If at least one of the query fields belongs to this list, will be raised an exception
     */
    private final List<Object> exceptionTypeList;

    private JSONObject resultRecord;


    public CypherResultRecord(){
        this.allowedTypeList = new ArrayList();
        this.exceptionTypeList = new ArrayList();

        // TODO handle list of allowed type

        this.allowedTypeList.add(BooleanValue.class);
        this.allowedTypeList.add(StringValue.class);
        this.allowedTypeList.add(IntegerValue.class);
        this.allowedTypeList.add(FloatValue.class);

        // TODO handle list of NOT allowed type
        this.exceptionTypeList.add(MapValue.class);
        this.exceptionTypeList.add(PathValue.class);
        this.exceptionTypeList.add(ListValue.class);

        this.resultRecord = new JSONObject();

    }



    //TODO handle this
    public JSONObject produceRecord(List<Pair<String, Value>> fields) {
        this.resultRecord.put("registeredQueryName", QueryConfiguration.getQueryConfiguration().getRegisteredQueryName());
        return null;
    }

    public List<Object> getAllowedTypeList() { return allowedTypeList; }
    public List<Object> getExceptionTypeList() { return exceptionTypeList; }




}
