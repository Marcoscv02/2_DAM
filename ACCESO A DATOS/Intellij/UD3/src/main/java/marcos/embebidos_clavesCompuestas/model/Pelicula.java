package marcos.embebidos_clavesCompuestas.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    @Embedded
    private InfoContenido informacion;
    @OneToMany(mappedBy = "pelicula")
    List<Calificacion>calificaciones;

    public Pelicula() {
    }

    public Pelicula(Long idPelicula, InfoContenido informacion, List<Calificacion> calificaciones) {
        this.idPelicula = idPelicula;
        this.informacion = informacion;
        this.calificaciones = calificaciones;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public InfoContenido getInformacion() {
        return informacion;
    }

    public void setInformacion(InfoContenido informacion) {
        this.informacion = informacion;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", informacion=" + informacion +
                '}';
    }
}
