package Java.JSON.codigos_postal;


import java.util.List;
import java.util.Objects;

public class CodigoPostal {

    private String codigoPostal;
    private String pais;
    private String abreviaturaPais;
    private List<Lugar> lugares;

    //Constructores
    public CodigoPostal() {
    }

    public CodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public CodigoPostal(String codigoPostal, String pais, String abreviaturaPais, List<Lugar> lugares) {
        this.codigoPostal = codigoPostal;
        this.pais = pais;
        this.abreviaturaPais = abreviaturaPais;
        this.lugares = lugares;
    }

    //Getters y Setters
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbreviaturaPais() {
        return abreviaturaPais;
    }

    public void setAbreviaturaPais(String abreviaturaPais) {
        this.abreviaturaPais = abreviaturaPais;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    //Devuelve la lista de lugares como HTML, empleando un forEach para concatenar los lugares.
    public String getLugaresAsHTML() {
        StringBuilder sb = new StringBuilder("<html><body>");
        lugares.forEach(lugar -> {
            sb.append(lugar.toHTML()).append("<br>");
        });
        sb.append("</body></html>");
        return sb.toString();
    }

   //Metodo que devuelve la lista de lugares como HTML, empleando un forEach para concatenar los lugares.
    public String getLugaresAsHTML(boolean asTable) {
        StringBuilder sb = new StringBuilder("<html><body>");
        if (asTable) {
            sb.append("<table border=\"1\">");
            sb.append("<tr style=\"background-color: #cccccc\">");
            sb.append("<th>Lugar</th>");
            sb.append("<th>Longitud</th>");
            sb.append("<th>Latitud</th>");
            sb.append("<th>Comunidad</th>");
            sb.append("<th>Abreviatura Comunidad</th>");
            sb.append("</tr>");
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML(true));
            });
            sb.append("</table>");
        } else {
            lugares.forEach(lugar -> {
                sb.append(lugar.toHTML()).append("<br>");
            });
        }
        sb.append("</body></html>");
        return sb.toString();
    }

    //Equals y HashCode


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoPostal that = (CodigoPostal) o;
        return Objects.equals(codigoPostal, that.codigoPostal) && Objects.equals(pais, that.pais) && Objects.equals(abreviaturaPais, that.abreviaturaPais) && Objects.equals(lugares, that.lugares);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoPostal, pais, abreviaturaPais, lugares);
    }

    //toString
    @Override
    public String toString() {
        var sb = new StringBuilder("Código Postal: '"
                + codigoPostal + System.lineSeparator()
                + "Pais: '" + pais + System.lineSeparator()
                + "AbreviaturaPais: " + abreviaturaPais + System.lineSeparator());
        lugares.forEach(lugar -> {
            sb.append(lugar).append(System.lineSeparator());
        });
        return sb.toString();
    }



}