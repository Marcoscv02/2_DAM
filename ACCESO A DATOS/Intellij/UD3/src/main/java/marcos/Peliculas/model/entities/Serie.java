package marcos.Peliculas.model.entities;


import jakarta.persistence.*;
import marcos.Peliculas.model.claves.serieActor.SerieActor;
import marcos.Peliculas.model.embebidos.Multimedia;
import marcos.Peliculas.model.enums.Plataforma;
import marcos.Peliculas.model.enums.PlataformaConverter;

import java.util.List;

@Entity
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;
    @Embedded
    private Multimedia multimedia;
    @Convert(converter = PlataformaConverter.class)
    private Plataforma plataforma;
    @Column(name = "temporadas", length = 2)
    private Integer numTemporadas;

    @OneToMany(mappedBy = "serie")
    private List<SerieActor>actores;

    public Serie() {
    }

    public Serie(Multimedia multimedia, Plataforma plataforma, Integer numTemporadas) {
        this.multimedia = multimedia;
        this.plataforma = plataforma;
        this.numTemporadas = numTemporadas;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(Multimedia multimedia) {
        this.multimedia = multimedia;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(Integer numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public List<SerieActor> getActores() {
        return actores;
    }

    public void setActores(List<SerieActor> actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "[ "+ idSerie + " ]" + multimedia +"\n " +
                "plataforma: " + plataforma + ", numTemporadas: " + numTemporadas;
    }
}
