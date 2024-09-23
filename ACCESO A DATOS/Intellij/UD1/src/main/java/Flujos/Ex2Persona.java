package Flujos;

import java.io.Serializable;

public class Ex2Persona implements Serializable {
    private String nombre;
    private int edad;

    public Ex2Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno:" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad;
    }
}
