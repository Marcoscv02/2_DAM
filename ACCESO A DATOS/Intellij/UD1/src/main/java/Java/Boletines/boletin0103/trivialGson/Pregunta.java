package Java.Boletines.boletin0103.trivialGson;

import java.io.Serializable;
import java.util.Objects;

public class Pregunta implements Comparable<Pregunta>, Serializable {
    private long idPregunta;
    private String pregunta;
    private TipoPregunta tipoPregunta;
    private Dificultad dificultad;
    private Categoria categoria;

    public Pregunta(String pregunta, TipoPregunta tipoPregunta, Dificultad dificultad, Categoria categoria) {
        this.pregunta = pregunta;
        this.tipoPregunta = tipoPregunta;
        this.dificultad = dificultad;
        this.categoria = categoria;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pregunta pregunta1)) return false;
        return Objects.equals(pregunta, pregunta1.pregunta) && tipoPregunta == pregunta1.tipoPregunta && dificultad == pregunta1.dificultad && Objects.equals(categoria, pregunta1.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pregunta, tipoPregunta, dificultad, categoria);
    }


    @Override
    public String toString() {
        return "Pregunta{" +
                "pregunta='" + pregunta + '\'' +
                ", tipoPregunta=" + tipoPregunta +
                ", dificultad=" + dificultad +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public int compareTo(Pregunta o) {
        return 0;
    }
}
