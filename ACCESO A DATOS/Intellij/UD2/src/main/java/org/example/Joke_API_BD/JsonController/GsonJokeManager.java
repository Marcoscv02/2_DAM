package org.example.Joke_API_BD.JsonController;

import com.google.gson.*;
import org.example.Joke_API_BD.Chiste;

import java.lang.reflect.Type;

public class GsonJokeManager {

    public static final String API_URL = "https://sv443.net/jokeapi/v2/joke/";

    private Gson gson;

    private static GsonJokeManager instance;

    private GsonJokeManager() {
        gson = new GsonBuilder()
                .registerTypeAdapter(Chiste.class, new JsonDeserializer<Chiste>() {
                    @Override
                    public Chiste deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
                        return null;
                    }
                })
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
