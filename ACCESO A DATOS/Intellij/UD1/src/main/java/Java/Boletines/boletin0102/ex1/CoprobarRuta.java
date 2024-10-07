package Java.Boletines.boletin0102.ex1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CoprobarRuta {
    public static void main(String[] args) {
        var sc= new Scanner(System.in);
        System.out.println("Introduce ruta del archivo:");
        String intputPath= sc.nextLine();
        Path path= Paths.get(intputPath);

        //Comprobar si la ruta es absoluta o relativa
        if (path.isAbsolute()){
            System.out.println("La ruta es absoluta");
        }else {
            System.out.println("La ruta es relativa");
        }

        //Comprobar si el archivo existe
        if (Files.exists(path)){
            System.out.println("El archivo existe");
        }else {
            System.out.println("El archivo no existe");
        }
    }
}
