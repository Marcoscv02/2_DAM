package Java.JSON.appMeteoGalicia;

import java.util.Objects;

public class Concello {
    private int idConcello;
    private String nombre;

    //Constructores
    public Concello() {
    }

    public Concello(int idConcello, String nombre) {
        this.idConcello = idConcello;
        this.nombre = nombre;
    }


    //Getter/Setter
    public int getIdConcello() {
        return idConcello;
    }

    public void setIdConcello(int idConcello) {
        this.idConcello = idConcello;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Concello concello = (Concello) o;
        return idConcello == concello.idConcello && Objects.equals(nombre, concello.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConcello, nombre);
    }

    @Override
    public String toString() {
        return "Concello{" +
                "idConcello=" + idConcello +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
