package Java.Boletines.boletin0101.ClasificacionEjemplo;

import java.io.*;
import java.util.List;

public class AlumnoDaoFromFile implements Dao<Alumno, String> {

    // Variable para almacenar el archivo desde el cual se leerán/escribirán los datos
    private File file;

    // Constructor que recibe la ruta del archivo y lo asigna a la variable 'file'
    public AlumnoDaoFromFile(String file) {
        this.file = new File(file);
    }
    //Este metodo accede al archivo con los alumnos insertando como parametro un idy devuelve el objeto alumno especificado si lo encuentra
    @Override
    public Alumno get(String id) {
        Alumno al = null;  // Variable para almacenar el alumno encontrado
        ObjectInputStream ois = null;  // Flujo de entrada para leer objetos desde un archivo

        try {
            // Inicializamos el flujo de entrada de objetos, leyendo desde el archivo especificado
            ois = new ObjectInputStream(new FileInputStream(file));

            // Leemos el archivo secuencialmente hasta encontrar el alumno con el nombre que coincide con 'id'
            while (true) {
                // Leemos un objeto Alumno del archivo
                al = (Alumno) ois.readObject();

                // Si el nombre del alumno coincide con el 'id', devolvemos el alumno encontrado
                if (al.getNome().equals(id)) {
                    return al;
                }
            }
        } catch (EOFException e) {
            // EOFException se lanza cuando llegamos al final del archivo
            // Aquí no hacemos nada porque significa que no hemos encontrado el alumno
        } catch (IOException | ClassNotFoundException e) {
            // Si ocurre algún error de E/S o de clase, lo imprimimos en la consola
            System.out.println("Erro: " + e);
        } finally {
            // Cerramos el flujo de entrada si no es nulo para evitar fugas de recursos
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Si llegamos aquí, significa que no se encontró el alumno, devolvemos 'al' (que será null)
        return al;
    }

    @Override
    public List<Alumno> getAll() {
        return List.of();  // Retorna una lista vacía como valor por defecto
    }

    @Override
    public void save(Alumno obxecto) {
    }

    @Override
    public void delete(Alumno obx) {
    }

    @Override
    public void update(Alumno obx) {
    }
}