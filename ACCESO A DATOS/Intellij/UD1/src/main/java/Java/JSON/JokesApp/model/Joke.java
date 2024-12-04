package Java.JSON.JokesApp.model;

public class Joke {
    private boolean error;
    private String category;
    private String type;
    private String setUp;
    private String delivery;
    private Flag flags;
    private boolean safe;
    private int id;
    private String lang;


    public Joke() {
    }
    public Joke(boolean error, String category, String type, String setUp, String delivery, Flag flags, boolean safe, int id, String lang) {
        this.error = error;
        this.category = category;
        this.type = type;
        this.setUp = setUp;
        this.delivery = delivery;
        this.flags = flags;
        this.safe = safe;
        this.id = id;
        this.lang = lang;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
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

    public String getSetUp() {
        return setUp;
    }

    public void setSetUp(String setUp) {
        this.setUp = setUp;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public Flag getFlags() {
        return flags;
    }

    public void setFlags(Flag flags) {
        this.flags = flags;
    }

    public boolean isSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                ", setUp='" + setUp + '\'' +
                ", delivery='" + delivery + '\'' +
                ", flags=" + flags +
                ", safe=" + safe +
                ", id=" + id +
                ", lang='" + lang + '\'' +
                '}';
    }
}
