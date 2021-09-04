package custom_serdes;

import engine.*;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

/**
 * Custom Serde for the {@link Neo4jObj}
 */
public class Neo4jObjSerde implements Serde<Neo4jObj> {

    private final JsonSerializer<Neo4jObj> serializer = new JsonSerializer<>();
    private final JsonDeserializer<Neo4jObj> deserializer = new JsonDeserializer<>(
            Neo4jObj.class);

    @Override
    public Serializer<Neo4jObj> serializer() {
        return serializer;
    }

    @Override
    public Deserializer<Neo4jObj> deserializer() {
        return deserializer;
    }
}
