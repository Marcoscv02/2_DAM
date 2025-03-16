package marcos.Vehiculos.model.vehiculo;

import jakarta.persistence.*;
import marcos.Vehiculos.model.propietario.Propietario;

import java.util.Properties;

@Entity
@PrimaryKeyJoinColumn(name = "idCoche")
public abstract class Coche extends Vehiculo {
    @Column (length = 1)
    private Short puertas;
    @Column (length = 1)
    private Short plazas;

    @ManyToOne
    @JoinColumn(name = "idPropietario")
    private Propietario propietario;

    public Coche() {
    }

    public Coche(String marca, String modelo, Integer ano, Float precio, Short puertas, Short plazas) {
        super(marca, modelo, ano, precio);
        this.puertas = puertas;
        this.plazas = plazas;
    }

    public Coche(Short puertas, Short plazas) {
        this.puertas = puertas;
        this.plazas = plazas;
    }

    public Short getPuertas() {
        return puertas;
    }

    public void setPuertas(Short puertas) {
        this.puertas = puertas;
    }

    public Short getPlazas() {
        return plazas;
    }

    public void setPlazas(Short plazas) {
        this.plazas = plazas;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "puertas: " + puertas + ", plazas: " + plazas ;
    }
}
