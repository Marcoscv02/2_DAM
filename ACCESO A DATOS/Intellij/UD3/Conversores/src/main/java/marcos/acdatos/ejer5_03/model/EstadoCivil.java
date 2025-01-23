package marcos.acdatos.ejer5_03.model;

public enum EstadoCivil {
    SOLTERO ("Soltero"),
    CASADO ("Casado") ,
    DIVORCIADO ("Divorciado"),
    VIUDO ("Viudo");

    private String codigo;

    EstadoCivil(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public EstadoCivil valueOfCodigo(String codigo){
        if (codigo!=null||!codigo.equals(" ")){
            for (EstadoCivil estado: EstadoCivil.values()){
                if (estado.getCodigo().equalsIgnoreCase(codigo)){
                    return estado;
                }
            }
        }

        return null;
    }
}
