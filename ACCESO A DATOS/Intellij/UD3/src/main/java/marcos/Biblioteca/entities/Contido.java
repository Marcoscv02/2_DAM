package marcos.Biblioteca.entities;

import java.io.Serializable;

public class Contido implements Serializable {
    private Long idContido;
    private  String contido;
    private Book book;

    public Contido() {
    }

    public Contido(Long idContido, String contido) {
        this.idContido = idContido;
        this.contido = contido;
    }

    public Long getIdContido() {
        return idContido;
    }

    public void setIdContido(Long idContido) {
        this.idContido = idContido;
    }

    public String getContido() {
        return contido;
    }

    public void setContido(String contido) {
        this.contido = contido;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Contido:" +
                "[" + idContido +
                "]\t Book:("+book+") Contido: " + contido;
    }
}
