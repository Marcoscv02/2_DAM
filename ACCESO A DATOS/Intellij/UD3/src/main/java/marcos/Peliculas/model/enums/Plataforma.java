package marcos.Peliculas.model.enums;

public enum Plataforma {
    NETFLIX("netflix"),HBO("hbo"),AMAZON("amazon"),APPLETV("appleTv");

    private String codigo;

    Plataforma(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static Plataforma getPlataforma (String codigo){

        for (Plataforma p: Plataforma.values()){
            if (p.getCodigo().equalsIgnoreCase(codigo))
                return p;
        }
        return null;
    }
}
