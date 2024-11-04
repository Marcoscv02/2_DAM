package Java.JSON.appMeteoGalicia;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class PrediccionDia {
    private LocalDate dataPredicion;
    private int nivelAviso,tMax, tMin, uvMaz;
    private List<VariableFranxa> listaVariableFranxa;

    // Constructores
    public PrediccionDia() {
    }

    public PrediccionDia(LocalDate dataPredicion, int nivelAviso, int tMax, int tMin, int uvMaz, List<VariableFranxa> listaVariableFranxa) {
        this.dataPredicion = dataPredicion;
        this.nivelAviso = nivelAviso;
        this.tMax = tMax;
        this.tMin = tMin;
        this.uvMaz = uvMaz;
        this.listaVariableFranxa = listaVariableFranxa;
    }

    //Getters y Setters
    public LocalDate getDataPredicion() {
        return dataPredicion;
    }

    public void setDataPredicion(LocalDate dataPredicion) {
        this.dataPredicion = dataPredicion;
    }

    public int getNivelAviso() {
        return nivelAviso;
    }

    public void setNivelAviso(int nivelAviso) {
        this.nivelAviso = nivelAviso;
    }

    public int gettMax() {
        return tMax;
    }

    public void settMax(int tMax) {
        this.tMax = tMax;
    }

    public int gettMin() {
        return tMin;
    }

    public void settMin(int tMin) {
        this.tMin = tMin;
    }

    public int getUvMaz() {
        return uvMaz;
    }

    public void setUvMaz(int uvMaz) {
        this.uvMaz = uvMaz;
    }

    public List<VariableFranxa> getListaVariableFranxa() {
        return listaVariableFranxa;
    }

    public void setListaVariableFranxa(List<VariableFranxa> listaVariableFranxa) {
        this.listaVariableFranxa = listaVariableFranxa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrediccionDia that = (PrediccionDia) o;
        return nivelAviso == that.nivelAviso && tMax == that.tMax && tMin == that.tMin && uvMaz == that.uvMaz && Objects.equals(dataPredicion, that.dataPredicion) && Objects.equals(listaVariableFranxa, that.listaVariableFranxa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataPredicion, nivelAviso, tMax, tMin, uvMaz, listaVariableFranxa);
    }

    @Override
    public String toString() {
        return "PrediccionDia{" +
                "dataPredicion=" + dataPredicion +
                ", nivelAviso=" + nivelAviso +
                ", tMax=" + tMax +
                ", tMin=" + tMin +
                ", uvMaz=" + uvMaz +
                ", listaVariableFranxa=" + listaVariableFranxa +
                '}';
    }
}
