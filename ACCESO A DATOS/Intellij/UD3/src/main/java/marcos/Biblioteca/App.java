package marcos.Biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import marcos.Biblioteca.entities.Book;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf= BibliotecaJpaManager.getEntityManagerFactory(BibliotecaJpaManager.BIBLIOTECA_H2);

        EntityManager manager = emf.createEntityManager();

        var lista= manager.createQuery("SELECT b  FROM Book b").getResultList();

        var libro= manager.find(Book.class, 1L );

        System.out.println(libro.toString());
        System.out.println("Fuciona");

    }
}
