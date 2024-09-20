package Flujos;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Ex2Main {

    private static ArrayList <Ex2Persona> personas= new ArrayList<>();

    //Metodo para inserir un estudiante
    public static void añadirPersona(){
        //Pide los nombres de las personas
        String nombre = (String) JOptionPane.showInputDialog(null, "Nombre persona 1 ",
                "Introduce nombre persona 1", JOptionPane.QUESTION_MESSAGE);

        //Pide la edad de las personas
        int edad = Integer.parseInt(JOptionPane.showInputDialog(null, "edad persona 1 ",
                "Introduce edad persona 1", JOptionPane.QUESTION_MESSAGE));

        //Creación objetos persona
        Ex2Persona pers1= new Ex2Persona(nombre, edad);

        // Serialización
        try {

            FileOutputStream fileOut = new FileOutputStream("persona.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pers1);
            out.close();
            fileOut.close();
            System.out.println("Objeto serializado guardado en persona.ser");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Método para mostrar todos los estudiantes
    public static void mostrarPersonas(){
        //Deserialización
        try {
            FileInputStream fileIn=new FileInputStream("persona.ser");
            ObjectInputStream in= new ObjectInputStream(fileIn);
            personas = (ArrayList<Ex2Persona>) in.readObject();
            if (personas.isEmpty()){
                JOptionPane.showMessageDialog(null, "No existen personas en el archivo",
                        null, JOptionPane.INFORMATION_MESSAGE);
            }else{

                for (int i = 0; i < personas.size(); i++) {

                }

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //Método para mostrar un estudiante en concreto
    private static void mostrarpersona(){

    }

    public static void main(String[] args) {

        System.out.println("1. Introducir estudiante: ");
        System.out.println("2. Mostrar estudiantes: ");
        System.out.println("3. Mostrar un estudiante: ");
        System.out.println("4. Salir");

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
                main(null);

            case 3:
                main(null);

            case 4:
                break;

            default:
                System.out.println("Debe elegir un número entre 1 y 4");

         JOptionPane.showMessageDialog(null, "Debe elegir un número entre 1 y 4",
                        null, JOptionPane.INFORMATION_MESSAGE);

        }



    }


}
