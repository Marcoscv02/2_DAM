package Java.JSON.codigos_postal;

import Java.JSON.codigos_postal.adapters.CodPostalTypeAdapter;
import Java.JSON.codigos_postal.adapters.CodigoPostalDeserializer;
import Java.JSON.codigos_postal.adapters.LugarDeserialize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CodigosApp {
    public static void main(String[] args) {

        Path ruta= Paths.get("src/main/java/Java/JSON/codigos_postal/JSON/formato.json");

        try (var br= new BufferedReader(new InputStreamReader(Files.newInputStream(ruta)));) {

        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(CodigoPostal.class, new CodPostalTypeAdapter())
                .create();

        System.out.println(gson.fromJson(br, CodigoPostal.class));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
