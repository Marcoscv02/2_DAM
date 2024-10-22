package Java.Boletines.boletin0103.trivialSerializer;

import java.util.Objects;

public class Opcion {
    String respuesta;
    Boolean correcta;

    public Opcion() {
    }

    public Opcion(String respuesta, Boolean correcta) {
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Opcion opcion)) return false;
        return Objects.equals(respuesta, opcion.respuesta) && Objects.equals(correcta, opcion.correcta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respuesta, correcta);
    }
}
