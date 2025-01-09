package org.example.EjercPrueba.entities;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    private String nombre, apellido, direccion;
    private LocalDate fechaNacimiento;

    public Estudiante() {
    }

    public Estudiante(String nombre, String apellido, LocalDate fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "[idEstudiante=:" + idEstudiante +"]\t nombre: " + nombre + "\t apellido: " + apellido + "\n" +
                "direccion:" + direccion + "\t fechaNacimiento:" + fechaNacimiento;
    }
}
