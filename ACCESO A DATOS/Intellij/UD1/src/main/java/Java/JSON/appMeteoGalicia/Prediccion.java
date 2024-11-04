package Java.JSON.appMeteoGalicia;

import java.util.List;
import java.util.Objects;

public class Prediccion {
    private Concello concello;
    private List<PrediccionDia>listaPrediccionDia;

    //Constructores
    public Prediccion() {
    }

    public Prediccion(Concello concello, List<PrediccionDia> listaPrediccionDia) {
        this.concello = concello;
        this.listaPrediccionDia = listaPrediccionDia;
    }

    //getters y Setters
    public Concello getConcello() {
        return concello;
    }

    public void setConcello(Concello concello) {
        this.concello = concello;
    }

    public List<PrediccionDia> getListaPrediccionDia() {
        return listaPrediccionDia;
    }

    public void setListaPrediccionDia(List<PrediccionDia> listaPrediccionDia) {
        this.listaPrediccionDia = listaPrediccionDia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prediccion that = (Prediccion) o;
        return Objects.equals(concello, that.concello) && Objects.equals(listaPrediccionDia, that.listaPrediccionDia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(concello, listaPrediccionDia);
    }

    @Override
    public String toString() {
        return "Prediccion{" +
                "concello=" + concello +
                ", listaPrediccionDia=" + listaPrediccionDia +
                '}';
    }
}
