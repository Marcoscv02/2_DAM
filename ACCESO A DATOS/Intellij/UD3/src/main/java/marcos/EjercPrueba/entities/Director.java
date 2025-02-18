package marcos.EjercPrueba.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDirector;
    private String nome, apelidos, nacionalidade;

    @OneToMany
    private List<Pelicula>peliculas;

    public Director() {
    }

    public Director(Long idDirector, String nome, String apelidos, String nacionalidade) {
        this.idDirector = idDirector;
        this.nome = nome;
        this.apelidos = apelidos;
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public String toString() {
        return "Director:\n" +
                "[idDirector: " + idDirector +
                "]\t nome=" + nome + apelidos + '\t' +
                "nacionalidade:" + nacionalidade ;
    }
}
