package ejerciciosClaseFile;

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
    public static void main(String[] args) {
        Scanner scanner1= new Scanner(System.in);
        System.out.println("Elija una de las siguientes opciones:");
        int option= scanner1.nextInt();
        switch (option){
            case 1:
                crear();
                main(null);
            case 2:
                main(null);
            case 3:
                main(null);
            case 4:
                main(null);
            default:
                System.out.println("Opción no disponible");
        }
    }
}
