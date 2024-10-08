package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

public class EquipoFileDao implements Dao<Equipo,String>{
    private final File f;

    //Se crea un metodo que pase como parámetro la ruta del archivo de los equipos
    public EquipoFileDao(String ruta){
        this.f=new File(ruta);
    }

    //Se mete en una lista todos los equipo y si el nombre de alguno coincide
    // con el introducido como parametro se devuelve ese equipo
    @Override
    public Equipo get(String nombre) {
        List<Equipo>equipos=getAll();
        for (Equipo e: equipos){
            if (e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }
        return null;
    }

    //Accede al archivo con todos los equipos y los mete en unArraylist
    @Override
    public List<Equipo> getAll() {
        List<Equipo> equipos = new ArrayList<>();
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                while (true) {
                    equipos.add((Equipo) ois.readObject());
                }
            } catch (EOFException e) {
                // Fin del archivo
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error de lectura del archivo.");
            }
        }
        return equipos;
    }

    @Override
    public boolean save(Equipo obxecto) {
        List<Equipo>equipos= getAll();
        equipos.add(obxecto);

        if (f.exists()){
            try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(f))){
                oos.writeObject(obxecto);
                return true;

            } catch (IOException e) {
                System.out.println("Error al guardar el equipo");
            }
        }
        return false;
    }

    //Borra el objeto dentro de la lista si coincide con el introducido como parámetro
    @Override
    public boolean delete(Equipo obx) {
        List<Equipo>equipos=getAll();
        if (f.exists()){
            for (Equipo e: equipos){
                if (e.equals(obx)){
                    equipos.remove(obx);
                    saveAll(equipos);
                    return true;
                }
            }
        }
        return false;
    }

    //Borra el archivo eliminando asi todos sus objetos
    @Override
    public boolean deleteAll() {
        return f.delete();
    }

    //Borra el objeto cuyo nombre coincida con el id introducido como parámetro
    @Override
    public boolean deleteById(String id) {
        List<Equipo>equipos=getAll();

        if (f.exists()){
            for (Equipo e:equipos){
                if (e.getNombre().equalsIgnoreCase(id)){
                    equipos.remove(e);
                    saveAll(equipos);
                }
            }
            return true;
        }
        return false;
    }

    //Actualiza el objeto seleccionado eliminandolo del archivo y reescribiendolo
    @Override
    public void update(Equipo obx) {
        delete(obx);
        save(obx);
    }

    //reescribe todo el fichero
    public void saveAll(List<Equipo>equipos){
        deleteAll();
        for (Equipo e: equipos){
            equipos.add(e);
        }
    }
}
