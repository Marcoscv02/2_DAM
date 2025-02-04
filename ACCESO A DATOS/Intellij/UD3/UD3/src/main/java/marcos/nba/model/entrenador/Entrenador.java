package marcos.nba.model.entrenador;

import jakarta.persistence.*;
import marcos.nba.model.equipo.Equipo;

import java.time.LocalDate;

@Entity
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEntrenador;
    private String nombre;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNac;
    private Double salario;
    @OneToOne(mappedBy = "entrenador")
    private Equipo equipo;

    public Entrenador() {
    }

    public Entrenador(String nombre, LocalDate fechaNac, Double salario, Equipo equipo) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.salario = salario;
        this.equipo = equipo;
    }

    public Long getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Long idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Entrenador [" + idEntrenador + "], nombre:" + nombre + ", fechaNac:" + fechaNac + ", salario:" + salario + ", equipo:" + equipo ;
    }
}
