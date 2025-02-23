package marcos.Peliculas.model.claves;

import jakarta.persistence.IdClass;

import java.io.Serializable;
import java.util.Objects;


//Clave compuesta realizada con idClass
public class clavePeliculaPesonaxe implements Serializable {
    private Long idpelicula;
    private Long idPersonaxe;
    private String papel;

    public clavePeliculaPesonaxe() {
    }

    public clavePeliculaPesonaxe(Long idpelicula, Long idPersonaxe, String papel) {
        this.idpelicula = idpelicula;
        this.idPersonaxe = idPersonaxe;
        this.papel = papel;
    }

    public Long getIdpelicula() {
        return idpelicula;
    }

    public void setIdpelicula(Long idpelicula) {
        this.idpelicula = idpelicula;
    }

    public Long getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        clavePeliculaPesonaxe that = (clavePeliculaPesonaxe) o;
        return Objects.equals(idpelicula, that.idpelicula) && Objects.equals(idPersonaxe, that.idPersonaxe) && Objects.equals(papel, that.papel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpelicula, idPersonaxe, papel);
    }
}
