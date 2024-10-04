package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.util.Objects;

public class Equipo implements Comparable<Equipo>{
    String nombre, ciudad;
     private int victorias, derrotas, puntFavor, untContra, partidosJugados;

    //Constructor por defecto
    public Equipo() {
    }
    //Constructor de nombre
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    //Costructor
    public Equipo(String nombre, String ciudad, int victorias, int derrotas, int puntFavor, int untContra, int partidosJugados) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntFavor = puntFavor;
        this.untContra = untContra;
        this.partidosJugados = partidosJugados;
    }

    //Getters y Setters
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

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getPuntFavor() {
        return puntFavor;
    }

    public void setPuntFavor(int puntFavor) {
        this.puntFavor = puntFavor;
    }

    public int getUntContra() {
        return untContra;
    }

    public void setUntContra(int untContra) {
        this.untContra = untContra;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    //Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipo equipo)) return false;
        return Objects.equals(nombre, equipo.nombre) && Objects.equals(ciudad, equipo.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ciudad);
    }

    //Método toString
    @Override
    public String toString() {
        return "Equipo:" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", victorias=" + victorias +
                ", derrotas=" + derrotas +
                ", puntFavor=" + puntFavor +
                ", untContra=" + untContra +
                ", partidosJugados=" + partidosJugados;
    }
}
