package marcos.Peliculas.model.entities;

import jakarta.persistence.*;
import marcos.Peliculas.model.claves.peliculaActor.PeliculaActor;
import marcos.Peliculas.model.embebidos.Multimedia;

import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    @Embedded
    private Multimedia multimedia;
    @Column(length = 3)
    private Integer duracion;

    @OneToMany (mappedBy = "pelicula")
    private List<PeliculaActor> personaxes;

    public Pelicula() {
    }

    public Pelicula(Multimedia multimedia, Integer duracion) {
        this.multimedia = multimedia;
        this.duracion = duracion;
    }

    public Pelicula(Multimedia multimedia, Integer duracion, List<PeliculaActor> personaxes) {
        this.multimedia = multimedia;
        this.duracion = duracion;
        this.personaxes = personaxes;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public List<PeliculaActor> getPersonaxes() {
        return personaxes;
    }

    public void setPersonaxes(List<PeliculaActor> personaxes) {
        this.personaxes = personaxes;
    }

    @Override
    public String toString() {
        return "["+ idPelicula +"]"+multimedia+", duracion: " + duracion;
    }
}
