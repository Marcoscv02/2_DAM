package marcos.Peliculas.model.embebidos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Embeddable
@Access(AccessType.FIELD)
public class Multimedia {
    @Column(length = 50)
    private String nome;
    @Column (length = 50)
    private String xenero;
    @Column (length = 125)
    private String pais;
    @Temporal(TemporalType.DATE)
    @Column(name = "lanzamiento")
    private LocalDate anoLanzamento;

    public Multimedia() {
    }

    public Multimedia(String nome, String xenero, String pais, LocalDate anoLanzamento) {
        this.nome = nome;
        this.xenero = xenero;
        this.pais = pais;
        this.anoLanzamento = anoLanzamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getAnoLanzamento() {
        return anoLanzamento;
    }

    public void setAnoLanzamento(LocalDate anoLanzamento) {
        this.anoLanzamento = anoLanzamento;
    }

    @Override
    public String toString() {
        return "nome:" + nome + ", xenero: " + xenero +", pais=" + pais +", lanzamento: " + anoLanzamento;
    }
}
