package Java.Boletines.boletin0103.ex5;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PersonaTypeAdapter  implements JsonSerializer<Persona>, JsonDeserializer<Persona> {

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsObject= new JsonObject();

        jsObject.add("name",persona.nombre);
        jsObject.add("age",persona.edad);

        return jsObject;    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
