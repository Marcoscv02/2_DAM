package marcos.equipo_entrenador.model.jugador;

import jakarta.persistence.*;
import marcos.equipo_entrenador.model.equipo.Equipo;
import marcos.equipo_entrenador.model.jugador.converters.PosicionConverter;
import marcos.equipo_entrenador.model.posicion.Posicion;

import java.util.List;

@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJugador;
    private String nombre;
    private String apellido;
    private Double altura;
    private Double peso;
    private Short numero;
    @Temporal(TemporalType.DATE)
    private Integer anhoDraft;
    private Short numeroDraft;
    private Short rondaDraft;
//    @Convert(converter = PosicionConverter.class)
//    private Posicion posicion;
    private String pais;
    private String colegio;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    private Byte[] foto;

    @ManyToOne
    @JoinColumn(name = "idEquipo")
    private Equipo equipo;

    @ManyToMany
    @JoinTable(//Lado propietario
            name = "Jugador_Posicion",
            joinColumns = @JoinColumn(name = "idJugador"),
            inverseJoinColumns = @JoinColumn(name = "idPosicion")
    )
    private List<Posicion> posiciones;


    //constructores
    public Jugador() {
    }

    public Jugador(String nombre, String apellido, Double altura, Double peso, Short numero, Integer anhoDraft, Short numeroDraft, Short rondaDraft, String pais, String colegio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anhoDraft = anhoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        //this.posicion = posicion;
        this.pais = pais;
        this.colegio = colegio;
    }

    public Jugador(String nombre, String apellido, Double altura, Double peso, Short numero, Integer anhoDraft, Short numeroDraft, Short rondaDraft, String pais, String colegio, Byte[] foto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anhoDraft = anhoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        //this.posicion = posicion;
        this.pais = pais;
        this.colegio = colegio;
        this.foto = foto;
    }

    public Jugador(String nombre, String apellido, Double altura, Double peso, Short numero, Integer anhoDraft, Short numeroDraft, Short rondaDraft, String pais, String colegio, Byte[] foto, Equipo equipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.altura = altura;
        this.peso = peso;
        this.numero = numero;
        this.anhoDraft = anhoDraft;
        this.numeroDraft = numeroDraft;
        this.rondaDraft = rondaDraft;
        //this.posicion = posicion;
        this.pais = pais;
        this.colegio = colegio;
        this.foto = foto;
        this.equipo = equipo;
    }

    //Getters y Setters

    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Short getNumero() {
        return numero;
    }

    public void setNumero(Short numero) {
        this.numero = numero;
    }

    public Integer getAnhoDraft() {
        return anhoDraft;
    }

    public void setAnhoDraft(Integer anhoDraft) {
        this.anhoDraft = anhoDraft;
    }

    public Short getNumeroDraft() {
        return numeroDraft;
    }

    public void setNumeroDraft(Short numeroDraft) {
        this.numeroDraft = numeroDraft;
    }

    public Short getRondaDraft() {
        return rondaDraft;
    }

    public void setRondaDraft(Short rondaDraft) {
        this.rondaDraft = rondaDraft;
    }

//    public Posicion getPosicion() {
//        return posicion;
//    }

//    public void setPosicion(Posicion posicion) {
//        this.posicion = posicion;
//    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getColegio() {
        return colegio;
    }

    public void setColegio(String colegio) {
        this.colegio = colegio;
    }

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador:\n" +
                "[" + idJugador +"] nombre:" + nombre + apellido +" (altura:" + altura +", peso=" + peso +")\n"+
                ", numero:" + numero +"\t Draft:( anho:" + anhoDraft + ", numero=" + numeroDraft + ", ronda:" + rondaDraft +")\n"+
                "Datos de interés[ pais:"+ pais +", colegio:" + colegio +", equipo=" + equipo +"]";
    }
}
