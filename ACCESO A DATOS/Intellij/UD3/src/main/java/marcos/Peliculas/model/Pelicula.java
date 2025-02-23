package marcos.Peliculas.model;

import jakarta.persistence.*;
import marcos.Peliculas.model.embebidos.DetallePelicula;
import marcos.Peliculas.model.relaciones.PeliculaPersonaxe;

import java.util.Arrays;
import java.util.List;

@Entity
public class Pelicula {
    @Column(length = 10)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;

    @Column(length = 50)
    private String Musica;

    @Column(length = 125)
    private String orixinal;

    @Column(length = 125)
    private String ingles;

    @Column(length = 125)
    private String castelan;

    @Column(length = 50)
    private String xenero;

    @Column(length = 10)
    private Short anoFin;

    @Column(length = 125)
    private String pais;

    @Column(length = 5)
    private Short duracion;

    @Embedded
    private DetallePelicula detallePelicula;

    @Column(length = 12)
    private String cor;

    @Column(length = 6)
    private String son;

    @Column(length = 500)
    private String texto;

    @Lob
    private Byte[] poster;

    @Column(length = 10)
    private String revisado;

    @OneToMany (mappedBy = "pelicula")
    private List<PeliculaPersonaxe> papeles;




    //Constructores
    public Pelicula() {
    }

    public Pelicula(Long idPelicula, String musica, String orixinal, String ingles, String castelan, String xenero, Short anoFin, String pais, Short duracion, String cor, String son, String texto, Byte[] poster, String revisado, List<PeliculaPersonaxe> papeles) {
        this.idPelicula = idPelicula;
        Musica = musica;
        this.orixinal = orixinal;
        this.ingles = ingles;
        this.castelan = castelan;
        this.xenero = xenero;
        this.anoFin = anoFin;
        this.pais = pais;
        this.duracion = duracion;
        this.cor = cor;
        this.son = son;
        this.texto = texto;
        this.poster = poster;
        this.revisado = revisado;
        this.papeles = papeles;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getMusica() {
        return Musica;
    }

    public void setMusica(String musica) {
        Musica = musica;
    }

    public String getOrixinal() {
        return orixinal;
    }

    public void setOrixinal(String orixinal) {
        this.orixinal = orixinal;
    }

    public String getIngles() {
        return ingles;
    }

    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    public String getCastelan() {
        return castelan;
    }

    public void setCastelan(String castelan) {
        this.castelan = castelan;
    }

    public String getXenero() {
        return xenero;
    }

    public void setXenero(String xenero) {
        this.xenero = xenero;
    }

    public Short getAnoFin() {
        return anoFin;
    }

    public void setAnoFin(Short anoFin) {
        this.anoFin = anoFin;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Short getDuracion() {
        return duracion;
    }

    public void setDuracion(Short duracion) {
        this.duracion = duracion;
    }

    void setCor(String cor) {
        this.cor = cor;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Byte[] getPoster() {
        return poster;
    }

    public void setPoster(Byte[] poster) {
        this.poster = poster;
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
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", Musica='" + Musica + '\'' +
                ", orixinal='" + orixinal + '\'' +
                ", ingles='" + ingles + '\'' +
                ", castelan='" + castelan + '\'' +
                ", xenero='" + xenero + '\'' +
                ", anoFin=" + anoFin +
                ", pais='" + pais + '\'' +
                ", duracion=" + duracion +
                ", cor='" + cor + '\'' +
                ", son='" + son + '\'' +
                ", texto='" + texto + '\'' +
                ", poster=" + Arrays.toString(poster) +
                ", revisado='" + revisado + '\'' +
                ", papeles=" + papeles +
                '}';
    }
}
