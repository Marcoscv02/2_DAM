package Java.JSON.appMeteoGalicia.adapters;

import Java.JSON.appMeteoGalicia.Concello;
import Java.JSON.appMeteoGalicia.Prediccion;
import Java.JSON.appMeteoGalicia.PrediccionDia;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrediccionAdapter implements JsonDeserializer<Prediccion> {

    @Override
    public Prediccion deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {

        //Se coje el elemento json al completo como un jsonObject
        JsonObject jsObject= element.getAsJsonObject();


        // Verificar si "predConcello" existe y no es nulo
        if (jsObject.has("predConcello") && !jsObject.get("predConcello").isJsonNull()) {
            JsonObject jsPrediccion = jsObject.getAsJsonObject("predConcello");
            //Obtiene idConcello si este es distinto de -1
            int idConcello = (jsPrediccion.get("idConcello").isJsonNull())? -1 : jsPrediccion.get("idConcello").getAsInt();
            //Obtiene el nombre del concelllo
            String nome=jsPrediccion.get("nome").getAsString();


            //Obtener la lista de prediccion diajson
            JsonArray prediccionesJson= jsPrediccion.getAsJsonArray("listaPredDiaConcello");

            //Si la lista de predicciones es distinta de null:
            if (prediccionesJson!=null){
                List<PrediccionDia>prediccionDiaList= new ArrayList<>();

                //Se hace un foreach sobre el jsonArray y se van añadiendo los elementos al arrayList Java
                for (JsonElement prediccionElement:prediccionesJson){
                    PrediccionDia pd =context.deserialize(prediccionElement, PrediccionDia.class);
                    prediccionDiaList.add(pd);
                }

                //Se crea un objeto Prediccion con los datos obtenidos
                Prediccion pr= new Prediccion(new Concello(nome,idConcello),prediccionDiaList);

                return pr;
            }

        }
        return null; //Solo se puede devolver un objeto de tipo Prediccion
    }
}
