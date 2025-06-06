package Java.Boletines.boletin0103.ex5;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persona {
    private String nombre;
    private int edad;
    private Direccion direccion;
    private List<Persona>amigos= new ArrayList<>();
    private List<String>hobbies= new ArrayList<>();

    public Persona() {
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public Persona(String nombre, int edad, Direccion direccion, List<Persona> amigos) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.amigos = amigos;
    }

    public Persona(String nombre, int edad, Direccion direccion, List<Persona> amigos, List<String> hobbies) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.amigos = amigos;
        this.hobbies = hobbies;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCalle(){
        return direccion!=null ? direccion.getCalle():null;
    }

    public String getCidade(){
        return direccion!=null ? direccion.getCiudad() :null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Persona> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Persona> amigos) {
        this.amigos = amigos;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return  nombre + " (" + edad + ") "+ direccion + System.lineSeparator() +
                "amigos: " + amigos.stream().map(Persona::getNombre).collect(Collectors.joining(", "))+
                ", "+System.lineSeparator()+"hobbies=" + hobbies;
    }

}
