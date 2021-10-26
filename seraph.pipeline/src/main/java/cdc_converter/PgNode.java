package cdc_converter;

import java.util.ArrayList;
import java.util.Map;

public class PgNode {
    private Integer id;
    private ArrayList<String> labels;
    private Map<String,ArrayList<Object>> properties;

    public PgNode(){ }

    public PgNode(Integer id, ArrayList<String> labels, Map<String, ArrayList<Object>> properties) {
        this.id = id;
        this.labels = labels;
        this.properties = properties;
    }


    public Integer getId() { return id; }
    public ArrayList<String> getLabels() { return labels; }
    public Map<String, ArrayList<Object>> getProperties() { return properties; }


}
