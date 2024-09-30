package Java.IO.ejerciciosClaseFile;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Ejerc3 {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("1. Crear directorio\n" +
                "2.Listar elementos de un directorio\n" +
                "3.Eliminar un archivo o directorio\n" +
                "4.Mover o renombrar un archivo o directorio\n" +
                "5.salir");

        System.out.println("Elija una de las siguientes opciones:");
        int option= scanner.nextInt();

        switch (option){
            case 1:
                create();
                main(null);
            case 2:
                main(null);
            case 3:
                main(null);
            case 4:
                main(null);
            case 5:
                break;
            default:
                System.out.println("Opción no disponible");
                main(null);
        }
    }

    public static void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del nuevo directorio: ");
        String name = scanner.nextLine();

        // Se inicia JFileChooser indicando que solo muestre Directorios y abriendo una ventana que los muestre
        JFileChooser jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = jfc.showOpenDialog(null);

        // Verificar si se ha seleccionado un directorio o no
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            // Se guarda en la variable dirpath la ruta en la cual crearemos nuestro directorio
            File dirpath = jfc.getSelectedFile();
            File dir = new File(dirpath, name);

            // Intentar crear el directorio
            if (dir.mkdir()) { // Usamos mkdir() para crear el directorio
                System.out.println("Directorio creado correctamente.");
            } else {
                System.out.println("No se ha podido crear el directorio. Puede que ya exista o haya un error.");
            }
        } else {
            System.out.println("No se ha seleccionado ningún directorio.");
        }
    }
}
