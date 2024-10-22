package Java.Boletines.boletin0103.trivialSerializer;

import Java.Boletines.boletin0103.trivialGson.Categoria;
import com.google.gson.*;
import com.oracle.truffle.regex.tregex.util.json.Json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTrivial {
    public static void main(String[] args) {
        String enunciado= "¿Cuál de los siguientes lenguajes de programación es orientado a objetos puro?";
        TipoPregunta tp= TipoPregunta.MULTIPLE;
        Dificultad dif= Dificultad.EASY;
        String categoria= "Programacion";
        List<Opcion> opciones = List.of(new Opcion("Java",true),
                                        new Opcion("Modula-2", false),
                                        new Opcion("Python",false),
                                        new Opcion("C", false));

        PreguntaMultiple mc= new PreguntaMultiple(enunciado,tp,categoria,dif,opciones);

        Gson gsonBuilder= new GsonBuilder()
                                .registerTypeAdapter(Categoria.class, new JsonSerializer<Categoria>() {
                                    @Override
                                    public JsonElement serialize(Categoria categoria, Type type, JsonSerializationContext jsonSerializationContext) {
                                        return new JsonPrimitive(categoria.toString().toLowerCase());
                                    }
                                }).create();
        String strinJson= gsonBuilder.toString();

        System.out.println(strinJson);


    }
}
