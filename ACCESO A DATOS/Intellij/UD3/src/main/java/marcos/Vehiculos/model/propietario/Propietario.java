package marcos.Vehiculos.model.propietario;

import jakarta.persistence.*;
import marcos.Vehiculos.model.vehiculo.Coche;
import marcos.Vehiculos.model.vehiculo.Moto;
import marcos.Vehiculos.model.vehiculo.Vehiculo;

import java.util.List;

@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPropietario;
    @Column(length = 100)
    private String nombre;
    @Column(length = 200)
    private String apellidos;

    @OneToMany(mappedBy = "propietario")
    private List<Vehiculo> vehiculos;
//    @OneToMany (mappedBy = "propietario")
//    private List<Coche> coches;
//
//    @OneToMany (mappedBy = "propietario")
//    private List<Moto> motos;

    @OneToOne (mappedBy = "propietario")
    private Direccion direccion;


    public Propietario() {
    }

    public Propietario(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Long getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(Long idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "(" + idPropietario +")"+ nombre + apellidos;
    }
}
