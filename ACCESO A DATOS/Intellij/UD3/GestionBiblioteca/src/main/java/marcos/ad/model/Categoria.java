package marcos.ad.model;

public enum Categoria {
    NOVELA ("nov"),
    POESIA ("poes"),
    ENSAYO ("ensy"),
    TEATRO ("teat"),
    OTROS ("otrs");

    private String codigo;

    Categoria(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Categoria valueOfCategotia (String codigo){
        if (codigo!=null||!codigo.equalsIgnoreCase(" ")){
            for (Categoria c: Categoria.values()){
                if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
            }
        }
        return null;
    }
}
