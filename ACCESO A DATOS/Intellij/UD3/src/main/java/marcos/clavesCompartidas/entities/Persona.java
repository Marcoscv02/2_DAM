package marcos.clavesCompartidas.entities;

import jakarta.persistence.*;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombre;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Departamento departamento;

    //Constructor
    public Persona() {
    }

    public Persona(Long idPersona, String nombre, Departamento departamento) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.departamento = departamento;
    }

    //Getter y Setter
    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
