package Java.JSON.JokesApp.model;

public enum Lang {
    CS("cs"),
    DE("de"),
    EN("en"),
    ES("es"),
    FR("fr"),
    PT("pt");
    public final String nombre;

    Lang(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Lang getLang(String lang){
        for (Lang l:Lang.values()){
            if (l.getNombre().equals(lang))
                return l;
        }
        return null;
    }
}
