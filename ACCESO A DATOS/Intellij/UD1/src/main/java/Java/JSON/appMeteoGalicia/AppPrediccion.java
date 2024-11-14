package Java.JSON.appMeteoGalicia;

import Java.JSON.appMeteoGalicia.adapters.PrediccionAdapter;
import Java.JSON.appMeteoGalicia.adapters.PrediccionDiaAdapter;
import Java.JSON.appMeteoGalicia.adapters.ProvinciasAdapter;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppPrediccion {

    public static void main(String[] args){
        Path concellos= Paths.get("src/main/java/Java/JSON/appMeteoGalicia/json/concellosprovincia.json");
        Type tipo = new TypeToken<List<Provincia>>(){}.getType();
        List<Provincia>provincias= new ArrayList<>();

        try (var is= new BufferedReader(new InputStreamReader(Files.newInputStream(concellos)))){
            Gson gson= new GsonBuilder()
                    .registerTypeAdapter(tipo, new ProvinciasAdapter())
                    .setPrettyPrinting()
                    .create();

            provincias=gson.fromJson(is,tipo);
            System.out.println(provincias.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce Id concello:");
        String id= String.valueOf(sc.nextInt());

        //Se abre la conexion con la url a traves de un bufferedReader
        try (var is= new BufferedReader(new InputStreamReader(new URI("https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc="+id+"&request_locale=gl").toURL().openConnection().getInputStream()))){

            Gson gson= new GsonBuilder()
                    //Registrar typeAdapter de Prediccion
                    .registerTypeAdapter(Prediccion.class, new PrediccionAdapter())
                    //Type adapter para registrar LocalDate de forma personalizada
                    .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (element, type, context) ->
                                    LocalDateTime.parse(element.getAsString()).toLocalDate())
                    //Registrar typeAdapter de Prediccion dia
                    .registerTypeAdapter(PrediccionDia.class,new PrediccionDiaAdapter())
                    .setPrettyPrinting()
                    .create();

            System.out.println(gson.fromJson(is,Prediccion.class));


        } catch (URISyntaxException | IOException e) {
            System.out.println("Error e la conexion intputStream");
            throw new RuntimeException(e);
        }
    }

}
