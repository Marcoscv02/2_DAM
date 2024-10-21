package Java.Boletines.boletin0103.trivialGson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FilterWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTrivial {
    public static void main(String[] args) {
        TipoPregunta tipoPregunta= TipoPregunta.MULTIPLE_CHOICE;
        Dificultad dificultad=Dificultad.MEDIUM;
        Categoria categoria= new Categoria("Historia");
        String pregunta="En que año empezo la segunda guerra mundial";
        String correcta="1939";
        List<String>incorrectas= new ArrayList<>(Arrays.asList("1940, 1933, 1945"));

        Pregunta pregunta1= new Pregunta(pregunta, tipoPregunta, dificultad, categoria);
        pregunta1.setCorrecta(correcta);
        pregunta1.setIncorrecta(incorrectas);

        //Generar Gson e imprimirlo por pantalla
        Gson gson= new GsonBuilder().setPrettyPrinting().create();
        String json=gson.toJson(pregunta1);
        System.out.println(json);


        //Foma 1
        String filePath = "pregunta.json";//Ruta de archivo
        try {
            Files.writeString(Paths.get(filePath), json);
            System.out.println("pregunta guardada en archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Forma 2
        try(var bw= Files.newBufferedWriter(Paths.get("Pregunta2.json"))) {
            gson.toJson(pregunta1, bw);
            System.out.println("pregunta guardada en archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Leer de archivo
        //Forma 1
        try {
            String preguntaRecuperada=Files.readString(Paths.get(filePath));
            Pregunta preguntaread= gson.fromJson(preguntaRecuperada, Pregunta.class);
            System.out.println(preguntaread.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Forma 2
        try(var br= Files.newBufferedReader(Paths.get(filePath))) {
            Pregunta pread2=gson.fromJson(br, Pregunta.class);
            System.out.println(pread2.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
