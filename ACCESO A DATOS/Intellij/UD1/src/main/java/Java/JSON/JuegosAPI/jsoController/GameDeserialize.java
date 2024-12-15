package Java.JSON.JuegosAPI.jsoController;

import Java.JSON.JuegosAPI.model.Game;
import Java.JSON.JuegosAPI.model.Platform;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class GameDeserialize implements JsonDeserializer<Game> {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public Game deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {

        Game game= new Game();
        JsonObject gameObject=element.getAsJsonObject();

        game.setId(gameObject.get("id").getAsInt());
        game.setTitulo(gameObject.get("title").getAsString());
        game.setDescripcion(gameObject.get("short_description").getAsString());
        game.setUrl(gameObject.get("game_url").getAsString());
        game.setGenero(gameObject.get("genre").getAsString());
        game.setPlataforma(Platform.getPlatorm(gameObject.get("platform").getAsString()));
        game.setFechaRealizacion(context.deserialize(gameObject.get("release_date"),LocalDate.class));

        return game;
    }
}
