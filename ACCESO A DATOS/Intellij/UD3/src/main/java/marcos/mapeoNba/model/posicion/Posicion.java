package marcos.mapeoNba.model.posicion;

import jakarta.persistence.*;
import marcos.mapeoNba.model.jugador.Jugador;

import java.util.List;

@Entity
public class Posicion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosicion;
    @Column(length = 50)
    private String nombre;
    @Column(length = 3)
    private String abreviatura;
    private String descripcion;

    @ManyToMany(mappedBy = "posiciones")
    List<Jugador> jugadores;

    public Posicion() {
    }

    public Posicion(String nombre, String abreviatura, String descripcion) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }
}
