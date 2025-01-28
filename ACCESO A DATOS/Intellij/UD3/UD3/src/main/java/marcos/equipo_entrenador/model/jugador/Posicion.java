package marcos.equipo_entrenador.model.jugador;

public enum Posicion {
    BASE("G"),
    ESCOLTA("C"),
    ALERO("F"),
    ALA_PIVOT("F-C"),
    PIVOT("C-F");

    private String codigo;

    Posicion(String codigo) {
        this.codigo = codigo;
    }

//    public static Posicion getPosicion(String codigo){
//        if (codigo!=null){
//            for ()
//        }
//    }
}
