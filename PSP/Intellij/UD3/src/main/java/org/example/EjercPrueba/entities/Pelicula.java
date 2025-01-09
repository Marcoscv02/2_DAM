package org.example.EjercPrueba.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Pelicula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula",nullable = false,unique = true)
    private Long idPelicula;
    private String titulo;
    private short ano;

    private  transient LocalDate fechaEstreno;

    public Pelicula() {
    }

    public Pelicula(String titulo, short ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public Pelicula(Long idPelicula, String titulo, short ano) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.ano = ano;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "[idPelicula=" + idPelicula + "]\t titulo: " + titulo + '(' + "ano: " + ano +')';
    }
}
