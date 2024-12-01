package Java.REPASO.Boletin1.ejerc_2;

import javax.swing.*;
import java.io.File;

public class Principal {
    public static void main(String[] args) {
        JFileChooser jfc= new JFileChooser();


        JOptionPane.showMessageDialog(null,"Elige el archivo del que desea saber sus estadísticas");
        if (jfc.showOpenDialog(null)!=JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null,"Operacion cancelada","Candelada", JOptionPane.ERROR_MESSAGE);
            return;
        }
        File archivo=jfc.getSelectedFile();

        EstatisticaFile estFile= new EstatisticaFile(archivo);

        System.out.println("ESTADISTICAS DE ARCHIVO "+archivo.getName());
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Ruta del archivo: "+estFile.getRuta());
        System.out.println("Número de lineas del archivo: "+estFile.getLinhas());
        System.out.println("Número de espacios del archivo: "+estFile.getEspazos());
        System.out.println("Número de letras del archivo: "+estFile.getLetras());
        System.out.println("Fecha última modificación: "+estFile.lastModified());
        System.out.println("Longitud del archivo: "+archivo.length());

    }
}
