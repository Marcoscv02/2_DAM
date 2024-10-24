package Java.Boletines.boletin0103.ex5;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PersonaTypeAdapter  implements JsonSerializer<Persona>, JsonDeserializer<Persona> {
    @Override
    public Persona deserialize(Persona persona, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsObject= new JsonObject();

        jsObject.add("name",persona.nombre);
        jsObject.add("age",persona.edad);

        return jsObject;
    }

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
