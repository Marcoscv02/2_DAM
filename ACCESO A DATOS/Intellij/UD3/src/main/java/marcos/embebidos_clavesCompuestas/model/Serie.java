package marcos.embebidos_clavesCompuestas.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

 @Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;
    @Embedded
    private InfoContenido informacion;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaEdtreno;
    private Integer temporadas;
    private Integer capitulos;
    private List<String>directores;

    public Serie() {
    }

    public Serie(Long idSerie, InfoContenido informacion, LocalDate fechaEdtreno, Integer temporadas, Integer capitulos, List<String> directores) {
        this.idSerie = idSerie;
        this.informacion = informacion;
        this.fechaEdtreno = fechaEdtreno;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
        this.directores = directores;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public InfoContenido getInformacion() {
        return informacion;
    }

    public void setInformacion(InfoContenido informacion) {
        this.informacion = informacion;
    }

    public LocalDate getFechaEdtreno() {
        return fechaEdtreno;
    }

    public void setFechaEdtreno(LocalDate fechaEdtreno) {
        this.fechaEdtreno = fechaEdtreno;
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Integer getCapitulos() {
        return capitulos;
    }

    public void setCapitulos(Integer capitulos) {
        this.capitulos = capitulos;
    }

    public List<String> getDirectores() {
        return directores;
    }

    public void setDirectores(List<String> directores) {
        this.directores = directores;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "idSerie=" + idSerie +
                ", informacion=" + informacion +
                ", fechaEdtreno=" + fechaEdtreno +
                ", temporadas=" + temporadas +
                ", capitulos=" + capitulos +
                ", directores=" + directores +
                '}';
    }
}
