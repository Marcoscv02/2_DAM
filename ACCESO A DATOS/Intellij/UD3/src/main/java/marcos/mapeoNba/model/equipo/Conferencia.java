package marcos.mapeoNba.model.equipo;


public enum Conferencia {
    ESTE ("EAST"),
    OESTE ("WEST");

    private String codigo;

    Conferencia(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Conferencia getConferencia(String nombre){
        if (nombre!=null){
            for (Conferencia c: Conferencia.values()){
                if (c.getCodigo().equalsIgnoreCase(nombre)) return c;
            }
        }
        System.out.println("No se ha encontrado ninguna coincidencia, por favor compruebe el dato introducido como parámetro en el método getConferencia");
        return null;
    }


}
