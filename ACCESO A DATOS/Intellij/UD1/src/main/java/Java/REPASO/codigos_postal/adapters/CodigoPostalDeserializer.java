package Java.REPASO.codigos_postal.adapters;

import Java.REPASO.codigos_postal.CodigoPostal;
import Java.REPASO.codigos_postal.Lugar;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CodigoPostalDeserializer implements JsonDeserializer<CodigoPostal> {


    @Override
    public CodigoPostal deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        // Convertimos a obxecto JSON
        JsonObject jsObject =element.getAsJsonObject();

        //Deserializamos todos os elementos
        String posCode= jsObject.get("post code").getAsString();
        String pais= jsObject.get("country").getAsString();
        String abrPais= jsObject.get("country abbreviation").getAsString();

        //Extraemos lista de lugares
        JsonArray jsArrayPlaces= jsObject.getAsJsonArray("places");
        List<Lugar>lugares= new ArrayList<>();

        for (JsonElement placeElement:jsArrayPlaces){
            Lugar lugar= context.deserialize(placeElement, Lugar.class);
            lugares.add(lugar);
        }
        //Devolvemos objeto creado
        return new CodigoPostal(posCode,pais,abrPais, lugares);
    }
}
