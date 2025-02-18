package marcos.Biblioteca.entities;

import jakarta.persistence.*;

@Entity
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoto;
    private byte[]foto;


    public Foto() {
    }

    public Foto(Long idFoto, byte[] foto) {
        this.idFoto = idFoto;
        this.foto = foto;
    }
}
