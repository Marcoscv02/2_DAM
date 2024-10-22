package Java.Boletines.boletin0103.trivialSerializer;

import Java.Boletines.boletin0103.trivialGson.Categoria;

import java.util.Objects;

public class Pregunta {
    String question;
    TipoPregunta tipoPregunta;
    String categoria;
    Dificultad dificultad;

    public Pregunta() {
    }

    public Pregunta(String qustion, TipoPregunta tipoPregunta, String categoria, Dificultad dificultad) {
        this.question = qustion;
        this.tipoPregunta = tipoPregunta;
        this.categoria = categoria;
        this.dificultad = dificultad;
    }

    public String getQustion() {
        return question;
    }

    public void setQustion(String qustion) {
        this.question = qustion;
    }

    public TipoPregunta getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(TipoPregunta tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Dificultad getDificultad() {
        return dificultad;
    }

    public void setDificultad(Dificultad dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pregunta pregunta)) return false;
        return Objects.equals(question, pregunta.question) && tipoPregunta == pregunta.tipoPregunta && Objects.equals(categoria, pregunta.categoria) && dificultad == pregunta.dificultad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, tipoPregunta, categoria, dificultad);
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "question='" + question + '\'' +
                ", tipoPregunta=" + tipoPregunta +
                ", categoria='" + categoria + '\'' +
                ", dificultad=" + dificultad +
                '}';
    }
}
