package Java.JSON.appMeteoGalicia;

import Java.JSON.appMeteoGalicia.adapters.PrediccionAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class AppPrediccion {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce Id concello:");
        String id= String.valueOf(sc.nextInt());

        //Se abre la conexion con la url a traves de un bufferedReader
        try (var is= new BufferedReader(new InputStreamReader(new URI("https://servizos.meteogalicia.gal/mgrss/predicion/jsonPredConcellos.action?idConc="+id+"&request_locale=gl").toURL().openConnection().getInputStream()))){

            Gson gson= new GsonBuilder()
                    .registerTypeAdapter(Prediccion.class, new PrediccionAdapter())
                    .create();

            System.out.println(gson.fromJson(is,Prediccion.class));

        } catch (URISyntaxException | IOException e) {
            System.out.println("Error e la conexion intputStream");
            throw new RuntimeException(e);
        }
    }

}
