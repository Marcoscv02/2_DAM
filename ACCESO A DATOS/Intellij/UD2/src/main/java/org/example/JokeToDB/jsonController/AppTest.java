package org.example.JokeToDB.jsonController;

import com.google.gson.Gson;
import org.example.JokeToDB.model.Joke;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

import static org.example.JokeToDB.jsonController.GsonJokeManager.API_URL;

public class AppTest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Gson gson= GsonJokeManager.getInstance().getGson();

        var br= new BufferedReader(new InputStreamReader(new URI(API_URL).toURL().openStream()));

        Joke joke= gson.fromJson(br,Joke.class);

        System.out.println(joke.toString());
    }
}
