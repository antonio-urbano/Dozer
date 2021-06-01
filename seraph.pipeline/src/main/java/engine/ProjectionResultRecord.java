package engine;

import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.driver.Value;
import org.neo4j.driver.internal.value.BooleanValue;
import org.neo4j.driver.internal.value.FloatValue;
import org.neo4j.driver.internal.value.IntegerValue;
import org.neo4j.driver.internal.value.StringValue;
import org.neo4j.driver.util.Pair;
import java.util.List;

public class ProjectionResultRecord extends CypherResultRecord {

    private JSONObject resultRecord;

    public ProjectionResultRecord(){
        this.resultRecord = new JSONObject();
        this.resultRecord.put("items", new JSONArray());
    }

    public JSONObject produceRecord(List<Pair<String, Value>> fields) {
        JSONArray itemsArray = this.resultRecord.getJSONArray("items");
        JSONObject record = new JSONObject();

        for(Pair<String,Value> f: fields) {

            if (f.value() instanceof StringValue)
                record.put(f.key(), f.value().asString());
            else if (f.value() instanceof BooleanValue)
                record.put(f.key(), f.value().asBoolean());
            else if (f.value() instanceof IntegerValue)
                record.put(f.key(), f.value().asInt());
            else if (f.value() instanceof FloatValue)
                record.put(f.key(), f.value().asFloat());
        }
        itemsArray.put(record);
        this.resultRecord.put("items", itemsArray);
        this.resultRecord.put("registeredQueryName", QueryConfiguration.getQueryConfiguration().getRegisteredQueryName());
        return this.resultRecord;
    }

}
