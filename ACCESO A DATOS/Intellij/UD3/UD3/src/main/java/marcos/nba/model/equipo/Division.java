package marcos.nba.model.equipo;


public enum Division {
    ATLANTICO("ATLANTIC"),
    CENTRAL("CENTRAL"),
    SURESTE ("SOUTHEAST"),
    NOROESTE ("NORTHWEST"),
    PACIFICO ("PACIFIC"),
    SUROESTE ("SOUTHWEST");

    private String codigo;

    Division(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Division getDivision(String codigo){
        if (codigo!=null){
            for (Division d: Division.values()){
                if (d.getCodigo().equalsIgnoreCase(codigo)) return d;
            }
        }
        System.out.println("No se ha encontrado ninguna coincidencia, por favor compruebe el dato introducido como parámetro en el método getDivision");
        return null;
    }
}
