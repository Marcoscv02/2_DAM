package Java.Boletines.boletin0103.ex4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static java.lang.System.*;

public class GsonDemo{
    public static void main(String[] args) {
        Gson gson= new Gson();

        //Deserializar una cadena
        String name= gson.fromJson("\"Sylvia Plath\"", String.class);
        out.println(name);

        //Serializacion
        gson.toJson(256, out);//por pantalla
        out.println();//Salto de linea
        gson.toJson("<html>",out);//Por pantalla
        out.println();//Salto de Linea

        //GsonBuilder personalizado desabilitando el escapado de html
        gson=new GsonBuilder()
                .disableHtmlEscaping()
                .create();//Creacion GsonBuilder
        gson.toJson("<html>",out);//por pantalla
        out.println();//Salto de linea
    }
}
