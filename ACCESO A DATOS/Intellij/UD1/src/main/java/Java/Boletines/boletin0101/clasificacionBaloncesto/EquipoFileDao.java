package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.*;
import java.util.*;


public class EquipoFileDao implements Dao<Equipo,String>{
    private File f;
    Clasificacion clas =new Clasificacion("Liga ACB");

    //Se crea un Constructor que pase como parámetro la ruta del archivo de los equipos
    public EquipoFileDao(String ruta){
        this.f=new File(ruta);
    }

    //Se mete en una lista todos los equipo y si el nombre de alguno coincide
    // con el introducido como parametro se devuelve ese equipo
    @Override
    public Equipo get(String nombre) {
        List<Equipo>clasificacion=getAll();
        for (Equipo e: clasificacion){
            if (e.getNombre().equalsIgnoreCase(nombre)){
                return e;
            }
        }
        return null;
    }

    //Accede al archivo con todos los equipos y los mete en unArraylist
    @Override
    public List<Equipo> getAll() {
        List<Equipo> clasificacion = new ArrayList<>();
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                while (ois.readObject()!=null) {
                    clasificacion.add((Equipo) ois.readObject());
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error de lectura del archivo.");
                System.out.println(e.getMessage());
            }
        }
        Collections.sort(clasificacion);
        return clasificacion;
    }

    @Override
    public boolean save(Equipo obxecto) {
        List<Equipo>clasificacion= getAll();
        obxecto= clas.addEquipo();
        clasificacion.add(obxecto);

        if (f.exists()){
            try (ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(f))){
                oos.writeObject(obxecto);
                return true;

            } catch (IOException e) {
                System.out.println("Error al guardar el equipo");
                System.out.println(e.getMessage());
            }
        }
        return false;
    }

    //Borra el objeto dentro de la lista si coincide con el introducido como parámetro
    @Override
    public boolean delete(Equipo obx) {
        List<Equipo>clasificacion=getAll();
        if (f.exists()){
            for (Equipo e: clasificacion){
                if (e.equals(obx)){
                    clasificacion.remove(obx);
                    saveAll(clasificacion);
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
        List<Equipo>Clasificacion=getAll();

        if (f.exists()){
            for (Equipo e:Clasificacion){
                if (e.getNombre().equalsIgnoreCase(id)){
                    Clasificacion.remove(e);
                    saveAll(Clasificacion);
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
