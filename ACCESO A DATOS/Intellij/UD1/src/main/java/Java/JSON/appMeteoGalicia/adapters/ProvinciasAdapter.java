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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProvinciasAdapter extends TypeAdapter<List<Provincia>> {

    @Override
    public void write(JsonWriter Writer, List<Provincia> provincias) throws IOException {
        //Aquí nada
    }

    @Override
    public List<Provincia> read(JsonReader r) throws IOException {
        List<Provincia>provincias= new ArrayList<>();

        r.beginObject();
        while (r.hasNext()){
            if (r.peek()==JsonToken.NAME){
                provincias.add(getProvincia(r));
            }
        }

        r.endObject();
        return provincias;
    }

    private Provincia getProvincia(JsonReader jr) throws IOException {
        String nombre= jr.nextName();   
        ArrayList<Concello>concellos = new ArrayList<>();

        if (jr.peek()==JsonToken.BEGIN_ARRAY){
            ConcellosaAdapter ca= new ConcellosaAdapter();
            jr.beginArray();

            while (jr.hasNext()){
                Concello c = ca.getConcello(jr);
                concellos.add(c);
            }
            jr.endArray();
        }

        Provincia p= new Provincia(nombre,concellos);


        return p;
    }


    public static void main(String[] args) {
        Type tipo=new TypeToken<List<Provincia>>(){}.getType();
        Gson g = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(tipo,new ProvinciasAdapter())
                .create();
        Path ficheiroJson=Path.of("src/main/java/Java/JSON/appMeteoGalicia/json/concellosprovincia.json");
        try(BufferedReader br=new BufferedReader(new FileReader(ficheiroJson.toFile()))){
            ArrayList<Provincia> provincias=g.fromJson(br,tipo);
            provincias.forEach(System.out::println);
        }catch (IOException e){
            System.out.println("Error de lectura de datos: "+e.getMessage());
        }
    }
}
