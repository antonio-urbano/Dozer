package cdc_converter;

import java.util.ArrayList;
import java.util.Map;

public class PgNode {
    private Integer id;
    private ArrayList<String> labels;
    private Map<String,ArrayList<Object>> properties;

    public Integer getId() { return id; }
    public ArrayList<String> getLabels() { return labels; }
    public Map<String, ArrayList<Object>> getProperties() { return properties; }
}
