package org.example.JokeToDB.model;

public enum Categoria {
    ANY("Any"),
    MISC("Misc"),
    PROGRAMMING("Programming"),
    DARK("Dark"),
    PUN("Pun"),
    SPOOKY("Spooky"),
    CHRISTMAS("Christmas");

    public final String nombre;

    Categoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Método que devuelve la categoría a partir del nombre
     *
     * @param nombre Nombre de la categoría
     * @return Categoria
     */
    public static Categoria getCategoría (String nombre){
        for (Categoria c:Categoria.values()){
            if (c.getNombre().equals(nombre));
            return c;
        }
        return null;
    }
}
