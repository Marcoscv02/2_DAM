package marcos.videojuegos.model;

import jakarta.persistence.*;

@Entity
public class RequisitosSistema {
    @Id
    private Long idJuego;
    private String almacenamiento;
    private String graphics;
    private String memoria;
    private String os;
    private String Procesador;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idJuego")
    private Juego juego;

    public RequisitosSistema() {
    }

    public RequisitosSistema(Long idJuego, String almacenamiento, String graphics, String memoria, String os, String procesador) {
        this.idJuego = idJuego;
        this.almacenamiento = almacenamiento;
        this.graphics = graphics;
        this.memoria = memoria;
        this.os = os;
        Procesador = procesador;
    }

    public RequisitosSistema(Long idJuego, String almacenamiento, String graphics, String memoria, String os, String procesador, Juego juego) {
        this.idJuego = idJuego;
        this.almacenamiento = almacenamiento;
        this.graphics = graphics;
        this.memoria = memoria;
        this.os = os;
        Procesador = procesador;
        this.juego = juego;
    }

    public Long getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Long idJuego) {
        this.idJuego = idJuego;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProcesador() {
        return Procesador;
    }

    public void setProcesador(String procesador) {
        Procesador = procesador;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
}
