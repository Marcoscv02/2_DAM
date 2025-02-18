package marcos.Biblioteca.DAOS;

import marcos.Biblioteca.entities.Book;

import java.util.List;

public class BookDaoFactory implements DAO<Book> {

    public enum TipoDao {
    JDBC_H2, JPA_H2, JPA_POSTGRES, HIBERNATE, JSON, JDBC_POSTGRES;
    }

    public static DAO<Book> getBookDAO(TipoDao tipo) {
        switch (tipo) {
            // ..
        }
        return null;
    }

    @Override
    public Book get(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return List.of();
    }

    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public List<Integer> getAllIds() {
        return List.of();
    }

    @Override
    public void updateLOB(Book book, String f) {

    }

    @Override
    public void updateLOBById(long id, String f) {

    }

    @Override
    public void deleteAll() {

    }


}
