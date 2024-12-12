package org.example.JokeToDB.model;

public enum Flag {
    NSFW("nsfw"),
    REGILIOUS("religious"),
    POLITICAL("political"),
    RACIST("racist"),
    SEXIST("sexist"),
    EXPLICIT("explicit");

    public final String nombre;

    Flag(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public static Flag getType (String flag){
        for (Flag f: Flag.values()){
            if (f.getNombre().equals(flag))
                return f;
        }
        return null;
    }
}
