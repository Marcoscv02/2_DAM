package ejerciciosClaseFile;

import javax.swing.*;
import java.io.File;

public class Ejerc2 {
    public static void main(String[] args) {
        //Se inicia JFile chooser indicando que solo muestre Directorios y abriendo una ventana que los muestre
        JFileChooser jfChooser= new JFileChooser();
        jfChooser.setFileSelectionMode(jfChooser.DIRECTORIES_ONLY);
        jfChooser.showOpenDialog(null);
        //Se crea el objeto directiro que sera la carpeta seleccionada en la ventana
        File directorio= jfChooser.getSelectedFile();
        //Se genera un array con todos los archivos en esa carpeta
        File [] archivos= directorio.listFiles();

        for (File archivo:archivos){
            System.out.println("Nombre de archivo: "+archivo.getName()+" "+archivo.getTotalSpace()+" "+(archivo.isDirectory() ? "Directorio" : "Archivo"));
        }
    }
}

