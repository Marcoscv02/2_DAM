package Java.JSON.appMeteoGalicia;

import Java.JSON.appMeteoGalicia.adapters.PrediccionAdapter;
import Java.JSON.appMeteoGalicia.adapters.PrediccionDiaAdapter;
import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AppPrediccion {

    public static void main(String[] args){
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
