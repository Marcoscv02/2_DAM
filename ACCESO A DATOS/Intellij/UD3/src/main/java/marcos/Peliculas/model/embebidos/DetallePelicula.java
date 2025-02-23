package marcos.Peliculas.model.embebidos;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class DetallePelicula {
    @Column (length = 5)
    private Short anoInicio;

    @Column(length = 25)
    private String outrasDuracions;

    @Column(length = 2)
    private String video;

    @Column(length = 2)
    private String laserDisc;

    public DetallePelicula() {
    }

    public Short getAnoInicio() {
        return anoInicio;
    }

    public String getOutrasDuracions() {
        return outrasDuracions;
    }

    public String getVideo() {
        return video;
    }

    public String getLaserDisc() {
        return laserDisc;
    }

    @Override
    public String toString() {
        return "detallepelicula{" +
                "anoInicio=" + anoInicio +
                ", outrasDuracions='" + outrasDuracions + '\'' +
                ", video='" + video + '\'' +
                ", laserDisc='" + laserDisc + '\'' +
                '}';
    }
}
