package marcos.Biblioteca.DAOS;

import java.util.List;

/**
 * @author Marcos
 * @param <T> Tipo de dato del objeto
 */
public interface DAO<T> {

    T get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t);

    void delete(T t);

    public boolean deleteById(long id);

    public List<Integer> getAllIds();

    public void updateLOB(T book, String f);

    public void updateLOBById(long id, String f);

    void deleteAll();
}
