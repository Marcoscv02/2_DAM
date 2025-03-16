package marcos.Peliculas.model.claves.peliculaActor;

import jakarta.persistence.*;
import marcos.Peliculas.model.entities.Actor;
import marcos.Peliculas.model.entities.Pelicula;

@Entity
public class PeliculaActor {
    @EmbeddedId
    private ClavePeliculaActor idRelacion;

    private String papel;
    private String importancia;

    @ManyToOne
    @MapsId("idPelicula")
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId("idActor")
    @JoinColumn ( name = "idActor")
    private Actor actor;

    public PeliculaActor() {
    }

    public PeliculaActor(ClavePeliculaActor idRelacion, String papel, String importancia, Pelicula pelicula, Actor actor) {
        this.idRelacion = idRelacion;
        this.papel = papel;
        this.importancia = importancia;
        this.pelicula = pelicula;
        this.actor = actor;
    }

    public ClavePeliculaActor getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(ClavePeliculaActor idRelacion) {
        this.idRelacion = idRelacion;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
