package Java.Boletines.boletin0103.trivialGson;

import java.util.ArrayList;
import java.util.List;

public class PreguntaMC {
    String correcta;
    List<String>incorrectas= new ArrayList<>();

    public PreguntaMC(String correcta, List<String> incorrectas) {
        this.correcta = correcta;
        this.incorrectas = incorrectas;
    }

    public String getCorrecta() {
        return correcta;
    }

    public List<String> getIncorrectas() {
        return incorrectas;
    }

    @Override
    public String toString() {
        return "PreguntaMC{" +
                "correcta='" + correcta + '\'' +
                ", incorrectas=" + incorrectas +
                '}';
    }
}
