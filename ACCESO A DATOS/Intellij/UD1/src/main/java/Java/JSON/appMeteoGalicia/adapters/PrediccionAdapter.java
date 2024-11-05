package Java.JSON.appMeteoGalicia.adapters;

import Java.JSON.appMeteoGalicia.Concello;
import Java.JSON.appMeteoGalicia.Prediccion;
import com.google.gson.*;

import java.lang.reflect.Type;

public class PrediccionAdapter implements JsonDeserializer<Prediccion> {

    @Override
    public Prediccion deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsObject= element.getAsJsonObject();

        // Verificar si "predConcello" existe y no es nulo
        if (jsObject.has("predConcello") && !jsObject.get("predConcello").isJsonNull()) {
            JsonObject ob = jsObject.getAsJsonObject("predConcello");

                int idConcello = (ob.get("idConcello").isJsonNull())? -1 : ob.get("idConcello").getAsInt();
                String nome=ob.get("nome").getAsString();
                Concello concello= new Concello(nome,idConcello);
                System.out.println(concello);

        }
        return null; //Solo se puede devolver un objeto de tipo Prediccion
    }
}
