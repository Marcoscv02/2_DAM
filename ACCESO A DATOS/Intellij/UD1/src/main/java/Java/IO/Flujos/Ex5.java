package Java.IO.Flujos;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in); // Scanner para leer la URL
        URL url = null;
        HttpURLConnection connection = null;

        System.out.println("Introduce URL");
        String strurl = sc.nextLine();

        // Verificar si la URL es vacía o nula
        if (strurl.equals("") || strurl == null) {
            System.out.println("URL incorrecta, inténtelo de nuevo");
            main(null); // Llamar al método main nuevamente para reiniciar el proceso
        } else {
            try {
                url = (new URI(strurl)).toURL(); // Convertir la URL ingresada en un objeto URL
                connection = (HttpURLConnection) url.openConnection(); // Abrir la conexión
                connection.setRequestMethod("HEAD"); // Usar el método HEAD para obtener solo los headers
                connection.connect(); // **Agregar connect() para iniciar la conexión**
            } catch (Exception e) {
                System.out.println("Error en el enlace");
                return; // Salir si hay un error en la URL o conexión
            }

            try {
                // Obtener el tipo de contenido desde los headers
                String mimeType = connection.getContentType().split(";")[0];
                String extensionArchivo = getExtensionFromMimeType(mimeType); // Obtener extensión del archivo basada en el tipo MIME

                // Pedir el directorio donde guardar el archivo
                var fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // Solo permitir seleccionar directorios
                File directorioOndeGardar;
                if (!(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)) {
                    System.out.println("Saliendo del programa...");
                    return; // Salir si el usuario no selecciona un directorio
                }
                directorioOndeGardar = fc.getSelectedFile();

                // Pedir el nombre del archivo
                String nomeArchivo = JOptionPane.showInputDialog("Introduce el nombre del archivo");
                if (nomeArchivo == null || nomeArchivo.equals("")) {
                    System.out.println("No se introdujo nombre del archivo, saliendo del programa...");
                    return; // Salir si no se proporciona un nombre de archivo
                }

                // Descargar el archivo
                try (
                        InputStream is = url.openStream(); // Abrir un stream para leer el archivo
                        FileOutputStream archivo = new FileOutputStream(directorioOndeGardar + "/" + nomeArchivo + (extensionArchivo != null ? "." + extensionArchivo : "")) // Crear archivo en el directorio seleccionado
                ) {
                    int valor;
                    while ((valor = is.read()) != -1) { // Leer el archivo byte por byte
                        archivo.write(valor); // Escribir cada byte en el archivo
                    }
                    System.out.println("Archivo descargado correctamente.");
                } catch (Exception e) {
                    System.out.println("Error al guardar el archivo...");
                }
            } catch (Exception e) {
                System.out.println("Error al procesar la URL o el archivo.");
            }
        }
    }

    // Método para obtener la extensión de archivo basada en el tipo MIME
    public static String getExtensionFromMimeType(String mimeType) {
        HashMap<String, String> extensions = new HashMap<>(Map.ofEntries(
                Map.entry("application/json", "json"),
                Map.entry("application/octet-stream", "zip"),
                Map.entry("application/pdf", "pdf"),
                Map.entry("application/vnd.ms-excel", "xls"),
                Map.entry("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "xlsx"),
                Map.entry("text/html", "html"),
                Map.entry("text/xml", "xml"),
                Map.entry("text/plain", "txt"),
                Map.entry("application/javascript", "js"),
                Map.entry("image/jpeg", "jpeg"),
                Map.entry("image/png", "png"),
                Map.entry("image/gif", "gif"),
                Map.entry("image/tiff", "tiff"),
                Map.entry("application/msword", "doc")
        ));
        return extensions.get(mimeType); // Retorna la extensión basada en el tipo MIME
    }
}



