package org.example.JokeToDB.model;

public enum Type {
    SINGLE("single"),
    TWOPART("twopart");

    public final String nombre;

    Type(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Type getType (String nombre){
        for (Type c : Type.values()){
            if (c.getNombre().equals(nombre))
                return c;
        }
        return null;
    }
}
