package marcos.playlist.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class MediaSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCancion;
    private String titulo;
    private String autor;
    private Integer duracion;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPublicacion")
    private LocalDate publicacion;
    private MediaSong audio;

    @ManyToMany (mappedBy = "canciones")
    List <Playlist> playlists;


    public MediaSong() {
    }

    public MediaSong(Long idCancion, String titulo, String autor, Integer duracion, LocalDate publicacion, MediaSong audio, List<Playlist> playlists) {
        this.idCancion = idCancion;
        this.titulo = titulo;
        this.autor = autor;
        this.duracion = duracion;
        this.publicacion = publicacion;
        this.audio = audio;
        this.playlists = playlists;
    }


    public Long getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Long idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public LocalDate getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(LocalDate publicacion) {
        this.publicacion = publicacion;
    }

    public MediaSong getAudio() {
        return audio;
    }

    public void setAudio(MediaSong audio) {
        this.audio = audio;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
