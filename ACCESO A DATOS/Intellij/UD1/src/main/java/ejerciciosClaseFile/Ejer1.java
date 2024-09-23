package ejerciciosClaseFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Ejer1 {

    public static void main(String[] args) throws IOException {


        Scanner scanner= new Scanner(System.in);

        System.out.println("Introduce nombre del archivo");
        String nombre= scanner.nextLine();

        File f=new File(nombre);

        if (f.exists()==true){
            System.out.println(f.getAbsolutePath());
            System.out.println(f.getName());
            System.out.println("Tamaño "+ f.getTotalSpace());
            System.out.println("Última modificación "+ new Date(f.lastModified()));
            System.out.println("Es un directorio: "+ f.isDirectory());
        }else {
            //f.createNewFile();
            System.out.println("El archivo no existe");
        }




/*
        JFileChooser fc= new JFileChooser("c:/");

        if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            System.out.println(f.getAbsolutePath());
        }

        File[] files= File.listRoots();
        for ( File a: files){
            System.out.println("- "+a);
        }

*/



        //fc.showSaveDialog(null);
    }
}
