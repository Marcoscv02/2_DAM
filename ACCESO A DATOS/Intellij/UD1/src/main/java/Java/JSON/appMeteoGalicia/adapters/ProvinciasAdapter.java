package Java.JSON.appMeteoGalicia.adapters;

import Java.JSON.appMeteoGalicia.Provincia;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class ProvinciasAdapter extends TypeAdapter<Provincia> {
    @Override
    public void write(JsonWriter w, Provincia provincia) throws IOException {

    }

    @Override
    public Provincia read(JsonReader r) throws IOException {
        //Iniciar objeto
        r.beginObject();


        //Finalizar Objeto
        r.endObject();
        return null;
    }
}
