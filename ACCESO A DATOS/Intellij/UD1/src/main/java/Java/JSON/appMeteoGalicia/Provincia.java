package Java.JSON.appMeteoGalicia;

import java.util.ArrayList;
import java.util.List;

public class Provincia {
    private String nome;
    private Integer idProvincia;
    private List<Concello>concellos;

    public Provincia() {
    }

    public Provincia(String nome) {
        this.nome = nome;
    }

    public Provincia(String nome, List<Concello> concello) {
        this.nome = nome;
        this.concello = new ArrayList<>();
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
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
        return "["+idProvincia+
                "] "+nome+": "+concellos;
    }
}