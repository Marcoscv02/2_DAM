package marcos.exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import marcos.exercise2.adapters.ArticleAdapter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Esta clase representa una aplicación en Java que demuestra cómo realizar una solicitud HTTP GET para obtener un artículo de blog
 * y guardar su contenido como un archivo HTML.
 */
public class FetchBlogArticle {

    // URL base del API que proporciona publicaciones de blog de muestra
    private static final String APIURL = "https://api.slingacademy.com/v1/sample-data/blog-posts/";

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
        String fullUrl = APIURL + articleId;

        // Configurar Gson con el adaptador personalizado para Article
        GsonBuilder gsonBuilder = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Article.class, new ArticleAdapter());
        Gson gson = gsonBuilder.create();

        try {
            // Realiza la solicitud HTTP GET
            URL url = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Verifica el código de respuesta
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Lee la respuesta
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                // Convierte el JSON de la respuesta al objeto Article
                String jsonResponse = response.toString();
                Article article = gson.fromJson(jsonResponse, Article.class);

                // Muestra los detalles del artículo
                System.out.println("Artículo obtenido:");
                System.out.println(article);

                // Guardar el contenido como un archivo HTML
                saveAsHtml(article);
            } else {
                System.out.println("Error: No se pudo obtener el artículo. Código de respuesta: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Guarda el contenido del artículo como un archivo HTML.
     *
     * @param article Objeto Article que contiene los datos del blog.
     */
    private static void saveAsHtml(Article article) {
        String htmlFileName = "article-" + article.getId() + ".html";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFileName))) {
            writer.write("<html><head><title>" + article.getTittle() + "</title></head><body>");
            writer.write("<h1>" + article.getTittle() + "</h1>");
            writer.write("<p>" + article.getContentText() + "</p>");
            writer.write("</body></html>");
            System.out.println("El artículo se ha guardado como " + htmlFileName);
        } catch (Exception e) {
            System.out.println("Error al guardar el archivo HTML: " + e.getMessage());
        }
    }
}
