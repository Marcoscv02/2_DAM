package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.File;
import java.util.List;

public class ClasificacionFileDao implements Dao<Clasificacion,String>{
    final String ruta="Clasificiacion.dat";
    File fClasificacion= new File(ruta);

    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        return null;
    }

    @Override
    public boolean save(Clasificacion clasificacion) {
        return false;
    }

    @Override
    public boolean delete(Clasificacion obx) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public void update(Clasificacion clasificacion) {
        save(clasificacion);
    }
}
