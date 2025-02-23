package marcos.Peliculas.model.relaciones;

import jakarta.persistence.*;
import marcos.Peliculas.model.Pelicula;
import marcos.Peliculas.model.Personaxe;
import marcos.Peliculas.model.claves.clavePeliculaPesonaxe;

import java.util.List;

@IdClass(clavePeliculaPesonaxe.class)
public class PeliculaPersonaxe {
    //Se declaran las 3 claves
    @Id
    private Long idPelicula;
    @Id
    private Long idPersonaxa;
    @Id
    private Long papel;

    //se declara el atributo de la relacion
    private String personaxeInterpretado;


    //se declaran las dos variables que conforman la relacion con las otras entidades
    @ManyToOne
    @MapsId ("idPelicula")
    @JoinColumn(name = "idPelicula")
    private Pelicula pelicula;

    @ManyToOne
    @MapsId ("idPersonaxe")
    @JoinColumn (name = "idPersonaxe")
    private Personaxe personaxe;



    public PeliculaPersonaxe() {
    }

    public PeliculaPersonaxe(Long idPelicula, Long idPersonaxa, Long papel, String personaxeInterpretado) {
        this.idPelicula = idPelicula;
        this.idPersonaxa = idPersonaxa;
        this.papel = papel;
        this.personaxeInterpretado = personaxeInterpretado;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdPersonaxa() {
        return idPersonaxa;
    }

    public void setIdPersonaxa(Long idPersonaxa) {
        this.idPersonaxa = idPersonaxa;
    }

    public Long getPapel() {
        return papel;
    }

    public void setPapel(Long papel) {
        this.papel = papel;
    }

    public String getPersonaxeInterpretado() {
        return personaxeInterpretado;
    }

    public void setPersonaxeInterpretado(String personaxeInterpretado) {
        this.personaxeInterpretado = personaxeInterpretado;
    }
}
