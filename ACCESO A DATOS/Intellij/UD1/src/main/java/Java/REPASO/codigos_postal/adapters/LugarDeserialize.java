package Java.REPASO.codigos_postal.adapters;

import Java.REPASO.codigos_postal.Lugar;
import com.google.gson.*;

import java.lang.reflect.Type;


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