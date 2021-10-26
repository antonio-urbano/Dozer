package cdc_converter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;

public class JsonPG implements Serializable {

    @JsonCreator
    public JsonPG(){}

    @JsonIgnore
    public JsonPG(ArrayList<PgNode> nodes, ArrayList<PgEdge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    private ArrayList<PgNode> nodes;
    private ArrayList<PgEdge> edges;

    public ArrayList<PgNode> getNodes() { return nodes; }
    public ArrayList<PgEdge> getEdges() { return edges; }

}
