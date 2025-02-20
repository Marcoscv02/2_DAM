package marcos.mapeoVideoJuegos.model;

import jakarta.persistence.*;

@Entity
public class Imagen {
    @Id
    private Long IdImagen;
    private String urlImage;
    @Lob
    private Byte[] image;

    @ManyToOne
    @JoinColumn(name = "imagenes")
    private Juego juego;

    public Imagen() {
    }

    public Imagen(Long idImagen, String urlImage, Byte[] image) {
        IdImagen = idImagen;
        this.urlImage = urlImage;
        this.image = image;
    }

    public Imagen(Long idImagen, String urlImage, Byte[] image, Juego idJuego) {
        IdImagen = idImagen;
        this.urlImage = urlImage;
        this.image = image;
        this.juego = idJuego;
    }

    public Long getIdImagen() {
        return IdImagen;
    }

    public void setIdImagen(Long idImagen) {
        IdImagen = idImagen;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
