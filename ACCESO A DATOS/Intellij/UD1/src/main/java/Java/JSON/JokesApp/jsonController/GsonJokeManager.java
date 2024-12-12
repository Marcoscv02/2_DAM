package Java.JSON.JokesApp.jsonController;

import Java.JSON.JokesApp.model.Joke;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
