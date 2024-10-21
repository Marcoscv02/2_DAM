package Java.Boletines.boletin0103.trivialGson;

import java.util.function.Predicate;

public class PreguntaTF extends Pregunta implements Predicate<Integer> { //Pregunta True/False

    private Boolean respuesta;


    public PreguntaTF(String pregunta, TipoPregunta tipoPregunta, Dificultad dificultad, Categoria categoria, Boolean respuesta) {
        super(pregunta, tipoPregunta, dificultad, categoria);
        this.respuesta=respuesta;
    }

    public Boolean getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Boolean respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "PreguntaTF{" +
                "pregunta: " +getPregunta()+
                "tipo pregunta: "+getTipoPregunta()+
                "dificaultad: "+getDificultad()+
                "categoria: "+getCategoria()+
                "respuesta: " + respuesta +
                '}';
    }

    @Override
    public boolean test(Integer integer) {
        return false;
    }
}
