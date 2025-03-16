package marcos.ad.Ejercicios_Spring;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coche {
    @Id
    private Long idCoche;
    private String marca;
    private String modelo;
    private Integer anho;

    public Coche() {
    }

    public Coche(Long idCoche, String marca, String modelo, Integer anho) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.anho = anho;
    }

    public Long getIdCoche() {
        return idCoche;
    }

    public void setIdCoche(Long idCoche) {
        this.idCoche = idCoche;
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

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }
}
