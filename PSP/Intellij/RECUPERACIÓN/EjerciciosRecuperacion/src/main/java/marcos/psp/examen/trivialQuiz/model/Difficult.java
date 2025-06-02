package marcos.psp.examen.trivialQuiz.model;

public enum Difficult {
    EASY ("easy"),
    MEDIUM ("medium"),
    HARD ("hard");

    private String Key;

    Difficult(String key) {
        Key = key;
    }

    public String getKey() {
        return Key;
    }
    public static Difficult getDifficult (String key){
        for (Difficult d: Difficult.values()){
            if (d.getKey().equalsIgnoreCase(key))
                return d;
        }
        System.out.println("No se han encontrado coincidencias");
        return null;
    }
}
