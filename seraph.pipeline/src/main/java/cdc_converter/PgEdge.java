package cdc_converter;

import java.util.ArrayList;
import java.util.Map;

public class PgEdge {
    private Integer id;
    private Integer from;
    private Integer to;
    private ArrayList labels;
    private Map<String,ArrayList<Object>> properties;

    public Integer getId() { return id; }
    public Integer getFrom() { return from; }
    public Integer getTo() { return to; }
    public ArrayList getLabels() { return labels; }
    public Map<String, ArrayList<Object>> getProperties() { return properties; }

}
