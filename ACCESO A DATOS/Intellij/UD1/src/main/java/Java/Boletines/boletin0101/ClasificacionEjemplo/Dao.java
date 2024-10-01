package Java.Boletines.boletin0101.ClasificacionEjemplo;

import java.util.List;

/**
 * Interfaz genérica Dao (Data Access Object) para operaciones CRUD.
 *
 * <p>Esta interfaz define los métodos estándar para realizar operaciones
 * de Crear, Leer, Actualizar y Eliminar (CRUD) en una fuente de datos.</p>
 *
 * @param <T> El tipo de objeto de dominio que este DAO manejará
 * @param <K> El tipo de la clave primaria del objeto de dominio
 */
public interface Dao <T, K> {

    /* Método para obtener un objeto por su identificador T es el
    tipo de objeto que se devuelve, K es el tipo del identificador*/
    T get(K id);

    /*Método para obtener todos los objetos
    Devuelve una lista de objetos de tipo T*/
    List<T> getAll();

    /*Método para guardar un nuevo objeto
    Recibe un objeto de tipo T como parámetro*/
    void save(T obxecto);

    /*Método para eliminar un objeto
    Recibe el objeto a eliminar como parámetro*/
    void delete(T obx);

    /*Método para actualizar un objeto existente
       Recibe el objeto actualizado como parámetro*/
    void update(T obx);
}