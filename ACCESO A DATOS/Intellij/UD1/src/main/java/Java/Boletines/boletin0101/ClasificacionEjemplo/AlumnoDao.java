package Java.Boletines.boletin0101.ClasificacionEjemplo;

import java.util.List;

//Esta Clase implementa la interfaz DAO, y por tanto debe implementar todos sus métodos
public class AlumnoDao implements Dao<Alumno, String> {

     private List<Alumno> alumnos = List.of(
             new Alumno("Hannah Arendt", "hannaharendt@gmail.com", 23),
                new Alumno("Simone de Beauvoir", "simone@gmail.com", 22),
                new Alumno("Albert Camus", "albertcamus@gmail.com", 21),
                new Alumno("Noam Chomsky", "noamchomsky@gmail.com", 20),
                new Alumno("Michel Foucault", "michelfocault@live.com", 19),
                new Alumno("Martin Heidegger", "elserylanada@live.com", 18),
                new Alumno("Jean-Paul Sartre", "existo@gmail.com", 17),
                new Alumno("Simone Weil", "simone@live.com", 16));



    // Busca un objeto Alumno en la lista 'alumnos' cuyo nombre ('nome') coincida con el valor de 'id'.
    @Override
    public Alumno get(String id) {
        return alumnos.stream().filter(a -> a.getNome().equals(id)).findFirst().orElse(null);
    }

    //genera una lista de todos los alumnos
    @Override
    public List<Alumno> getAll() {
        return alumnos;
    }

    //Guarda un alumno nuevo
    @Override
    public void save(Alumno obxecto) {
        alumnos.add(obxecto);
    }

    //Borra un alumno
    @Override
    public void delete(Alumno obx) {
        alumnos.remove(obx);

    }

    //Actualiza los datos de un alumno
    @Override
    public void update(Alumno obx) {
        Alumno a = get(obx.getNome());
        if (a != null) {
            a.setEmail(obx.getEmail());
            a.setIdade(obx.getIdade());
        }
    }
}
