package marcos.Vehiculos.model.propietario;

import jakarta.persistence.*;

import javax.sound.sampled.Port;

@Entity
public class Direccion {
    @Id
    private Long idPropietario;
    private String calle;
    private Integer numero;
    private String ciudad;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idPropietario")
    private Propietario propietario;
}
