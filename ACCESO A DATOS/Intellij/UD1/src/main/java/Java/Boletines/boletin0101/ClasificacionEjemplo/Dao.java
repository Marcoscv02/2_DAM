package Java.Boletines.boletin0101.ClasificacionEjemplo;

import java.util.List;

/**
 * Dao genérico.
 * Esta clase define los métodos que deben implementar las clases que quieran
 * ser un Dao.
 * La T es el tipo de objeto que se va a manejar y la K es el tipo de clave
 * primaria.
 * @param <T>
 * @param <K>
 */
public interface Dao <T, K> {

    // Devuelve un objeto de tipo T utilizando la clave primaria K.
    // Si no se encuentra el objeto, puede devolver null.
    T get(K id);

    // Devuelve una lista de todos los objetos de tipo T en la base de datos.
    List<T> getAll();

    // Guarda un nuevo objeto de tipo T en la base de datos.
    void save(T obxecto);

    // Elimina un objeto de tipo T de la base de datos.
    void delete(T obx);

    // Actualiza un objeto de tipo T existente en la base de datos.
    void update(T obx);
}
