package marcos.elementosEmbebidos.model;

import jakarta.persistence.*;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    @Embedded
    private InfoContenido informacion;

    public Pelicula() {
    }

    public Pelicula(Long idPelicula, InfoContenido informacion) {
        this.idPelicula = idPelicula;
        this.informacion = informacion;
    }

    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public InfoContenido getInformacion() {
        return informacion;
    }

    public void setInformacion(InfoContenido informacion) {
        this.informacion = informacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", informacion=" + informacion +
                '}';
    }
}
