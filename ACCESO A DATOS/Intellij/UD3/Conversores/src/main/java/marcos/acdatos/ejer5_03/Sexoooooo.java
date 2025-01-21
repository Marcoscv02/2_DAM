package marcos.acdatos.ejer5_03;

public enum Sexoooooo {
    HOMBRE("H"),
    MUJER("M");

    private String codigo;

    Sexoooooo(String codigo) {
        this.codigo=codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    public Sexoooooo valueOfSexo(String codigo){
       if (codigo!=null&&!codigo.equalsIgnoreCase(" ")){
           for (Sexoooooo s: Sexoooooo.values()){
               if (s.getCodigo().equalsIgnoreCase(codigo)){
                   return s;
               }
           }
       }
       return null;
    }
}
