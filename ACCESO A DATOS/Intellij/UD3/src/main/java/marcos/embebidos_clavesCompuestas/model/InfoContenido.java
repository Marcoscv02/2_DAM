package marcos.embebidos_clavesCompuestas.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class InfoContenido {
    private String titulo;
    private String genero;
    private String pais;
    private Integer duracion; //en minutos
    private Integer anho;
    private String sinopsis;

    public InfoContenido() {
    }

    public InfoContenido(String titulo, String genero, String pais, Integer duracion, Integer anho, String sinopsis) {
        this.titulo = titulo;
        this.genero = genero;
        this.pais = pais;
        this.duracion = duracion;
        this.anho = anho;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "InfoContenido{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", pais='" + pais + '\'' +
                ", duracion=" + duracion +
                ", anho=" + anho +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}
