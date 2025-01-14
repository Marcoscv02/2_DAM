package marcos.exercise2;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

/**
 * Esta clase representa una aplicación en Java que demuestra cómo realizar una solicitud HTTP GET para obtener un artículo de blog
 * y guardar su contenido como un archivo HTML.
 */
public class FetchBlogArticle {

    // URL base del API que proporciona publicaciones de blog de muestra
    private static final String APIURL = "https://www.slingacademy.com/article/sample-blog-posts-public-rest-api-for-practice/";

    /**
     * Método principal que solicita al usuario que ingrese el ID del artículo de blog,
     * realiza una solicitud HTTP GET para obtener el contenido del blog y lo guarda como un archivo HTML.
     *
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicita al usuario ingresar el ID del artículo de blog
        System.out.print("Ingrese el ID del artículo de blog: ");
        String articleId = scanner.nextLine();

        // Construye la URL completa al concatenar el ID del artículo a la URL base del API
        String fullUrl = APIURL + "?id=" + articleId;

        try {
            // Crear un objeto URI desde la URL y abrir una conexión HTTP
            URI uri = new URI(fullUrl);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Establecer el método de solicitud a GET
            connection.setRequestMethod("GET");

            // Verificar el código de respuesta para asegurarse de que la solicitud fue exitosa
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Leer la respuesta línea por línea y agregarla al StringBuilder
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Crear un archivo HTML desde la respuesta JSON obtenida
                createHtmlFile(response.toString());
            } else {
                System.out.println("No se pudo obtener el artículo del blog. Código de respuesta HTTP: " + responseCode);
            }
        } catch (Exception e) {
            // Manejar excepciones y mostrar un mensaje de error
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    /**
     * Crea un archivo HTML a partir de la respuesta JSON dada.
     *
     * @param jsonResponse La respuesta JSON obtenida del API del blog
     */
    private static void createHtmlFile(String jsonResponse) {
        try {
            // Básica parsificación (para propósitos demostrativos, supone una estructura específica de JSON)
            String title = extractValue(jsonResponse, "title");
            String content = extractValue(jsonResponse, "content");

            // Crear el contenido HTML utilizando los valores extraídos
            String htmlContent =
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body>\n" +
                    "<h1>" + title + "</h1>\n" +
                    "<p>" + content + "</p>\n" +
                    "</body>\n" +
                    "</html>";

            // Escribir el contenido HTML en un archivo llamado "article.html"
            FileWriter writer = new FileWriter("article.html");
            writer.write(htmlContent);
            writer.close();

            System.out.println("Archivo HTML 'article.html' creado exitosamente.");
        } catch (IOException e) {
            // Manejar excepciones durante la creación del archivo
            System.out.println("Ocurrió un error al crear el archivo HTML: " + e.getMessage());
        }
    }

    /**
     * Extrae el valor de una clave específica de un string JSON.
     *
     * Nota: Esta es una implementación simple que supone que la estructura JSON sigue un patrón predecible.
     * Para una solución robusta, considere utilizar una biblioteca de parsificación JSON como Jackson o Gson.
     *
     * @param json La cadena JSON
     * @param key La clave cuyo valor se necesita extraer
     * @return El valor asociado con la clave especificada
     */
    private static String extractValue(String json, String key) {
        // Extracción simple del valor del JSON (no robusta; reemplácela con una biblioteca JSON para producción)
        String keyPattern = "\"" + key + "\":\"";
        int startIndex = json.indexOf(keyPattern) + keyPattern.length();
        int endIndex = json.indexOf("\"", startIndex);
        return json.substring(startIndex, endIndex);
    }
}
