package Java.Boletines.boletin0103.ex5;

import com.google.gson.*;

import java.lang.reflect.Type;

public class Persona {
    String nombre;
    int edad;
    Direccion direccion;

    public Persona() {
    }

    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion= direccion;
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
        return direccion!=null ? getCalle():null;
    }

    public String getCidade(){
        return direccion!=null ? getCidade():null;
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

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
