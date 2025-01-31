package marcos.equipo_entrenador.model.equipo;

import jakarta.persistence.*;
import marcos.equipo_entrenador.model.equipo.converters.ConferenciaConverter;
import marcos.equipo_entrenador.model.equipo.converters.DivisionConverter;
import marcos.equipo_entrenador.model.entrenador.Entrenador;
import marcos.equipo_entrenador.model.jugador.Jugador;

import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEquipo;
    private String nombre;
    private String ciudad;
    @Convert(converter = ConferenciaConverter.class)
    private Conferencia conferencia;
    @Convert(converter = DivisionConverter.class)
    private Division division;
    private String nombreCompleto;
    @Column(unique = true)
    private String abreviatura;

    @OneToOne
    @JoinColumn(name = "idEntrenador")
    private Entrenador entrenador;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public Equipo() {
    }

    public Equipo(String nombre, String ciudad, Conferencia conferencia, Division division, String nombreCompleto, String abreviatura) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.conferencia = conferencia;
        this.division = division;
        this.nombreCompleto = nombreCompleto;
        this.abreviatura = abreviatura;
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return "Equipo [" + idEquipo + "] ("+abreviatura+") nombre:" + nombre + ", nombreCompleto:" + nombreCompleto ;
    }
}
