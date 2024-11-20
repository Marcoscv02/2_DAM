package Java.JSON.codigos_postal.adapters;

import Java.JSON.codigos_postal.CodigoPostal;
import com.google.gson.*;
import jakarta.json.bind.serializer.DeserializationContext;
import jakarta.json.bind.serializer.JsonbDeserializer;
import jakarta.json.stream.JsonParser;

import java.lang.reflect.Type;

public class CodigoPostalDeserializer implements JsonDeserializer<CodigoPostal> {


    @Override
    public CodigoPostal deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsObject =element.getAsJsonObject();

        return null;
    }
}
