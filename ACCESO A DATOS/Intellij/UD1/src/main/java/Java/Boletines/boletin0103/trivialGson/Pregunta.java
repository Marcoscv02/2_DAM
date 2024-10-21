package Java.Boletines.boletin0103.trivialGson;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Pregunta implements Serializable, Comparable<Pregunta> {

    public static final String TABULACION = "  ";

    private TipoPregunta tipoPregunta;
    private Dificultad dificultad;
    private Categoria categoria;
    private String pregunta;
    private String correcta;
    private List<String>incorrecta;

    public Pregunta() {
    }

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

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public List<String> getIncorrecta() {
        return incorrecta;
    }

    public Pregunta setIncorrecta(List<String> incorrecta) {
        this.incorrecta = incorrecta;
        return this;
    }

    public void addIncorrectas(String incorrecta1){
        if (incorrecta==null){
            incorrecta.add(incorrecta1);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pregunta pregunta1)) return false;
        return Objects.equals(pregunta, pregunta1.pregunta) &&
                tipoPregunta == pregunta1.tipoPregunta &&
                dificultad == pregunta1.dificultad && Objects.equals(categoria, pregunta1.categoria);
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

    //Método compareto
    @Override
    public int compareTo(Pregunta o) {
        return this.pregunta.compareToIgnoreCase(o.pregunta);
    }
}
