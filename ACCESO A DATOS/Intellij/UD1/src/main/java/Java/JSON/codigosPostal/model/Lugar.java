package Java.JSON.codigosPostal.model;

public class Lugar {
    String nombre;
    Long longitud;
    String comunidad;
    String abrComunidad;
    Double Laitud;

    public Lugar() {
    }

    public Lugar(String nombre, Long longitud, String comunidad, String abrComunidad, Double laitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.comunidad = comunidad;
        this.abrComunidad = abrComunidad;
        Laitud = laitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getAbrComunidad() {
        return abrComunidad;
    }

    public void setAbrComunidad(String abrComunidad) {
        this.abrComunidad = abrComunidad;
    }

    public Double getLaitud() {
        return Laitud;
    }

    public void setLaitud(Double laitud) {
        Laitud = laitud;
    }

    @Override
    public String toString() {
        return "Lugar:\n" +
                "nombre: " + nombre + '\n' +
                "longitud: " + longitud +"\n"+
                "comunidad: " + comunidad + '\t' +
                "abrComunidad: " + abrComunidad + '\n' +
                "Laitud: " + Laitud ;
    }
}
