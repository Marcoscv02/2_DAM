package Java.Boletines.boletin0103.serializerLocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Crear un Examen
        List<String> participantes = Arrays.asList("Gabriela Mistral", "Alfonsina Storni", "Rosario Castellanos", "Gloria Fuertes", "Alejandra Pizarnik");

        LocalDateTime fechaExamen = LocalDateTime.of(2023,11,12,9,45,0);

        // Crear el objeto Examen
        Examen examen = new Examen("Acceso a Datos", fechaExamen, participantes);

        // Crear el objeto Gson con formato de fecha personalizado
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter())
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
