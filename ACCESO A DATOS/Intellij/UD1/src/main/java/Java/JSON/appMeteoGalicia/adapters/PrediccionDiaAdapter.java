package Java.JSON.appMeteoGalicia.adapters;

import Java.JSON.appMeteoGalicia.PrediccionDia;
import Java.JSON.appMeteoGalicia.VariableFranxa;
import Java.JSON.appMeteoGalicia.VariableMeteo;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class PrediccionDiaAdapter implements JsonDeserializer<PrediccionDia> {
    @Override
    public PrediccionDia deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        //Se coje el elemento como jsonObject
        JsonObject jsPrediccionDia= element.getAsJsonObject();

        PrediccionDia prediccionDia= new PrediccionDia();
        // Obtenemos la fecha de la predicción llamando al metodo deserialize de la clase JsonDeserializationContext
        prediccionDia.setDataPredicion(context.deserialize(jsPrediccionDia.get("dataPredicion"), LocalDate.class));
        prediccionDia.setTemperaturaMaxima(jsPrediccionDia.get("tMax").getAsInt());
        prediccionDia.setTemperaturaMinima(jsPrediccionDia.get("tMin").getAsInt());
        prediccionDia.setUvMaximo(jsPrediccionDia.get("uvMax").getAsInt());
        //Obtener nivel aviso(hai que gestionar que pueda ser null)
        if(jsPrediccionDia.has("nivelAviso")&&!jsPrediccionDia.get("nivelAviso").isJsonNull()){
            prediccionDia.setNivelAviso(jsPrediccionDia.get("nivelAviso").getAsInt());
        }

        for (VariableMeteo v : VariableMeteo.values()){
            if (jsPrediccionDia.has(v.getNome())){
                prediccionDia.addVariableFranxa(getVariableFranxa (v, jsPrediccionDia.get(v.getNome()).getAsJsonObject()));
            }
        }


        return prediccionDia;
    }

    private VariableFranxa getVariableFranxa(VariableMeteo v, JsonObject obj){

        return new VariableFranxa(v, obj.get("manha").getAsInt(),obj.get("tarde").getAsInt(),obj.get("noite").getAsInt());
    }
}
