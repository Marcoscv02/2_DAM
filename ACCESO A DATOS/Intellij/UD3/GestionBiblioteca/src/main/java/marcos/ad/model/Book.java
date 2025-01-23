package marcos.ad.model;

import jakarta.persistence.*;
import marcos.ad.model.converters.CategotiaConverter;

import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;

    private String titulo;
    private String autor;

    @Column(unique = true, length = 13, nullable = false)
    private String isbn;

    @Convert(converter = CategotiaConverter.class)
    private Categoria categoria;

    @Temporal(TemporalType.DATE)
    private Calendar fechaPub;

    @Transient
    private LocalDate fechaPub_now;

    @Transient
    private String isbn10;

    public Book() {
    }

    public Book(String titulo, String autor, String isbn, Calendar fechaPub) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.fechaPub = fechaPub;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Calendar getFechaPub() {
        return fechaPub;
    }

    public void setFechaPub(Calendar fechaPub) {
        this.fechaPub = fechaPub;
    }

    public LocalDate getFechaPub_now() {
        return fechaPub_now;
    }

    public void setFechaPub_now(LocalDate fechaPub_now) {
        this.fechaPub_now = fechaPub_now;
    }

    public String getIsbn10() {

        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", fechaPub=" + fechaPub +
                ", fechaPub_now=" + fechaPub_now +
                ", isbn10='" + isbn10 + '\'' +
                '}';
    }
}
