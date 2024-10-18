package Java.Boletines.boletin0103.trivialGson;

public enum TipoPregunta {
    MULTIPLE_CHOICE("EleccionMultiple"), BOOLEAN("Verdadero/Falso");
    private String tipoPregunta ;

    TipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }
}
