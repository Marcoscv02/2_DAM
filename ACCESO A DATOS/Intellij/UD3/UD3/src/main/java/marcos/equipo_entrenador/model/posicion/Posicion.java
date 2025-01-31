package marcos.equipo_entrenador.model.posicion;

import jakarta.persistence.*;

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

    @
}
