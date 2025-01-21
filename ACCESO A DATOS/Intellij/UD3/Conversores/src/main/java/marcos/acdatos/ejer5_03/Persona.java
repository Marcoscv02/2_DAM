package marcos.acdatos.ejer5_03;

import jakarta.persistence.*;
import marcos.acdatos.ejer5_03.pakages.EstadoCivilConverter;
import marcos.acdatos.ejer5_03.pakages.SexoConverter;

import java.time.LocalDate;

@Entity()
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idPersona;
    String nombre;
    String apellidos;

    @Transient private Integer edad;

    LocalDate fechaNac;

    @Convert(converter = SexoConverter.class)
    Sexoooooo sexo;
    @Convert(converter = EstadoCivilConverter.class)
    EstadoCivil estadoCivil;
    @Lob
    Byte[] foto;

    public Persona() {
    }

    public Persona(Long idPersona, String nombre, String apellidos, Integer edad, LocalDate fechaNac, Sexoooooo sexo, EstadoCivil estadoCivil, Byte[] foto) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.foto = foto;
    }

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Sexoooooo getSexo() {
        return sexo;
    }

    public void setSexo(Sexoooooo sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }
}
