package Java.JSON.codigos_postal;

import java.util.Objects;

public class Lugar {

    private String nome;
    private double longitud;
    private double latitud;
    private String estado;
    private String abreviaturaEstado;

    //Constructores
    public Lugar() {
    }

    public Lugar(String nome) {
        this.nome = nome;
    }

    public Lugar(String nome, double longitud, double latitud, String estado, String abreviaturaEstado) {
        this.nome = nome;
        this.longitud = longitud;
        this.latitud = latitud;
        this.estado = estado;
        this.abreviaturaEstado = abreviaturaEstado;
    }


    //getters y setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAbreviaturaEstado() {
        return abreviaturaEstado;
    }

    public void setAbreviaturaEstado(String abreviaturaEstado) {
        this.abreviaturaEstado = abreviaturaEstado;
    }



    //Metodo que devuelve un String con los datos del lugar en formato HTML con colores.
    public String toHTML() {
        return "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    /*
    Método que recoge un boolean si quiero devolver el lugar en formato fila de una tabla HTML.
    Devuelve un String con los datos del lugar en formato HTML con colores.
    Si está en una fila de una tabla HTML, el fondo de la fila es de color gris.
    */
    public String toHTML(boolean fila) {
        return (fila) ? "<tr style=\"background-color: #cccccc\">"
                + "<td>" + nome + "</td>"
                + "<td>" + longitud + "</td>"
                + "<td>" + latitud + "</td>"
                + "<td>" + estado + "</td>"
                + "<td>" + abreviaturaEstado + "</td>"
                + "</tr>"
                : "<h1>" + nome + "</h1>"
                + "Longitud: " + longitud + "<br/>"
                + "Latitud: " + latitud + "<br/>"
                + "Comunidad: " + estado + "<br/>"
                + "Abreviatura Comunidad: " + abreviaturaEstado + "<br/>";
    }

    //Equals y HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lugar lugar = (Lugar) o;
        return Double.compare(longitud, lugar.longitud) == 0 && Double.compare(latitud, lugar.latitud) == 0 && Objects.equals(nome, lugar.nome) && Objects.equals(estado, lugar.estado) && Objects.equals(abreviaturaEstado, lugar.abreviaturaEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, longitud, latitud, estado, abreviaturaEstado);
    }

    //toString
    @Override
    public String toString() {
        return " Lugar: " + nome + System.lineSeparator()
                + " Longitud: " + longitud + System.lineSeparator()
                + " Latitud: " + latitud + System.lineSeparator()
                + " Comunidad: " + estado + System.lineSeparator()
                + " Abreviatura Comunidad: " + abreviaturaEstado + System.lineSeparator();
    }
    //...


}
