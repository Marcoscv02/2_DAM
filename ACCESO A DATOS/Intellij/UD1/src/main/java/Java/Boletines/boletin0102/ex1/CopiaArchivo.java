package Java.Boletines.boletin0102.ex1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CopiaArchivo {
    public static void main(String[] args) {
        var sc= new Scanner(System.in);

        System.out.println("Introduce ruta de archivo que desea copiar y mover:");
        String intputPath= sc.nextLine();
        Path pathIntput=  Paths.get(intputPath);

        System.out.println("Introcuce la dirección en donde desea copiarlo");
        String outputPath= sc.nextLine();
        Path pathOutput= Paths.get(outputPath);

        System.out.println("Introduce destino del archivo:");
        String movePath= sc.nextLine();
        Path pathMove= Paths.get(movePath);

        //Copiar el archivo
        try {
            Files.copy(pathIntput,pathOutput);
            System.out.println("Archivo copiado a "+outputPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Mover el archivo
        try {
            Files.move(pathIntput, pathMove);
            System.out.println("Archivo movido a "+movePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
