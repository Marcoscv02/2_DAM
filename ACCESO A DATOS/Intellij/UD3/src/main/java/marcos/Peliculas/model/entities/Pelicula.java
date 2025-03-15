package marcos.Peliculas.model.entities;

import jakarta.persistence.*;
import marcos.Peliculas.model.claves.PeliculaActor;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    @Column(length = 50)
    private String nome;
    @Column (length = 50)
    private String xenero;
    @Column (length = 125)
    private String pais;
    @Temporal(TemporalType.DATE)
    @Column(name = "lanzamiento")
    private LocalDate anoLanzamento;
    @Column(length = 3)
    private Integer duracion;

    @OneToMany (mappedBy = "pelicula")
    private List<PeliculaActor> personaxes;

    public Pelicula() {
    }

    public Pelicula(String nome, String xenero, String pais, LocalDate anoLanzamento, Integer duracion) {
        this.nome = nome;
        this.xenero = xenero;
        this.pais = pais;
        this.anoLanzamento = anoLanzamento;
        this.duracion = duracion;
    }

    public Pelicula(Long idPelicula, String nome, String xenero, String pais, LocalDate anoLanzamento, Integer duracion) {
        this.idPelicula = idPelicula;
        this.nome = nome;
        this.xenero = xenero;
        this.pais = pais;
        this.anoLanzamento = anoLanzamento;
        this.duracion = duracion;
    }

    public Pelicula(Long idPelicula, String nome, String xenero, String pais, LocalDate anoLanzamento, Integer duracion, List<PeliculaActor> personaxes) {
        this.idPelicula = idPelicula;
        this.nome = nome;
        this.xenero = xenero;
        this.pais = pais;
        this.anoLanzamento = anoLanzamento;
        this.duracion = duracion;
        this.personaxes = personaxes;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getAnoLanzamento() {
        return anoLanzamento;
    }

    public void setAnoLanzamento(LocalDate anoLanzamento) {
        this.anoLanzamento = anoLanzamento;
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
        return "["+ idPelicula +"] nome:" + nome + ", xenero: " + xenero +", pais=" + pais +", lanzamento: " + anoLanzamento +", duracion: " + duracion;
    }
}
