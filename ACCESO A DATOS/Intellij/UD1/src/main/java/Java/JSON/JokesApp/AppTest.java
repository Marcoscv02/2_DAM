package Java.JSON.JokesApp;

import Java.JSON.JokesApp.jsonController.GsonJokeManager;
import Java.JSON.JokesApp.model.Joke;
import com.google.gson.Gson;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import static Java.JSON.JokesApp.jsonController.GsonJokeManager.API_URL;

public class AppTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Gson gson= GsonJokeManager.getInstance().getGson();

        var br= new BufferedReader(new InputStreamReader(new URI(API_URL).toURL().openStream()));

        Joke joke= gson.fromJson(br,Joke.class);

        System.out.println(joke.toString());
    }
}
