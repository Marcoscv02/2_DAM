package Java.Boletines.boletin0103.ex5;

import com.google.gson.*;
import com.oracle.truffle.regex.tregex.util.json.Json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonaTypeAdapter  implements JsonSerializer<Persona>, JsonDeserializer<Persona> {

    @Override
    public JsonElement serialize(Persona persona, Type type, JsonSerializationContext contexto) {
        JsonObject jsObject= new JsonObject();
        jsObject.addProperty("name",persona.getNombre());
        jsObject.addProperty("age",persona.getEdad());
        jsObject.addProperty ("address",persona.getCalle()+" ("+persona.getCidade()+")");

        List<Persona> amigos = persona.getAmigos();

        JsonArray a = new JsonArray();

        for (Persona p: amigos){
            a.add(contexto.serialize(p));
      //      System.out.println("p = " + p);
        }

        jsObject.add("friends", a);


        return jsObject;
    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsObject= jsonElement.getAsJsonObject();
        Persona p= new Persona(jsObject.get("name").getAsString(), jsObject.get("age").getAsInt());
        //Se recoje del json la cadena y se divide en varias marcando como separador un parentesis
        String [] direccion= jsObject.get("address").getAsString(). split("\\(|\\)");
        //Se le asigna a los elementos de la cadena los índices en el array
        p.setDireccion(new Direccion(direccion[0],direccion[1]));
        //Se recojen los amigos del json y se meten en un array
        JsonArray amigosArray= jsObject.getAsJsonArray("friends");
        if (amigosArray != null) {
            List<Persona> amigos= new ArrayList<>();
            for (JsonElement amigoElement : amigosArray){
                Persona amigo= jsonDeserializationContext.deserialize(amigoElement,Persona.class);
                amigos.add(amigo);
            }
            p.setAmigos(amigos);
        }
        return p;
    }
}
