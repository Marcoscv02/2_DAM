package Flujos;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;

public class Ex5 {

    public static void main(String[] args) {
        // Solicitar la URL al usuario en formato string
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduce la URL: ");
        String urlString;

        try {
            //Lee la URL y la convierte a formato URL
            urlString = reader.readLine();
            URL url = new URL(urlString);
            //Crea la conexion con el método get
            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");
            conexion.connect();

            // Mostrar cabeceras HTTP
            System.out.println("\nCabeceras HTTP:");
            mostrarCabeceras(conexion);

            // Obtener el tamaño del contenido
            int contenidoLength = conexion.getContentLength();
            System.out.println("Tamaño del contenido (bytes): " + contenidoLength);

            // Obtener el tipo de contenido para usar la extensión adecuada
            String contentType = conexion.getContentType();
            System.out.println("Tipo de contenido: " + contentType);
            String extensionArchivo = obtenerExtensionPorTipo(contentType);

            // Leer el contenido de la URL y guardarlo en un archivo
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File carpeta = fileChooser.getSelectedFile();
                File archivo = new File(carpeta, "contenido_url" + extensionArchivo);

                try (BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        writer.write(inputLine);
                        writer.newLine();
                    }

                    System.out.println("El contenido se ha guardado en: " + archivo.getAbsolutePath());
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer la URL o guardar el archivo.");
            e.printStackTrace();
        }
    }

    // Método para mostrar las cabeceras HTTP
    private static void mostrarCabeceras(HttpURLConnection conexion) {
        Map<String, List<String>> cabeceras = conexion.getHeaderFields();
        for (Map.Entry<String, List<String>> entrada : cabeceras.entrySet()) {
            String clave = entrada.getKey();
            List<String> valores = entrada.getValue();
            if (clave != null) {
                System.out.println(clave + ": " + String.join(", ", valores));
            } else {
                System.out.println(String.join(", ", valores)); // Para la línea de estado HTTP
            }
        }
    }

    // Método para obtener la extensión del archivo según el tipo de contenido
    private static String obtenerExtensionPorTipo(String contentType) {
        if (contentType == null) return ".txt"; // Por defecto, txt si no se puede determinar
        switch (contentType) {
            case "text/html":
                return ".html";
            case "text/plain":
                return ".txt";
            case "application/json":
                return ".json";
            case "application/xml":
                return ".xml";
            case "image/jpeg":
                return ".jpg";
            case "image/png":
                return ".png";
            case "application/pdf":
                return ".pdf";
            default:
                return ".txt"; // Por defecto
        }
    }
}