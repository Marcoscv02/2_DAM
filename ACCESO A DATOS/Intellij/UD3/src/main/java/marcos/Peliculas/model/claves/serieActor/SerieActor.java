package marcos.Peliculas.model.claves.serieActor;

import jakarta.persistence.*;
import marcos.Peliculas.model.entities.Actor;
import marcos.Peliculas.model.entities.Serie;

@Entity
public class SerieActor  {
    @EmbeddedId
    private ClaveSerieActor id;
    private String Papel;
    private String Importancia;

    @ManyToOne
    @MapsId("idSerie")
    @JoinColumn(name = "idSerie")
    private Serie serie;

    @ManyToOne
    @MapsId ("idActor")
    @JoinColumn (name = "idActor")
    private Actor actor;

    public SerieActor() {
    }

    public SerieActor(String papel, String importancia, Serie serie, Actor actor) {
        Papel = papel;
        Importancia = importancia;
        this.serie = serie;
        this.actor = actor;
    }

    public SerieActor(ClaveSerieActor id, String papel, String importancia, Serie serie, Actor actor) {
        this.id = id;
        Papel = papel;
        Importancia = importancia;
        this.serie = serie;
        this.actor = actor;
    }

    public ClaveSerieActor getId() {
        return id;
    }

    public void setId(ClaveSerieActor id) {
        this.id = id;
    }

    public String getPapel() {
        return Papel;
    }

    public void setPapel(String papel) {
        Papel = papel;
    }

    public String getImportancia() {
        return Importancia;
    }

    public void setImportancia(String importancia) {
        Importancia = importancia;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "SerieActor{" +
                "id=" + id +
                ", Papel='" + Papel + '\'' +
                ", Importancia='" + Importancia + '\'' +
                ", serie=" + serie +
                ", actor=" + actor +
                '}';
    }
}
