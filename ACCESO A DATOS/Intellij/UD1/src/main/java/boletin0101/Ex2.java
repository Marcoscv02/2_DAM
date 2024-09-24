package boletin0101;

import javax.swing.*;
import java.io.*;
import java.util.Date;

public class Ex2 {
    public static void main(String[] args) throws IOException {
        var jfc= new JFileChooser();

        JOptionPane.showMessageDialog(null, "Seleccione fichero que desea abrir");
        jfc.showOpenDialog(null);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        File selectFile= jfc.getSelectedFile();

        //Se declaran fileReader y BufferedReader
        var fr= new FileReader(selectFile);
        var br= new BufferedReader(fr);

        //Se inicia el contador de lineas a 0
        int cont=0;
        while (br.readLine()!=null){
            cont++;
        }
        // Cerrar el primer FileReader
        br.close();
        fr.close();

        // Segundo FileReader para contar caracteres
        var fr2 = new FileReader(selectFile);
        int contChar = 0;

        while (fr2.read() != -1) {
            contChar++;
        }
        fr2.close();

        System.out.println("***DATOS DE ARCHIVO***");
        System.out.println("Nombre de archivo: "+selectFile.getName());
        System.out.println("Ruta archivo: "+selectFile.getPath());
        System.out.println("Longitud del archivo: "+selectFile.getTotalSpace());
        System.out.println("Fecha última modificación: "+ new Date(selectFile.lastModified()));
        System.out.println("Num lineas: "+cont);
        System.out.println("Num de caracteres: "+contChar);

    }
}
