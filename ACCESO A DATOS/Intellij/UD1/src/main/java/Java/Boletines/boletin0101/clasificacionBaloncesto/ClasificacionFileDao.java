package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.util.List;

public class ClasificacionFileDao implements Dao<Clasificacion,String>{
    String ruta="Clasificiacion.dat";

    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        return List.of();
    }

    @Override
    public boolean save(Clasificacion clasificacion) {
        EquipoFileDao equipoFileDAO = new EquipoFileDao(ruta + clasificacion.getCompeticion() + ".dat");
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
    public void update(Clasificacion obx) {

    }
}
