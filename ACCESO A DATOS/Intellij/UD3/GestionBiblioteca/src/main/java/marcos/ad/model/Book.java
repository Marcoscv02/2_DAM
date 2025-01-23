package marcos.ad.model;

import jakarta.persistence.*;
import marcos.ad.model.converters.CategotiaConverter;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

@Access(AccessType.FIELD)
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

    @Access(AccessType.PROPERTY)
    public LocalDate getFechaPub_now() {
        // Convertir Calendar a LocalDate
        LocalDate localDatePub = fechaPub.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

        // Calcular la diferencia en días entre fechaPub y la fecha actual
        //fechaPub_now= ChronoUnit.DAYS.between((long)fechaPub, LocalDate.now());
        return fechaPub_now;
    }

    public void setFechaPub_now(LocalDate fechaPub_now) {
        this.fechaPub_now = fechaPub_now;
    }

    public String getIsbn10() {
         isbn10 = isbn.substring(3, isbn.length() - 1);
        System.out.println(isbn10);
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < isbn10.length(); i++) {
            int digit = Character.getNumericValue(isbn10.charAt(i));
            sum = sum.add(BigInteger.valueOf(digit).multiply(BigInteger.valueOf(10 - i)));
        }
        BigInteger remainder = sum.mod(BigInteger.valueOf(11));
        BigInteger controlDigit = BigInteger.valueOf(11).subtract(remainder);

        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    @Override
    public String toString() {
        return "Book: " +
                "["+ idBook +"] "+"isbn:"+ isbn +"\t titulo:"+titulo+"\t"+autor + ", \t fechaPub:" + fechaPub +
                " PublicationDay to now:" + fechaPub_now +" isbn(10): " + isbn10;
    }
}
