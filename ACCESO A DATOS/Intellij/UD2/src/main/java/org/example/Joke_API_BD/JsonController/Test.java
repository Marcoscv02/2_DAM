package org.example.Joke_API_BD.JsonController;

import com.google.gson.Gson;
import org.example.Joke_API_BD.Chiste;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.example.Joke_API_BD.JsonController.GsonJokeManager.API_URL;

public class Test {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Gson gson= GsonJokeManager.getInstance().getGson();

        BufferedReader br= new BufferedReader(new InputStreamReader(new URI(API_URL).toURL().openStream()));

        Chiste chiste= gson.fromJson(br,Chiste.class);

        System.out.println(chiste.toString());
    }
}
