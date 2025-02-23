package marcos.Peliculas.model;

import jakarta.persistence.*;
import marcos.Peliculas.model.relaciones.PeliculaPersonaxe;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Personaxe {
    @Column(length = 10)
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idPersonaxe;

    @Column(length = 16)
    private String importancia;
    @Column(length = 125)
    private String nome;
    @Column(length = 125)
    private String nomeOrdenado;
    @Column(length = 125)
    private String nomeOrixinal;
    @Column(length = 6)
    private String sexo;
    @Temporal(TemporalType.DATE)
    private LocalDate dataNacemento;
    @Column(length = 125)
    private String paisNacemento;
    @Column(length = 125)
    private String cidadeNacemento;
    @Temporal(TemporalType.DATE)
    private LocalDate dataDefuncion;
    @Column(length = 125)
    private String paisDefuncion;
    @Column(length = 125)
    private String cidadeDefuncion;
    private Character estudo;
    private Character bio;
    @Column(length = 500)
    private String texto;
    @Column(length = 500)
    private String textoFilmografia;
    @Column(length = 10)
    private String revisado;

    @OneToMany (mappedBy = "personaxe")
    private List<PeliculaPersonaxe> papeles;



    //constructores
    public Personaxe() {
    }

    public Personaxe(Long idPersonaxe, String importancia, String nome, String nomeOrdenado, String nomeOrixinal, String sexo, LocalDate dataNacemento, String paisNacemento, String cidadeNacemento, LocalDate dataDefuncion, String paisDefuncion, String cidadeDefuncion, Character estudo, Character bio, String texto, String textoFilmografia, String revisado, List<PeliculaPersonaxe> papeles) {
        this.idPersonaxe = idPersonaxe;
        this.importancia = importancia;
        this.nome = nome;
        this.nomeOrdenado = nomeOrdenado;
        this.nomeOrixinal = nomeOrixinal;
        this.sexo = sexo;
        this.dataNacemento = dataNacemento;
        this.paisNacemento = paisNacemento;
        this.cidadeNacemento = cidadeNacemento;
        this.dataDefuncion = dataDefuncion;
        this.paisDefuncion = paisDefuncion;
        this.cidadeDefuncion = cidadeDefuncion;
        this.estudo = estudo;
        this.bio = bio;
        this.texto = texto;
        this.textoFilmografia = textoFilmografia;
        this.revisado = revisado;
        this.papeles = papeles;
    }



    //getter y Setter
    public Long getIdPersonaxe() {
        return idPersonaxe;
    }

    public void setIdPersonaxe(Long idPersonaxe) {
        this.idPersonaxe = idPersonaxe;
    }

    public String getImportancia() {
        return importancia;
    }

    public void setImportancia(String importancia) {
        this.importancia = importancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeOrdenado() {
        return nomeOrdenado;
    }

    public void setNomeOrdenado(String nomeOrdenado) {
        this.nomeOrdenado = nomeOrdenado;
    }

    public String getNomeOrixinal() {
        return nomeOrixinal;
    }

    public void setNomeOrixinal(String nomeOrixinal) {
        this.nomeOrixinal = nomeOrixinal;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getPaisNacemento() {
        return paisNacemento;
    }

    public void setPaisNacemento(String paisNacemento) {
        this.paisNacemento = paisNacemento;
    }

    public String getCidadeNacemento() {
        return cidadeNacemento;
    }

    public void setCidadeNacemento(String cidadeNacemento) {
        this.cidadeNacemento = cidadeNacemento;
    }

    public LocalDate getDataDefuncion() {
        return dataDefuncion;
    }

    public void setDataDefuncion(LocalDate dataDefuncion) {
        this.dataDefuncion = dataDefuncion;
    }

    public String getPaisDefuncion() {
        return paisDefuncion;
    }

    public void setPaisDefuncion(String paisDefuncion) {
        this.paisDefuncion = paisDefuncion;
    }

    public String getCidadeDefuncion() {
        return cidadeDefuncion;
    }

    public void setCidadeDefuncion(String cidadeDefuncion) {
        this.cidadeDefuncion = cidadeDefuncion;
    }

    public Character getEstudo() {
        return estudo;
    }

    public void setEstudo(Character estudo) {
        this.estudo = estudo;
    }

    public Character getBio() {
        return bio;
    }

    public void setBio(Character bio) {
        this.bio = bio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTextoFilmografia() {
        return textoFilmografia;
    }

    public void setTextoFilmografia(String textoFilmografia) {
        this.textoFilmografia = textoFilmografia;
    }

    public String getRevisado() {
        return revisado;
    }

    public void setRevisado(String revisado) {
        this.revisado = revisado;
    }

    public List<PeliculaPersonaxe> getPapeles() {
        return papeles;
    }

    public void setPapeles(List<PeliculaPersonaxe> papeles) {
        this.papeles = papeles;
    }

    @Override
    public String toString() {
        return "Personaxe{" +
                "idPersonaxe=" + idPersonaxe +
                ", importancia='" + importancia + '\'' +
                ", nome='" + nome + '\'' +
                ", nomeOrdenado='" + nomeOrdenado + '\'' +
                ", nomeOrixinal='" + nomeOrixinal + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dataNacemento=" + dataNacemento +
                ", paisNacemento='" + paisNacemento + '\'' +
                ", cidadeNacemento='" + cidadeNacemento + '\'' +
                ", dataDefuncion=" + dataDefuncion +
                ", paisDefuncion='" + paisDefuncion + '\'' +
                ", cidadeDefuncion='" + cidadeDefuncion + '\'' +
                ", estudo=" + estudo +
                ", bio=" + bio +
                ", texto='" + texto + '\'' +
                ", textoFilmografia='" + textoFilmografia + '\'' +
                ", revisado='" + revisado + '\'' +
                ", papeles=" + papeles +
                '}';
    }
}
