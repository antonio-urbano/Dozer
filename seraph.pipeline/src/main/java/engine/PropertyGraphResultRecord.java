package engine;

import org.json.JSONArray;
import org.json.JSONObject;
import org.neo4j.driver.Value;
import org.neo4j.driver.internal.value.NodeValue;
import org.neo4j.driver.internal.value.RelationshipValue;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.types.Relationship;
import org.neo4j.driver.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyGraphResultRecord extends CypherResultRecord{

    private JSONObject resultRecord;

    public PropertyGraphResultRecord(){
        this.resultRecord = new JSONObject();
        this.resultRecord.put("nodes", new JSONArray());
        this.resultRecord.put("edges", new JSONArray());
    }


    public JSONObject produceRecord(List<Pair<String, Value>> fields) {

        for (Pair<String, Value> f : fields) {
            if (f.value() instanceof NodeValue) {
                JSONArray nodesArray = this.resultRecord.getJSONArray("nodes");

                NodeValue nodeValue = (NodeValue) f.value();
                Node node = nodeValue.asNode();
                JSONObject jsonNode = nodeToJSONNode(node);
                this.resultRecord.put("nodes", addJSONObjectToArray(nodesArray, jsonNode));

            } else {
                JSONArray edgesArray = this.resultRecord.getJSONArray("edges");

                RelationshipValue relationshipValue = (RelationshipValue) f.value();
                Relationship relationship = relationshipValue.asRelationship();
                JSONObject jsonRelationship = relationshipToJSONRelationship(relationship);
                this.resultRecord.put("edges", addJSONObjectToArray(edgesArray, jsonRelationship));
            }
        }
        this.resultRecord.put("registeredQueryName", QueryConfiguration.getQueryConfiguration().getRegisteredQueryName());
        return this.resultRecord;
    }

    private JSONArray addJSONObjectToArray(JSONArray jsonArray, JSONObject jsonObject){
        for(int i=0;i<jsonArray.length();i++){
            JSONObject jsonObj = (JSONObject) jsonArray.get(i);
            if (jsonObj.get("id").equals(jsonObject.get("id"))) {
                jsonArray.put(i, jsonObj);
                return jsonArray;

            }
        }
        jsonArray.put(jsonObject);
        return jsonArray;
    }

    private JSONObject relationshipToJSONRelationship(Relationship relationship) {

        JSONObject jsonRel = new JSONObject();
        ArrayList<String> labelsArray = new ArrayList<>();
        labelsArray.add(relationship.type());
        JSONArray labelsArrayJSON = new JSONArray(labelsArray);

        jsonRel.put("id", relationship.id());
        jsonRel.put("from", relationship.startNodeId());
        jsonRel.put("to", relationship.endNodeId());
        jsonRel.put("labels",labelsArrayJSON);
        jsonRel.put("properties", propertiesToJSONProperties(relationship.asMap()));

        return jsonRel;
    }

    private JSONObject nodeToJSONNode (Node node){

        JSONObject jsonNode = new JSONObject();
        jsonNode.put("id", node.id());
        jsonNode.put("properties", propertiesToJSONProperties(node.asMap()));
        jsonNode.put("labels", new JSONArray(node.labels()));

        return jsonNode;
    }

    private JSONObject propertiesToJSONProperties (Map<String,Object> objMap){

        Map<String,ArrayList<Object>> propertiesPG = new HashMap<>();
        objMap.forEach((k,v)-> propertiesPG.computeIfAbsent(k, x ->new ArrayList<>()).add(v));

        return new JSONObject(propertiesPG);
    }

}
