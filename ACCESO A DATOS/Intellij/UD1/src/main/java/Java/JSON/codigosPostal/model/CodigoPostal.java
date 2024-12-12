package Java.JSON.codigosPostal.model;

import java.util.List;

public class CodigoPostal {
    Integer codPostal;
    String pais;
    String abrPais;
    List<Lugar> lugares;

    public CodigoPostal() {
    }

    public CodigoPostal(Integer codPostal, String pais, String abrPais, List<Lugar> lugares) {
        this.codPostal = codPostal;
        this.pais = pais;
        this.abrPais = abrPais;
        this.lugares = lugares;
    }

    public Integer getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Integer codPostal) {
        this.codPostal = codPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAbrPais() {
        return abrPais;
    }

    public void setAbrPais(String abrPais) {
        this.abrPais = abrPais;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    @Override
    public String toString() {
        return "CodigoPostal{" +
                "codPostal=" + codPostal +
                ", pais='" + pais + '\'' +
                ", abrPais='" + abrPais + '\'' +
                ", lugares=" + lugares +
                '}';
    }
}
