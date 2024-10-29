package Java.Boletines.boletin0103.ex5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Direccion d= new Direccion("Calle Melancolia", "Madrid");
        List<Persona>amigos= new ArrayList<>();

        // Creacion de los amigos
        Persona persona1 = new Persona("Juan", 25, d, amigos);
        Persona persona2 = new Persona("Ana", 30, d, amigos);
        Persona persona3 = new Persona("Luis", 28, d, amigos);
        Persona persona4 = new Persona("Maria", 35, d, amigos);

        //Añadir los amigos al arrayList
        amigos.add(persona1);
        amigos.add(persona2);
        amigos.add(persona3);
        amigos.add(persona4);

        //Creacion persona principal
        Persona p= new Persona("Marcos", 22, d,amigos);



        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Persona.class, new PersonaTypeAdapter())
                .create();

        String json= gson.toJson(p);

        System.out.println(json);

        Persona personaRecuperada= gson.fromJson(json, Persona.class);
        System.out.println(personaRecuperada);
    }
}
