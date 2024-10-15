package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClasificacionFileDao implements Dao<Clasificacion,String>{
    private final Path ruta;

    public ClasificacionFileDao(String ruta) {
        this.ruta = Paths.get(ruta);
    }

    @Override
    public Clasificacion get(String ruta) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        return null;
    }

    @Override
    public boolean save(Clasificacion clasificacion) {
        EquipoFileDao equipoFileDAO = new EquipoFileDao(ruta.resolve(clasificacion.getCompeticion() + ".dat").toString());
        clasificacion.getEquipos().forEach(equipoFileDAO::save);
        return true;
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
