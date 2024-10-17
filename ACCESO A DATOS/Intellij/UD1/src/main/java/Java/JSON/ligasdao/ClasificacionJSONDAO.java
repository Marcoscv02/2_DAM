package Java.JSON.ligasdao;

import com.google.gson.Gson;

import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClasificacionJSONDAO implements Dao<Clasificacion, String> {

    public static final Path DEFAULT_PATH = Paths.get("e:\\data\\");
    public static final Gson gson = new Gson();
    public static ClasificacionJSONDAO instance;
    public static final Clasificacion clasificacion= new Clasificacion();

    private Path ruta;

    public ClasificacionJSONDAO() {
        ruta = DEFAULT_PATH;
    } //Constructor por defecto

    public ClasificacionJSONDAO(Path ruta) {
        this.ruta = ruta;
    } //Constructor con parámetro

    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        List<Equipo>equipos=new ArrayList<>();
        if (Files.exists(ruta)){
            try (var f= Files.newBufferedReader(ruta) ){
                while (true){

                }
            } catch (EOFException eof) {
                // Fin del archivo alcanzado
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return List.of();
    }

    @Override
    public boolean save(Clasificacion obxecto) {
        try(var f= Files.newBufferedWriter(ruta.resolve(clasificacion.getCompeticion()+".json"))) {
            gson.toJson(clasificacion,f);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
