package marcos.psp.examen.jokes.model;

import java.util.List;

public class Joke {
    private Boolean error;
    private String category;
    private String type;
    private String joke;
    private String setup;
    private String delivery;
    private Flags flags;
    private Boolean safe;
    private Integer id;
    private String lang;

    public Joke() {
    }

    public Joke(Boolean error, String category, String type, String joke, Flags flags, Boolean safe, Integer id, String lang) {
        this.error = error;
        this.category = category;
        this.type = type;
        this.joke = joke;
        this.flags = flags;
        this.safe = safe;
        this.id = id;
        this.lang = lang;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public Boolean getSafe() {
        return safe;
    }

    public void setSafe(Boolean safe) {
        this.safe = safe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "error=" + error +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", joke='" + joke + '\'' +
                ", setup='" + setup + '\'' +
                ", delivery='" + delivery + '\'' +
                ", flags=" + flags +
                ", safe=" + safe +
                ", id=" + id +
                ", lang='" + lang + '\'' +
                '}';
    }
}
