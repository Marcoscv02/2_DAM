package marcos.mapeoVideoJuegos.model;

import jakarta.persistence.*;
import marcos.mapeoVideoJuegos.model.plataforma.PataformaConverter;
import marcos.mapeoVideoJuegos.model.plataforma.Plataforma;

import java.util.List;

@Entity
public class Juego {
    @Id
    private Long idJuego;

    @ManyToMany
    @JoinTable( name = "generoJuego",
                joinColumns = @JoinColumn(name = "idGenero"),
                inverseJoinColumns = @JoinColumn(name = "idJuego"))
    private List<Genero>generos;

    @OneToMany(mappedBy = "IdImagen")
    private List<Imagen>imagenes;

    @Convert(converter = PataformaConverter.class)
    private Plataforma plataforma;

    @OneToOne
    private RequisitosSistema requisitos;

    public Juego() {
    }

    public Juego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public Juego(Long idJuego, List<Genero> generos, List<Imagen> imagenes, Plataforma plataforma, RequisitosSistema requisitos) {
        this.idJuego = idJuego;
        this.generos = generos;
        this.imagenes = imagenes;
        this.plataforma = plataforma;
        this.requisitos = requisitos;
    }

    public Long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public RequisitosSistema getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(RequisitosSistema requisitos) {
        this.requisitos = requisitos;
    }
}
