package marcos.Peliculas.model.claves.serieActor;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClaveSerieActor implements Serializable {
    @Column(name = "idSerie")
    private Long idSerie;
    @Column(name = "idActor")
    private Long idActor;

    public ClaveSerieActor() {
    }

    public ClaveSerieActor(Long idSerie, Long idActor) {
        this.idSerie = idSerie;
        this.idActor = idActor;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClaveSerieActor that = (ClaveSerieActor) o;
        return Objects.equals(idSerie, that.idSerie) && Objects.equals(idActor, that.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSerie, idActor);
    }
}
