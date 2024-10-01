package Java.Boletines.boletin0101.ClasificacionEjemplo;

import java.io.File;
import java.util.List;

public class AlumnoDao implements Dao<Alumno, String>{
    private File f;

    public AlumnoDao(File f) {
        this.f = f;
    }

    @Override
    public Alumno get(String id) {
        return null;
    }

    @Override
    public List<Alumno> getAll() {
        return List.of();
    }

    @Override
    public void save(Alumno obxecto) {

    }

    @Override
    public void delete(Alumno obx) {
        Alumno a= a.re
    }

    @Override
    public void update(Alumno obx) {

    }
}
