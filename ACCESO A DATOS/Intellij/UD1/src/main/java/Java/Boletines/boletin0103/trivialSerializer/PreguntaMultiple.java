package Java.Boletines.boletin0103.trivialSerializer;

import java.util.List;
import java.util.Objects;

public class PreguntaMultiple extends Pregunta{
    List<Opcion>opciones;

    public PreguntaMultiple() {
    }

    public PreguntaMultiple(String qustion, TipoPregunta tipoPregunta, String categoria, Dificultad dificultad, List<Opcion> opciones) {
        super(qustion, tipoPregunta, categoria, dificultad);
        this.opciones = opciones;
    }

    public PreguntaMultiple(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PreguntaMultiple that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(opciones, that.opciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), opciones);
    }

    @Override
    public String toString() {
        return "PreguntaMultiple{" +
                "question='" + question + '\'' +
                ", tipoPregunta=" + tipoPregunta +
                ", categoria='" + categoria + '\'' +
                ", dificultad=" + dificultad +
                ", opciones=" + opciones +
                '}';
    }
}
