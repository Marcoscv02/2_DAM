package marcos.exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import marcos.exercise2.adapters.ArticleAdapter;
import marcos.exercise2.adapters.UserAdapter;

import java.io.*;
import java.net.*;
import java.sql.Connection;
import java.util.Scanner;


public class FetchBlogArticle {

    // URL base del API que proporciona publicaciones de blog de muestra
    private static final String APIURL = "https://api.slingacademy.com/v1/sample-data/blog-posts/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Article article;
        User user;

        // Solicita al usuario ingresar el ID del artículo de blog
        System.out.print("Ingrese el ID del artículo de blog: ");
        String articleId = scanner.nextLine();

        // Construye la URL completa al concatenar el ID del artículo a la URL base del API
        String fullUrl = APIURL + articleId;
        System.out.println(fullUrl);

        // Configurar Gson con el adaptador personalizado para Article
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Article.class, new ArticleAdapter())
                .registerTypeAdapter(User.class, new UserAdapter())
                .create();


        //recupera json del artículo
        try {
            URI uri = new URI(fullUrl);
            URLConnection conn = uri.toURL().openConnection();

            var br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder readerJson = new StringBuilder();

            String line;
            while ((line=br.readLine()) != null) {
                readerJson.append(line);
            }

            article = gson.fromJson(readerJson.toString(), Article.class);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        //recupera json del usuario
        try {
            String fullUrl2 = "https://api.slingacademy.com/v1/sample-data/users/" + article.getUserId();

            URI uri = new URI(fullUrl2);
            URLConnection conn = uri.toURL().openConnection();

            var br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder readerJson = new StringBuilder();

            String line;

            while ( (line= br.readLine())!= null) {
                readerJson.append(line);
            }

            user = gson.fromJson(br, User.class);

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(article.toString());
        System.out.println();
        System.out.println(user.toString());

    }
}
