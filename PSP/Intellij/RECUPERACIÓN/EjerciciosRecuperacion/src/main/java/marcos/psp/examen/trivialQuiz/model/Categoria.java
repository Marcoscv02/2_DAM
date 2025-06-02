package marcos.psp.examen.trivialQuiz.model;

public enum Categoria {
    GENERAL_KNOWLEDGE ("General Knowledge"),

    ENTERTAIMENT_BOOKS ("Entertainment: Books"),
    ENTERTAIMENT_FILM ("Entertainment: Film"),
    ENTERTAIMENT_MUSIC ("Entertainment: Music"),
    ENTERTAIMENT_MUSICAL_THEATRES ("Entertainment: Musicals &amp; Theatres"),
    ENTERTAIMENT_TELEVISION ("Entertainment: Television"),
    ENTERTAIMENT_VIDEOGAMES ("Entertainment: Video Games"),
    ENTERTAIMENT_BOARDGAMES ("Entertainment: Board Games"),
    ENTERTAIMENT_ANIME_MANGA ("Entertainment: Japanese Anime &amp; Manga"),
    ENTERTAIMENT_CARTOON_ANIMATIONS ("Entertainment: Cartoon &amp; Animations"),
    ENTERTAIMENT_COMICS ("Entertainment: Comics"),

    SCIENCE_NATURE ("Science &amp; Nature"),
    SCIENCE_COMPUTER ("Science: Computers"),
    SCIENCE_MATHEMATICS ("Science: Mathematics"),
    SCIENCE_GADGETS ("Science: Gadgets"),

    MYTHOLOGY ("Mythology"),
    SPORTS ("Sports"),
    GEOGRAPHY ("Geography"),
    HISTORY ("History"),
    POLITICS ("Politics"),
    ART ("Art"),
    CELIBRITIES ("Celebrities"),
    ANIMALS ("Animals"),
    VEHICLES ("Vehicles");


    private String key;

    Categoria(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    /**
     *Método para obtener una categoría a partir de su clave
     * @return Categoria
     */
    public static  Categoria getCategoria(String key){
        for (Categoria c: Categoria.values()){
            if (c.getKey().equalsIgnoreCase(key))
                return c;
        }
        System.out.println("No se ha encontrado ninguna coincidencia");
        return null;
    }
}
