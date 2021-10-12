package cdc_converter;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.Serializable;
import java.util.ArrayList;

public class PropertyGraph implements Serializable {

    @JsonCreator
    public PropertyGraph(){}

    private ArrayList<PgNode> nodes;
    private ArrayList<PgEdge> edges;

    public ArrayList<PgNode> getNodes() { return nodes; }
    public ArrayList<PgEdge> getEdges() { return edges; }

}
