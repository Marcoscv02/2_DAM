package Java.JSON.JuegosAPI.jsoController;

import Java.JSON.JuegosAPI.model.Game;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class AppTest {
    public static final String URL_API = "https://www.freetogame.com/api/games?";
    public static void main(String[] args) throws IOException, SQLException, URISyntaxException {
        //Conexion a URL
        var br= new BufferedReader(new InputStreamReader(new URI(URL_API).toURL().openStream()));

        // Configurar Gson con el TypeAdapter
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Game.class, new GameDeserialize())
                .create();

        // Deserializar el JSON a una lista de Game
        Game[] gamesArray = gson.fromJson(br,Game[].class);

        // Imprimir los resultados
        for (Game game : gamesArray) {
            System.out.println(game);
        }
    }
}
