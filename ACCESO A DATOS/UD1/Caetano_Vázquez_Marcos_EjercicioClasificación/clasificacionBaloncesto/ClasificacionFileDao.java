package Java.Boletines.boletin0101.clasificacionBaloncesto;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class ClasificacionFileDao implements Dao<Equipo,String>{
    private final Path ruta;

    //Se crea un Constructor que pase como parámetro la ruta del archivo de los equipos
    public ClasificacionFileDao(String ruta){
        this.ruta= Paths.get(ruta);
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
        List<Equipo> clasificacion = new ArrayList<>(); //Creacion de un nuevo arraylist
        //Si el archivo no existe se crea uno nuevo
        if (!Files.exists(ruta)){
            try {
                Files.createFile(ruta);
            } catch (IOException e) {
                System.out.println("Error en la creacion del archivo");
                throw new RuntimeException(e);
            }
        }
        //Si el archivo existe se lee a traves de un objectIntpuStream y se mete dentro del array creado anteriormente
        if (Files.exists(ruta)) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta.toFile()))) {
                while (true) {
                    clasificacion.add((Equipo) ois.readObject());
                }
            } catch (EOFException eof) {
                // Fin del archivo alcanzado
            }catch (IOException | ClassNotFoundException e) {
                System.out.println("Error de lectura del archivo.");
                System.out.println(e.getMessage());
            }
            System.out.println("Archivo cargado con éxito");//Manda mensaje de exito si el archivo se carga
            Collections.sort(clasificacion);  // Ordenar usando el metodo compareTo de Equipo
            return clasificacion;
        }else {
            System.out.println("Problema al cargar el archivo (método getall())");
            return null;//Si el proceso falla retorna null
        }
    }

    @Override
    public boolean save(Equipo obxecto) {
        // Comprobamos si el archivo ya existe para saber si debemos usar "append"
        boolean append = Files.exists(ruta);

        try (FileOutputStream fos = new FileOutputStream(ruta.toFile(), append)) {
            // Usamos ObjectOutputStream solo si el archivo es nuevo (sin cabecera previa)
            if (!append) {
                try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(obxecto);
                }
            } else {
                // Si el archivo ya existe (modo append), escribimos sin la cabecera
                try (ObjectOutputStream oos = new ObjectOutputStream(fos) {
                    @Override
                    protected void writeStreamHeader() throws IOException {
                        reset();  // Evitamos escribir una nueva cabecera
                    }
                }) {
                    oos.writeObject(obxecto);
                }
            }
            System.out.println("Elemento guardado con éxito");
            return true;
        } catch (IOException e) {
            System.out.println("Error al guardar el equipo");
            e.printStackTrace();
            return false;
        }
    }

    //Borra el objeto dentro de la lista si coincide con el introducido como parámetro
    @Override
    public boolean delete(Equipo obx) {
        List<Equipo>clasificacion=getAll();//LLamada al método getAll()

        if (Files.exists(ruta)){
            for (Equipo e: clasificacion){
                if (e.equals(obx)){
                    clasificacion.remove(obx);
                    saveAll(clasificacion);
                    System.out.println("Elemento borrado con éxito");
                    return true;
                }
            }
        }else {
            System.out.println("Error en el borrado del archivo método delete()");
        }
        return false;
    }

    //Borra el archivo eliminando asi todos sus objetos
    @Override
    public boolean deleteAll() {
        try {
            Files.deleteIfExists(ruta);
            return true;
        } catch (IOException e) {
            System.out.println("Error al borrar el archivo");
            throw new RuntimeException(e);
        }
    }

    //Borra el objeto cuyo nombre coincida con el id introducido como parámetro
    @Override
    public boolean deleteById(String id) {
        List<Equipo>Clasificacion=getAll(); //LLamada al método getAll()

        //Comprueba si el archivo existe
        if (Files.exists(ruta)){
            for (Equipo e:Clasificacion){
                if (e.getNombre().equalsIgnoreCase(id)){
                    Clasificacion.remove(e);
                    saveAll(Clasificacion);
                }
            }
            System.out.println("Elemento eliminado con éxito");
            return true;
        }
        System.out.println("Error al eliminar archivo método deleteByID()");
        return false;
    }

    //Actualiza el objeto seleccionado eliminandolo del archivo y reescribiendolo
    @Override
    public void update(Equipo obx) {
        delete(obx); //Llamada al método delete
        save(obx); //LLamada al método save
        System.out.println("Operacion realizada con éxito");
    }

    //reescribe todo el fichero
    public boolean saveAll(List<Equipo>equipos){
        deleteAll(); //LLamada al método deleteAll()
        for (Equipo e: equipos){
            save(e);
        }
        return true;
    }

}
