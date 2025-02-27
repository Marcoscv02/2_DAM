package marcos.playlist.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlaylist;
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataCreacion")
    private LocalDate creacion;

    @ManyToMany
    @JoinTable(name = "MediaSong_Playlist",
                joinColumns = @JoinColumn(name = "playlists"),
                inverseJoinColumns = @JoinColumn(name = "canciones"))
    List <MediaSong> canciones;

    public Playlist() {
    }

    public Playlist(Long idPlaylist, String nome, LocalDate creacion, List<MediaSong> canciones) {
        this.idPlaylist = idPlaylist;
        this.nome = nome;
        this.creacion = creacion;
        this.canciones = canciones;
    }

    public Long getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(Long idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public List<MediaSong> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<MediaSong> canciones) {
        this.canciones = canciones;
    }
}
