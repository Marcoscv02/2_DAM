package Java.IO.Flujos;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Ex2Main {
    // Lista para almacenar las personas en memoria
    public static ArrayList<Ex2Persona> personas = new ArrayList<>();
    // Nombre del archivo para guardar/cargar los datos
    public static final String archivo = "personas.dat";

    //Metodo para inserir un estudiante
    public static void añadirPersona(){
        //Pide nombre de la persona
        String nombre = (String) JOptionPane.showInputDialog(null, "Nombre persona 1 ", "Introduce nombre persona 1", JOptionPane.QUESTION_MESSAGE);

        //Pide la edad la persona
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "edad persona 1 ", "Introduce edad persona 1", JOptionPane.QUESTION_MESSAGE));

        //Creación objeto persona
        Ex2Persona pers= new Ex2Persona(nombre, edad);

        // Serialización
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(pers);
            JOptionPane.showMessageDialog(null, "persona guardada correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la persona: " + e.getMessage());
        }
    }

    // Método para mostrar todas las personas
    public static void mostrarPersonas() {

        //LLama al método cargar personas para tener todos los objetos de tipo persona en un array
        cargarPersonas();
        //Si el Array esta vacío muestra un mensaje diciendolo
        if (personas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay personas registradas.",
                    "Mostrar Personas", JOptionPane.INFORMATION_MESSAGE);
            //Sinó imprime cada persona por consola
        } else {
            StringBuilder mensaje= null;
            for (Ex2Persona persona : personas) {
                mensaje.append(persona.toString()+"\n");
            }
            JOptionPane.showMessageDialog(null, "Alumnos:\n"+mensaje,
                    "Mostrar Personas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para cargar las personas desde un archivo (deserialización)
    public static ArrayList<Ex2Persona> cargarPersonas() {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            // Se genera un bucle en el que se leen del archivo todos los objetos de tipo persona y se meten en un array
            while (true) {
                try {
                    Ex2Persona pers = (Ex2Persona) in.readObject();
                    personas.add(pers);
                } catch (EOFException e) {
                    break; // Fin del archivo
                }
            }
        } catch (FileNotFoundException e) {
            // Si el archivo no existe, se muestra un mensaje de error
            JOptionPane.showMessageDialog(null, "No existen datos en el fichero: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return personas;
    }

    //Método para mostrar un estudiante en concreto
    public static void buscarPersona() {
        // Cargar las personas desde el archivo
        cargarPersonas();
        String nombreBuscar = JOptionPane.showInputDialog(null, "Introduce el nombre de la persona a buscar:",
                "Buscar Persona", JOptionPane.QUESTION_MESSAGE);
        //Se inicia la variable encontrada a False por defecto, y se convertira en true si se encuentra el nombre
        boolean encontrada = false;
        // Buscar la persona en la lista
        for (Ex2Persona persona : personas) {
            if (persona.getNombre().equals(nombreBuscar)) {
                JOptionPane.showMessageDialog(null, "Persona encontrada:\n" + persona.toString(),
                        "Buscar Persona", JOptionPane.INFORMATION_MESSAGE);
                encontrada = true;
                break;
            }
        }
        // Mostrar mensaje si no se encuentra la persona
        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "No se encontró ninguna persona con ese nombre.",
                    "Buscar Persona", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,
                "1. Introducir estudiante: \n" +
                        "2. Mostrar estudiantes: \n" +
                        "3. Mostrar un estudiante: \n" +
                        "4. Salir" ,
                "seleccione una opcion",
                JOptionPane.INFORMATION_MESSAGE);
        int option = Integer.parseInt( JOptionPane.showInputDialog(null, "Seleccione una opción",
                null, JOptionPane.QUESTION_MESSAGE));

        switch (option){
            case 1:
                añadirPersona();
                main(null);
            case 2:
                mostrarPersonas();
                main(null);
            case 3:
                buscarPersona();
                main(null);
            case 4:
                System.exit(0);
            default:
         JOptionPane.showMessageDialog(null, "Debe elegir un número entre 1 y 4",
                        null, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
