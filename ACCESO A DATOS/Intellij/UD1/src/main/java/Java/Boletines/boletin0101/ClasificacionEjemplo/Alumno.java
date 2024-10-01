package Java.Boletines.boletin0101.ClasificacionEjemplo;

import java.util.Objects;

public class Alumno {
    private String nombre;
    private String correo;
    private Integer idade;

    public Alumno() {
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
    }

    public Alumno(String nombre, String correo, Integer idade) {
        this.nombre = nombre;
        this.correo = correo;
        this.idade = idade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno alumno)) return false;
        return Objects.equals(nombre, alumno.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre='" + nombre + '\'' + ", correo='" + correo + '\'' + ", idade=" + idade + '}';
    }
}
