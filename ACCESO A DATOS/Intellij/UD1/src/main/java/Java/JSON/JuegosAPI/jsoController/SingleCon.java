package Java.JSON.JuegosAPI.jsoController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class SingleCon {
    public static SingleCon instance;

    public static final String URL_API = "https://www.freetogame.com/api/games?";

    Gson gson;

    public SingleCon() {

    }

    public static SingleCon getInstance() {
        if (instance==null){
            instance = new SingleCon();
            return instance;
        }else {
            System.out.println("Ya existe una instancia de esta clase");
            return null;
        }

    }
}
