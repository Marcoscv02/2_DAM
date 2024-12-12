package Java.REPASO.codigos_postal.adapters;

import Java.REPASO.codigos_postal.CodigoPostal;
import Java.REPASO.codigos_postal.Lugar;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodPostalTypeAdapter extends TypeAdapter<CodigoPostal> {
    @Override
    public void write(JsonWriter writer, CodigoPostal codPostal) throws IOException {
       writer.beginObject();
       writer.name("post code").value(codPostal.getCodigoPostal());
       writer.name("country").value(codPostal.getPais());
       writer.name("country abbreviation").value(codPostal.getAbreviaturaPais());

       writer.name("places");
       writer.beginArray();

       for (Lugar lugar:codPostal.getLugares()){
           writer.name("place name").value(lugar.getNome());
           writer.name("longitude").value(lugar.getLongitud());
           writer.name("state").value(lugar.getEstado());
           writer.name("state abbreviation").value(lugar.getAbreviaturaEstado());
           writer.name("latitude").value(lugar.getLatitud());
       }
       writer.endArray();
       writer.endObject();
    }

    @Override
    public CodigoPostal read(JsonReader reader) throws IOException {
        String codPostal=null;
        String pais=null;
        String abrPais= null;
        List<Lugar> lugares =new ArrayList<>();

        reader.beginObject();

        while (reader.hasNext()){
            String name= reader. nextName();
            switch (name){
                case "post code" -> codPostal= reader.nextString();
                case "country" -> pais=reader.nextString();
                case "country abbreviation" -> abrPais= reader.nextString();
                case "places" ->{
                    reader.beginArray();
                    while (reader.hasNext()){
                        lugares.add(readLugar(reader));
                    }
                    reader.endArray();
                }
                default -> reader.skipValue();
            }
        }
        reader.endObject();

        return new CodigoPostal(codPostal,pais,abrPais,lugares);
    }

    //Metodo para deserializar cada lugar
    public Lugar readLugar(JsonReader reader) throws IOException {
        //Variables de lugar
        String nombre= null;
        double longitud= 0;
        double latitud= 0;
        String estado=null;
        String abrEstado=null;

        //Se empieza a leer el objeto
        reader.beginObject();

        while (reader.hasNext()){
             String name= reader.nextName();
             switch (name){
                 case "place name" -> nombre= reader.nextString();
                 case "longitude" -> longitud= Double.parseDouble(reader.nextString());
                 case "state" ->estado= reader.nextString();
                 case "state abbreviation" -> abrEstado= reader.nextString();
                 case "latitude" -> latitud= Double.parseDouble(reader.nextString());
                 default -> reader.skipValue();

             }
        }
        reader.endObject();

        return new Lugar(nombre,longitud,latitud,estado,abrEstado);
    }
}
