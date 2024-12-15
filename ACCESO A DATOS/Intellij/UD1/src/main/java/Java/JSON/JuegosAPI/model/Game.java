package Java.JSON.JuegosAPI.model;

import java.time.LocalDate;
import java.util.List;

public class Game {
    private int id;
    private String titulo;
    private Image miniatura;
    private String descripcion;
    private String url;
    private String genero;
    private Platform plataforma;
    private LocalDate fechaRealizacion;
    private List<Image>imagenes;

    //Constructor vacio
    public Game() {
    }
    //Constructor sin imagenes
    public Game(int id, String titulo, String descripcion, String url, String genero, Platform plataforma, LocalDate fechaRealizacion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.genero = genero;
        this.plataforma = plataforma;
        this.fechaRealizacion = fechaRealizacion;
    }
    //Constructor completo
    public Game(int id, String titulo, Image miniatura, String descripcion, String url, String genero, Platform plataforma, LocalDate fechaRealizacion, List<Image> imagenes) {
        this.id = id;
        this.titulo = titulo;
        this.miniatura = miniatura;
        this.descripcion = descripcion;
        this.url = url;
        this.genero = genero;
        this.plataforma = plataforma;
        this.fechaRealizacion = fechaRealizacion;
        this.imagenes = imagenes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Image getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(Image miniatura) {
        this.miniatura = miniatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Platform getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Platform plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public List<Image> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Image> imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "Game:\n" +
                "id:" + id +"\n"+
                "título: " + titulo + '\n' +
                "descripción: " + descripcion + '\n' +
                "url: " + url + '\n' +
                "género: " + genero + '\n' +
                "fecha Realización:" + fechaRealizacion;
    }
}
