package Java.Boletines.boletin0103.trivialGson;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class PreguntaMC extends Pregunta implements Predicate<Integer> {

    private List<Opcion> opciones;

    public PreguntaMC() {
        setTipoPregunta(TipoPregunta.MULTIPLE_CHOICE);
        opciones = new java.util.ArrayList<>();
    }

    public PreguntaMC(String pregunta) {
        setTipoPregunta(TipoPregunta.MULTIPLE_CHOICE);
        opciones = new java.util.ArrayList<>();
    }

    public PreguntaMC(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public Pregunta setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
        return this;
    }

    public PreguntaMC addOpcion(Opcion opcion) {
        if (opciones == null) {
            opciones = new java.util.ArrayList<>();
        }
        opciones.add(opcion);
        return this;
    }

    public PreguntaMC addOpciones(List<Opcion> opciones) {
        if (this.opciones == null) {
            this.opciones = new java.util.ArrayList<>();
        }
        this.opciones.addAll(opciones);
        return this;
    }

    // getNumCorrectas
    public int getNumCorrectas() {
        return (int) opciones.stream().filter(Opcion::isCorrecta).count();
    }

    /**
     * getPuntos`: recoge una List de enteros con los números de las opciones marcadas (pueden marcar varias)
     * y devuelve los puntos obtenidos. Las incorrectas cuentan negativo.
     * @return puntos obtenidos
     */

    public int getPuntos(List<Integer> marcadas) {
        int correctas = getNumCorrectas();
        var marcadasSet = new HashSet<>(marcadas);
        if (marcadas.size() != correctas) {
            return 0;
        }
        int marcadasBien = 0;
        int marcadasMal = 0;
        for (int i : marcadasSet) {
            if (opciones.get(i).isCorrecta()) {
                marcadasBien++;
            } else {
                marcadasMal++;
            }
        }
        return (marcadasBien-marcadasMal)/correctas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        opciones.forEach(opcion -> sb.append(TABULACION).append(opcion).append(System.lineSeparator()));
        return sb.toString();
    }

    @Override
    public boolean test(Integer numeroMarcado) {
        return  !(numeroMarcado < 0 || numeroMarcado >= opciones.size())
                && opciones.get(numeroMarcado).isCorrecta();
    }
}


