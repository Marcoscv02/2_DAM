package marcos.mapeoVideoJuegos.model.plataforma;

public enum Plataforma {
    PC("pc"),
    Web_Browser("web"),
    All("all"),
    Windows("windows");

    private String codigo;

    Plataforma(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static Plataforma getPlataforma (String codigo){
        if (codigo!=null){
            for (Plataforma p:Plataforma.values()){
                if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
            }
        }
        System.out.println("El codigo introducido no corresponde con ninguna plataforma");
        return null;

    }
}
