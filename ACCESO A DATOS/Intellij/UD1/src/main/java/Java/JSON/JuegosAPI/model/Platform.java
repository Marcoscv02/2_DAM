package Java.JSON.JuegosAPI.model;

public enum Platform {
    BROWSER ("Web Browser"),
    PC ("PC"),
    ALL ("All");

    private final String nombre;

    Platform(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Platform getPlatorm (String nombre) {
        for (Platform p: Platform.values()){
            if (p.getNombre().equals(nombre));
            return p;
        }

        return null;
    }
}
