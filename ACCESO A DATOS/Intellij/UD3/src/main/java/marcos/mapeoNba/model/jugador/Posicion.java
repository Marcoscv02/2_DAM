package marcos.mapeoNba.model.jugador;


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

    public String getCodigo() {
        return codigo;
    }

    public static Posicion getPosicion(String codigo){
        if (codigo!=null){
            for (Posicion p: Posicion.values()){
                if (p.codigo.equalsIgnoreCase(codigo)) return p;
            }
        }
        System.out.println("No se han encontrado coincidencias de posición en método getPosición");
        return null;
    }
}
