package Java.Boletines.boletin0103.ex5;

import com.google.gson.*;
import com.oracle.truffle.regex.tregex.util.json.Json;

import java.lang.reflect.Type;

public class PersonaTypeAdapter  implements JsonSerializer<Persona>, JsonDeserializer<Persona> {

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsObject= new JsonObject();
        jsObject.addProperty("name",persona.getNombre());
        jsObject.addProperty("age",persona.getEdad());
        jsObject.addProperty ("address",persona.getCalle()+" ("+persona.getCidade()+")");
        return jsObject;
    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsObject= jsonElement.getAsJsonObject();
        Persona p= new Persona(jsObject.get("name").getAsString(), jsObject.get("age").getAsInt());
        String [] direccion= jsObject.get("address").getAsString(). split("\\(|\\)");
        p.setDireccion(new Direccion(direccion[0],direccion[1]));
        return p;
    }
}
