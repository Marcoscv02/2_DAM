package marcos.pelis_series.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClaveUsuarioPelicula implements Serializable {
    @Column(name = "idUsuario")
    private Long idUsuario;
    @Column(name = "idPelicula")
    private Long idPelicula;

    public ClaveUsuarioPelicula() {
    }

    public ClaveUsuarioPelicula(Long idUsuario, Long idpelicula) {
        this.idUsuario = idUsuario;
        this.idPelicula = idpelicula;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClaveUsuarioPelicula that)) return false;
        return Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idPelicula, that.idPelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idPelicula);
    }
}
