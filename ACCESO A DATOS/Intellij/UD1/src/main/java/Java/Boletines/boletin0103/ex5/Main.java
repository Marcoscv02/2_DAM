package Java.Boletines.boletin0103.ex5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Direccion d= new Direccion("Calle Melancolia", "Madrid");

        // Creacion de los amigos
        List<Persona>amigos= new ArrayList<>();
        Persona persona1 = new Persona("Juan", 25);
        Persona persona2 = new Persona("Ana", 30);
        Persona persona3 = new Persona("Luis", 28);
        Persona persona4 = new Persona("Maria", 35);
        //Añadir los amigos al arrayList
        amigos.add(persona1);
        amigos.add(persona2);
        amigos.add(persona3);
        amigos.add(persona4);

        //Creaciónde los hobbies
        List<String>hobbies= Arrays.asList("ciclismo","hípica", "lectura", "cocina","navegacion");


        //Creacion persona principal
        Persona p= new Persona("Marcos", 22, d, amigos, hobbies);



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
