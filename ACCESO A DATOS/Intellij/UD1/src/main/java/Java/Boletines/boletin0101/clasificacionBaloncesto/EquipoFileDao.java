package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class EquipoFileDao implements Dao<Equipo,String>{
    Equipo equipo=null;

    File f=new File("Equipos.dat");

   ArrayList<Equipo>equipos= new ArrayList<>();


    @Override
    public Equipo get(String id) {
        return null;
    }

    @Override
    public List<Equipo> getAll() {
        try (ObjectInputStream ois= new ObjectInputStream(new FileInputStream(f))){
            while (true){
                equipos.add(equipo);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return equipos;
    }

    @Override
    public boolean save(Equipo obxecto) {
        return false;
    }

    @Override
    public boolean delete(Equipo obx) {
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
    public void update(Equipo obx) {

    }
}
