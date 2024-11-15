package Java.JSON.appMeteoGalicia;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
    private String nome;
    private List<Concello>concellos;

    public Provincia() {
    }

    public Provincia(String nome) {
        this.nome = nome;
    }

    public Provincia(String nome, List<Concello> concellos) {
        this.nome = nome;
        this.concellos = concellos;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Concello> getConcello() {
        return concellos;
    }

    public void setConcello(List<Concello> concello) {
        this.concellos = concello;
    }
    public  void  addConcello(Concello c){
        concellos.add(c);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nome).append(System.lineSeparator());
        concellos.forEach(sb::append);
        return sb.toString();
    }
}
