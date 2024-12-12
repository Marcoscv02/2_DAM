package org.example.JokeToDB.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Joke {
    Boolean error;
    Categoria categoría;
    Type tipo;
    String joke;
    String delivery;
    List<Flag> flags= new ArrayList<>();
    Boolean safe;
    Integer id;
    Lang lenguaje;

    public Joke() {
    }

    public Joke(Categoria categoría, Type tipo, String joke, List<Flag> flags, String delivery, Boolean safe, Integer id) {
        this.categoría = categoría;
        this.tipo = tipo;
        this.joke = joke;
        this.flags = flags;
        this.delivery = delivery;
        this.safe = safe;
        this.id = id;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }


    public Categoria getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = Categoria.getCategoría(categoría);
    }


    public Type getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = Type.getType(tipo);
    }


    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }


    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }


    public List<Flag> getFlags() {
        return flags;
    }

    public void addFlag (Flag f){
        flags.add(f);
    }

    public void setFlags(List<Flag> flags) {
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


    public Lang getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = Lang.getLang(lenguaje);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke1 = (Joke) o;
        return Objects.equals(error, joke1.error) && categoría == joke1.categoría && tipo == joke1.tipo && Objects.equals(joke, joke1.joke) && Objects.equals(delivery, joke1.delivery) && Objects.equals(flags, joke1.flags) && Objects.equals(safe, joke1.safe) && Objects.equals(id, joke1.id) && lenguaje == joke1.lenguaje;
    }

    @Override
    public int hashCode() {
        return Objects.hash(error, categoría, tipo, joke, delivery, flags, safe, id, lenguaje);
    }

    @Override
    public String toString() {

        return "Joke:" +
                " categoría=" + categoría +"\t"+
                ", tipo=" + tipo +"\n"+
                "joke= " + joke + '\n' +
                "delivery= " + delivery + '\n' +
                "flags=" + flags +"\t"+
                ", safe=" + safe +"\t"+
                ", id=" + id +"\t"+
                ", lenguaje=" + lenguaje;
    }
}
