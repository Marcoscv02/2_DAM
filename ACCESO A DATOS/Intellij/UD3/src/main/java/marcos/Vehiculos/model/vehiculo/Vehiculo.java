package marcos.Vehiculos.model.vehiculo;

import jakarta.persistence.*;
import marcos.Vehiculos.model.propietario.Propietario;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehiculo;
    @Column(length = 100)
    private String marca;
    @Column(length = 100)
    private String modelo;
    @Column(length = 4)
    private Integer ano;
    private Float precio;

    @ManyToOne
    @JoinColumn(name = "propietario")
    private Propietario propietario;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, Integer ano, Float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precio = precio;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "[" + idVehiculo +"], marca: " + marca + modelo  + ", (año: " + ano + "), precio: " + precio;
    }
}
