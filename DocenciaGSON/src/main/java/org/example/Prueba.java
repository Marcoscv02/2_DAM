package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Prueba {
    private String nombre;
    private int edad;
    private LocalDate fecha;

    public Prueba(String nombre, int edad, LocalDate fecha) {
        this.nombre = nombre;
        this.edad = edad;
        this.fecha = fecha;
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Prueba{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", fecha=" + fecha +
                '}';
    }
}
