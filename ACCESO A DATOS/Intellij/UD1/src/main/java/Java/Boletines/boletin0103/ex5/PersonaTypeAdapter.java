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
        //Serializar array de amigos
        List<Persona> amigos = persona.getAmigos();
        JsonArray a = new JsonArray();
        for (Persona p: amigos){
            a.add(contexto.serialize(p));
      //      System.out.println("p = " + p);
        }
        jsObject.add("friends", a);

        //Serializar Array de Hobbies
        List<String>hobbies= persona.getHobbies();
        JsonArray a2= new JsonArray();
        for (String hobbie:hobbies){
            a2.add(hobbie);
        }
        jsObject.add("hobbies",a2);

        //Devolver el jsonObject creado
        return jsObject;
    }

    @Override
    public Persona deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext Context) throws JsonParseException {
        JsonObject jsObject= jsonElement.getAsJsonObject();
        //Se recogen la edad y nombre
        Persona p= new Persona(jsObject.get("name").getAsString(), jsObject.get("age").getAsInt());

        //Se recoje del json la cadena y se divide en varias marcando como separador un parentesis
        String [] direccion= jsObject.get("address").getAsString(). split("\\(|\\)");
        p.setDireccion(new Direccion(direccion[0],direccion[1])); //Se le asigna a los elementos de la cadena los índices en el array

        //Se recojen los amigos del json y se meten en un array
        JsonArray amigosArray= jsObject.getAsJsonArray("friends");
        if (amigosArray != null) {
            List<Persona> amigos= new ArrayList<>();
            for (JsonElement amigoElement : amigosArray){
                Persona amigo= Context.deserialize(amigoElement,Persona.class);
                amigos.add(amigo);
            }
            p.setAmigos(amigos);
        }

        //Se recoje la direccion de json
        JsonArray hobbiesArray=jsObject.getAsJsonArray("hobbies");
        if (hobbiesArray!=null){
            List<String>hobbies=new ArrayList<>();
            for (JsonElement hobbieElement:hobbiesArray){
                String hobbie=hobbieElement.getAsString();
                hobbies.add(hobbie);
            }
            p.setHobbies(hobbies);
        }

        //Se retorna el objeto persona
        return p;
    }
}
