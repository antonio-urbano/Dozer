package cdc_converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class testLinearDataset {
    public static void main(final String[] args) throws IOException {

        /*BufferedReader br = new BufferedReader(new FileReader("/home/antonio/Scrivania/personPgJson.json"));
        JsonPG pg = new Gson().fromJson(br, JsonPG.class);
        final Producer<String, JsonPG> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties());
        kafkaProducer.send(new ProducerRecord<>("eventtopic", pg));
        kafkaProducer.flush();
        kafkaProducer.close();*/

        /*
        private Integer id;
    private ArrayList<String> labels;
    private Map<String,ArrayList<Object>> properties;
         */

//        BufferedReader br = new BufferedReader(new FileReader("/home/antonio/Scrivania/personPgJson.json"));


//        Producer<String, JsonPG> kafkaProducer = new KafkaProducer<>(KafkaConfigProperties.getKafkaProducerProperties("testLinear"));
        AtomicLong initTimestamp = new AtomicLong(1609455600000L);

        AtomicInteger personID = new AtomicInteger(0);
        AtomicInteger edgeId = new AtomicInteger(0);
        ArrayList<String> labelsPerson = new ArrayList<>();
        labelsPerson.add("Person");
        Map<String,ArrayList<Object>> propertiesPerson = new HashMap<>();
        ArrayList<Object> nameProperties = new ArrayList<>();
        nameProperties.add("P"+personID.toString());
        ArrayList<Object> timestampProperties = new ArrayList<>();
        timestampProperties.add(initTimestamp.get());
        propertiesPerson.put("name", nameProperties);
        propertiesPerson.put("timestamp", timestampProperties);
        PgNode node = new PgNode(personID.get(), labelsPerson, propertiesPerson);
        ArrayList<PgNode> nodes = new ArrayList<>();
        nodes.add(node);
        JsonPG jsonPG = new JsonPG(nodes, new ArrayList<>());

        /*kafkaProducer.send(new ProducerRecord<>("eventtopic", jsonPG));
        kafkaProducer.flush();*/
        Writer writer = new FileWriter("/home/antonio/Scrivania/testDozer/"+initTimestamp.get()+".json");
        Gson gson = new GsonBuilder().create();
        gson.toJson(jsonPG, writer);
        writer.flush(); //flush data to file   <---
        writer.close(); //close write


        // creating timer task, timer
        Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {

                ArrayList<Object> timestampProperties = new ArrayList<>();
                initTimestamp.set(initTimestamp.get()+300);
                timestampProperties.add(0, initTimestamp.get());

                propertiesPerson.put("timestamp", timestampProperties);
                PgNode node = new PgNode(personID.get()+1, labelsPerson, propertiesPerson);
                nodes.set(0, node);

                Map<String,ArrayList<Object>> propertiesEdge = new HashMap<>();
                propertiesEdge.put("timestamp", timestampProperties);
                ArrayList<String> labelsEdge = new ArrayList<>();
                labelsEdge.add("IS_WITH");
                PgEdge edge = new PgEdge(edgeId.get(), personID.get(), personID.get()+1, labelsEdge, propertiesEdge);
                edgeId.set(edgeId.get()+1);
                ArrayList<PgEdge> edges = new ArrayList<>();
                edges.add(edge);

                JsonPG jsonPG = new JsonPG(nodes, edges);
//                kafkaProducer.send(new ProducerRecord<>("eventtopic", jsonPG));
//                kafkaProducer.flush();
                try {
                    Writer writer = new FileWriter("/home/antonio/Scrivania/testDozer/"+initTimestamp.get()+".json");
                    Gson gson = new GsonBuilder().create();
                    gson.toJson(jsonPG, writer);
                    writer.flush(); //flush data to file   <---
                    writer.close(); //close write                } catch (IOException e) {
                } catch (IOException e) {
                    e.printStackTrace();
                }

                personID.set(personID.get()+1);
            }
        };
        t.schedule(tt, new Date(),100);

    }
}
