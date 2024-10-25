package Java.Boletines.boletin0103.ex5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Direccion d= new Direccion("Calle Melancolia", "Madrid");
        Persona p= new Persona("Marcos", 22, d);

        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Persona.class, new PersonaTypeAdapter())
                .registerTypeAdapter(Direccion.class, new PersonaTypeAdapter())
                .create();

        String json= gson.toJson(p);

        System.out.println(json);

        Persona personaRecuperada= gson.fromJson(json, Persona.class);
        System.out.println(personaRecuperada.toString());
    }
}
