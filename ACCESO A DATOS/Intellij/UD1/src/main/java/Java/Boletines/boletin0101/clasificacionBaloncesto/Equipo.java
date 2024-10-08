package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.Serializable;
import java.util.Objects;

public class Equipo implements Comparable<Equipo>, Serializable {
    String nombre, ciudad;
     private int victorias, derrotas, puntFavor, puntContra, partidosJugados;

    //Constructor por defecto
    public Equipo() {
    }
    //Constructor de nombre
    public Equipo(String nombre) {
        this.nombre = nombre;
    }
    //Costructor
    public Equipo(String nombre, String ciudad, int victorias, int derrotas, int puntFavor, int puntContra, int partidosJugados) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.puntFavor = puntFavor;
        this.puntContra = puntContra;
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

    public int getPuntContra() {
        return puntContra;
    }

    public void setPuntContra(int puntContra) {
        this.puntContra = puntContra;
    }

    //métodos derivados
    public int getPartidosJugados(){
        return victorias+derrotas;
    }
    public int getPuntos(){
        return victorias*2;//Se asume que cada victoria suma 2 puntos
    }
    public int getdifPuntos(){
        return puntFavor-puntContra;
    }


    //Equals y HashCode(Se asume que dos equipos son el mismo si tienen el mismo nombre y pertenecen a la misma ciudad)
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
                ", untContra=" + puntContra;
    }
    //Se sobreescribe el metodo de la interfaz Comparable
    @Override
    public int compareTo(Equipo otro) {
        int puntosComparacion = Integer.compare(otro.getPuntos(), this.getPuntos());
        if (puntosComparacion == 0) {
            return Integer.compare(otro.getdifPuntos(), this.getdifPuntos());
        }
        return puntosComparacion;
    }
}
