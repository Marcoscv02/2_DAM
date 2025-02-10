package marcos.videojuegos.model;

import jakarta.persistence.*;

@Entity
public class Imagen {
    @Id
    private Long IdImagen;
    private String urlImage;
    private Byte[] image;

    @ManyToOne
    @JoinColumn(name = "imagenes")
    private Long idJuego;

    public Imagen() {
    }

    public Imagen(Long idImagen, String urlImage, Byte[] image) {
        IdImagen = idImagen;
        this.urlImage = urlImage;
        this.image = image;
    }

    public Imagen(Long idImagen, String urlImage, Byte[] image, Long idJuego) {
        IdImagen = idImagen;
        this.urlImage = urlImage;
        this.image = image;
        this.idJuego = idJuego;
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

    public Long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }
}
