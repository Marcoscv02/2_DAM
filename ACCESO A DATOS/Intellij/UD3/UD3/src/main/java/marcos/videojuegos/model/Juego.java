package marcos.videojuegos.model;

import jakarta.persistence.*;
import marcos.videojuegos.model.plataforma.PataformaConverter;
import marcos.videojuegos.model.plataforma.Plataforma;

import java.util.List;

@Entity
public class Juego {
    @Id
    private Long idJuego;

    @ManyToMany
    @JoinTable( name = "generoJuego",
                joinColumns = @JoinColumn(name = "idGenero"),
                inverseJoinColumns = @JoinColumn(name = "idGenero"))
    private List<Genero>generos;

    @OneToMany(mappedBy = "IdImagen")
    private List<Imagen>imagenes;

    @Convert(converter = PataformaConverter.class)
    private Plataforma plataforma;

    private RequisitosSistema requisitos;
}
