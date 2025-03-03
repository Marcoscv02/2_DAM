package marcos.mapeoJokes.gson;

import com.google.gson.*;
import marcos.mapeoJokes.entities.Chiste;

public class GsonJokeManager {

    public static final String API_URL = "https://sv443.net/jokeapi/v2/joke/";

    private Gson gson;

    private static GsonJokeManager instance;

    private GsonJokeManager() {
        gson = new GsonBuilder()
                .registerTypeAdapter(Chiste.class, new ChisteDeserializer())
                .setPrettyPrinting().create();
    }

    public static GsonJokeManager getInstance() {
        if (instance == null) {
            synchronized (GsonJokeManager.class) {
                if (instance == null) {
                    instance = new GsonJokeManager();
                }
            }
        }
        return instance;
    }

    public Gson getGson() {
        return gson;
    }



}
