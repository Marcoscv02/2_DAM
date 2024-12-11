package org.example.filosofos;

import java.time.LocalDate;

public class Filosofo {
    private Integer id;
    private String nombre, apellido;
    private int edad;
    private LocalDate fechaNac;
    private byte[] foto;

    public Filosofo() {
    }

    public Filosofo(Integer id, String nombre, String apellido, int edad, LocalDate fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNac = fechaNac;
    }

    public Filosofo(String nombre, String apellido, int edad, LocalDate fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNac = fechaNac;

    }

    public Filosofo(String nombre, String apellido, int edad, LocalDate fechaNac, byte[] foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNac = fechaNac;
        this.foto = foto;
    }

    public Filosofo(Integer id, String nombre, String apellido, int edad, LocalDate fechaNac, byte[] foto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNac = fechaNac;
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Filosofo: \n" +
                "nombre: " + nombre + "\t" +
                " apellido: " + apellido + "\t" +
                " edad: " + edad + "\t"+
                " fechaNac: " + fechaNac ;
    }
}
