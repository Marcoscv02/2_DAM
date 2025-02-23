package marcos.embebidos_clavesCompuestas.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Calificacion {
    @EmbeddedId
    private ClaveUsuarioPelicula id;
    private Integer calificacion;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaCalificacion;
    private String comentario;


    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idPelicula")
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;


    public Calificacion() {
    }

    public Calificacion(ClaveUsuarioPelicula id, Integer calificacion, LocalDate fechaCalificacion, String comentario, Usuario usuario, Pelicula pelicula) {
        this.id = id;
        this.calificacion = calificacion;
        this.fechaCalificacion = fechaCalificacion;
        this.comentario = comentario;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    public ClaveUsuarioPelicula getId() {
        return id;
    }

    public void setId(ClaveUsuarioPelicula id) {
        this.id = id;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getFechaCalificacion() {
        return fechaCalificacion;
    }

    public void setFechaCalificacion(LocalDate fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
