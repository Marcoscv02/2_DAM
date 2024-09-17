package ejerciciosClaseFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejerc3 {
    Scanner scanner=new Scanner(System.in);
    File f;
    public static void crear (){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo que se desee crear");
        String name= scanner.nextLine();
        File f= new File(name);

        if (f.exists()){
            System.out.println("El archivo ya existe");
        }else {
            try {
                f.createNewFile();
            } catch (IOException e) {
                System.out.println("Error en la creación del archivo");
                throw new RuntimeException(e);
            }
        }
    }

    /*public static String listar(File directory, int depth) {
        StringBuilder sb= new StringBuilder();
        File [] filer

    }*/

    public static void eliminar() {
        //Se inicia JFile chooser indicando que solo muestre Directorios y abriendo una ventana que los muestre
        JFileChooser jfChooser = new JFileChooser();
        jfChooser.showDialog(null,"delete");
        //Se crea el objeto directorio que será la carpeta seleccionada en la ventana
        File elemento = jfChooser.getSelectedFile();
        //Se genera un array con todos los archivos en esa carpeta
        elemento.delete();

        if (elemento.exists()==false){
            System.out.println("Elemento eliminado correctamente");
        }else{
            System.out.println("El elemento no ha podido ser eliminado o no existía previamente");
        }
    }

    public static void main(String[] args) {
        Scanner scanner1= new Scanner(System.in);
        System.out.println("1. Crear archivo\n" +
                "2.Listar elementos de un directorio\n" +
                "3.Eliminar un archivo o directorio\n" +
                "4.Mover o renombrar un archivo o directorio\n" +
                "5.salir");

        System.out.println("Elija una de las siguientes opciones:");
        int option= scanner1.nextInt();

        switch (option){
            case 1:
                crear();
                main(null);
            case 2:
                //listar();
                main(null);
            case 3:
                eliminar();
                main(null);
            case 4:
                main(null);
            case 5:
                break;
            default:
                System.out.println("Opción no disponible");
        }
    }
}
