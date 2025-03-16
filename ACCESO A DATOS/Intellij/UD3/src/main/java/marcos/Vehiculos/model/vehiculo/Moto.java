package marcos.Vehiculos.model.vehiculo;

import jakarta.persistence.*;
import marcos.Vehiculos.model.propietario.Propietario;

@Entity
@PrimaryKeyJoinColumn (name = "idMoto")
public abstract class Moto extends Vehiculo {
    @Column(length = 4)
    private Integer cilindrada;
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "idPropietario")
    private Propietario propietario;

    public Moto() {

    }

    public Moto(Integer cilindrada, String tipo) {
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public Moto(String marca, String modelo, Integer ano, Float precio, Integer cilindrada, String tipo) {
        super(marca, modelo, ano, precio);
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }

    public Integer getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "cilindrada: " + cilindrada + ", tipo: " + tipo ;
    }
}
