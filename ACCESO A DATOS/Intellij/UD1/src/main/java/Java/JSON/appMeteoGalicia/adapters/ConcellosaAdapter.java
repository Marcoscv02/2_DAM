package Java.JSON.appMeteoGalicia.adapters;

import Java.JSON.appMeteoGalicia.Concello;
import Java.JSON.appMeteoGalicia.Provincia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.Proxy;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConcellosaAdapter extends TypeAdapter<List<Concello>> {
    @Override
    public void write(JsonWriter w, List<Concello> concellos) throws IOException {

    }

    @Override
    public List<Concello> read(JsonReader r) throws IOException {
        List <Concello> concellos = new ArrayList<>();
        if (r.peek() == JsonToken.BEGIN_ARRAY){

            r.beginArray();
            while (r.hasNext())
                concellos.add(getConcello(r) );
            r.endArray();

        }
        return concellos;
    }

    private Concello getConcello(JsonReader r) throws IOException{
        String nombre = null;
        Integer id = null;

        r.beginObject();
        while (r.hasNext()){

            switch (r.nextName()){
                case "nombre":
                    nombre=r.nextString();
                    break;
                case "id":
                    id=r.nextInt();
                    break;
                default:
                    r.skipValue();
                    break;
            }
        }
        r.endObject();

        Concello c = new Concello(nombre, id);

        return (c!=null)? c: null;
    }

    public static void main(String[] args) throws IOException {
        Type tipo = new  TypeToken<List <Concello>>(){}.getType();
        Gson g= new GsonBuilder()
                .registerTypeAdapter(tipo,new ConcellosaAdapter())
                .create();

        List<Concello>concellos= g.fromJson(Files.newBufferedReader(Paths.get("Concellos.json")), tipo);
        concellos.forEach(System.out::println);
    }
}