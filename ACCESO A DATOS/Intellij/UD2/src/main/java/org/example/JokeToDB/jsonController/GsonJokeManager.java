package org.example.JokeToDB.jsonController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.JokeToDB.model.Joke;

public class GsonJokeManager {
    // Instancia única de la clase (Singleton)
    public static GsonJokeManager instance;

    // Objeto Gson configurado con el deserializador personalizado
    private final Gson gson;

    public static final String API_URL = "https://v2.jokeapi.dev/joke/Any?lang=es";

    private GsonJokeManager() {
        this.gson=new GsonBuilder()
                .registerTypeAdapter(Joke.class,new JokeTypeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public static GsonJokeManager getInstance(){
        if (instance==null){
            instance= new GsonJokeManager();
            return instance;
        }else System.out.println("Ya existe una instancia de esta clase");
        return null;
    }

    public Gson getGson(){
        return  gson;
    }
}
