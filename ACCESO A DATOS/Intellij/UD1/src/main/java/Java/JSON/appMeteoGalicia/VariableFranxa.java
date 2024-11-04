package Java.JSON.appMeteoGalicia;

import java.util.Objects;

public class VariableFranxa {
    private VariableMeteoroloxica varMeteo;
    private int vMañana;
    private int vTarde;
    private int vNoche;

    //Constructores
    public VariableFranxa() {
    }

    public VariableFranxa(VariableMeteoroloxica varMeteo, int vMañana, int vTarde, int vNoche) {
        this.varMeteo = varMeteo;
        this.vMañana = vMañana;
        this.vTarde = vTarde;
        this.vNoche = vNoche;
    }

    //Getter/Setter
    public VariableMeteoroloxica getVarMeteo() {
        return varMeteo;
    }

    public void setVarMeteo(VariableMeteoroloxica varMeteo) {
        this.varMeteo = varMeteo;
    }

    public int getvMañana() {
        return vMañana;
    }

    public void setvMañana(int vMañana) {
        this.vMañana = vMañana;
    }

    public int getvTarde() {
        return vTarde;
    }

    public void setvTarde(int vTarde) {
        this.vTarde = vTarde;
    }

    public int getvNoche() {
        return vNoche;
    }

    public void setvNoche(int vNoche) {
        this.vNoche = vNoche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VariableFranxa that = (VariableFranxa) o;
        return vMañana == that.vMañana && vTarde == that.vTarde && vNoche == that.vNoche && varMeteo == that.varMeteo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(varMeteo, vMañana, vTarde, vNoche);
    }

    @Override
    public String toString() {
        return "VariableFranxa{" +
                "varMeteo=" + varMeteo +
                ", vMañana=" + vMañana +
                ", vTarde=" + vTarde +
                ", vNoche=" + vNoche +
                '}';
    }
}
