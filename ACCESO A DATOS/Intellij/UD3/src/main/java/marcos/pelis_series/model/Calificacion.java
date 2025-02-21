package marcos.pelis_series.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Calificacion {
    @EmbeddedId
    private ClaveUsuarioPelicula id;
    private Integer calificacion;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaCalificacion;
    private String comentario;


    @ManyToOne
    @JoinColumn(name = "usuario_id_usuario")
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
