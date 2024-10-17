package Java.Boletines.boletin0103.trivialGson;

public class PreguntaTF extends Pregunta{ //Pregunta True/False

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
}
