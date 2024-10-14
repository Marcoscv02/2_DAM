package Java.JSON.ExamentoJson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class main {
    public static void main(String[] args) {
        // Crear un Examen
        List<String> participantes = Arrays.asList("Gabriela Mistral", "Alfonsina Storni", "Rosario Castellanos", "Gloria Fuertes", "Alejandra Pizarnik");

        // Crear una fecha (12 de noviembre de 2023, 9:45 horas)
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.NOVEMBER, 12, 9, 45);
        Date fechaExamen = calendar.getTime();

        // Crear el objeto Examen
        Examen examen = new Examen("Acceso a Datos", fechaExamen, participantes);

        // Crear el objeto Gson con formato de fecha personalizado
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd HH:mm")
                .create();

        // Serializar el objeto Examen a JSON
        String jsonExamen = gson.toJson(examen);

        // Guardar el JSON en un archivo
        String filePath = "accesoADatos.json";
        try {
            Files.writeString(Paths.get(filePath), jsonExamen);
            System.out.println("Examen guardado en archivo JSON.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar el contenido del archivo JSON por consola
        try {
            String contenidoArchivo = Files.readString(Paths.get(filePath));
            System.out.println("Contenido del archivo JSON:");
            System.out.println(contenidoArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserializar el JSON para crear un nuevo objeto Examen
        try {
            String jsonRecuperado = Files.readString(Paths.get(filePath));
            Examen examenRecuperado = gson.fromJson(jsonRecuperado, Examen.class);
            System.out.println("Examen recuperado del archivo:");
            System.out.println(examenRecuperado);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
