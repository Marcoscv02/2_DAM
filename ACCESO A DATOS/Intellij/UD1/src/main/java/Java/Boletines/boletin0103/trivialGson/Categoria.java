package Java.Boletines.boletin0103.trivialGson;

import java.util.Objects;

public class Categoria {
    //Variable
    private String nombre;
    //Constructor
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    //Getter&Setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Equals&hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria categoria)) return false;
        return Objects.equals(nombre, categoria.nombre);
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
    //toString
    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
