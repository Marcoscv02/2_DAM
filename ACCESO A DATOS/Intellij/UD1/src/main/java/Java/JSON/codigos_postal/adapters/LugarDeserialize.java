package Java.JSON.codigos_postal.adapters;

import Java.JSON.codigos_postal.Lugar;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LugarDeserialize implements JsonDeserializer<Lugar> {

    @Override
    public Lugar deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        //Se coje el elemento principal como jsonObject
        JsonObject jsLugar = element.getAsJsonObject();

        Lugar lugar = new Lugar();
        //Deserializamos el objeto Lugar
        lugar.setNome(jsLugar.get("place name").getAsString());
        lugar.setLongitud(jsLugar.get("longitude").getAsDouble());
        lugar.setEstado(jsLugar.get("state").getAsString());
        lugar.setAbreviaturaEstado(context.deserialize(jsLugar.get("state abbreviation"), String.class));
        lugar.setLatitud(jsLugar.get("latitude").getAsDouble());

        return lugar;
    }
}