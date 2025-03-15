package marcos.Peliculas.model.entities;

import jakarta.persistence.*;
import marcos.Peliculas.model.claves.PeliculaActor;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActor;
    @Column (length = 100)
    private String nome;
    @Column (length = 10)
    private String sexo;
    @Temporal(TemporalType.DATE)
    private LocalDate dataNacemento;
    private String descripcion;
    private String filmografia;
    @Column (length = 50)
    private String paisNacemento;

    @OneToMany (mappedBy = "actor")
    private List<PeliculaActor> peliculasPersonaxe;

    public Actor(String nome, String sexo, LocalDate dataNacemento, String paisNacemento) {
    }

    public Actor(String nome, String sexo, LocalDate dataNacemento, String descripcion, String filmografia, String paisNacemento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.descripcion = descripcion;
        this.filmografia = filmografia;
        this.paisNacemento = paisNacemento;
    }

    public Actor(Long idActor, String nome, String sexo, LocalDate dataNacemento, String descripcion, String filmografia, String paisNacemento) {
        this.idActor = idActor;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.descripcion = descripcion;
        this.filmografia = filmografia;
        this.paisNacemento = paisNacemento;
    }

    public Actor(Long idActor, String nome, String sexo, LocalDate dataNacemento, String descripcion, String filmografia, String paisNacemento, List<PeliculaActor> peliculasPersonaxe) {
        this.idActor = idActor;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.descripcion = descripcion;
        this.filmografia = filmografia;
        this.paisNacemento = paisNacemento;
        this.peliculasPersonaxe = peliculasPersonaxe;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFilmografia() {
        return filmografia;
    }

    public void setFilmografia(String filmografia) {
        this.filmografia = filmografia;
    }

    public String getPaisNacemento() {
        return paisNacemento;
    }

    public void setPaisNacemento(String paisNacemento) {
        this.paisNacemento = paisNacemento;
    }

    public List<PeliculaActor> getPeliculasPersonaxe() {
        return peliculasPersonaxe;
    }

    public void setPeliculasPersonaxe(List<PeliculaActor> peliculasPersonaxe) {
        this.peliculasPersonaxe = peliculasPersonaxe;
    }

    @Override
    public String toString() {
        return "Actor: [" + idActor + "] ("+paisNacemento+dataNacemento+") nome: " + nome +", sexo: " + sexo + "filmografia:" + filmografia+ "\nDescripcion:" + descripcion;
    }
}
