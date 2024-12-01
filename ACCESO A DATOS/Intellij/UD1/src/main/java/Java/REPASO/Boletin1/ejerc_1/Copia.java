package Java.REPASO.Boletin1.ejerc_1;

import javax.swing.*;
import java.io.*;

public class Copia {
    public static void main(String[] args) {
        JFileChooser jfc= new JFileChooser();

        //Obtener archivo de origen
        JOptionPane.showMessageDialog(null,"Seleccione el archivo que desea copiar");
        if (jfc.showOpenDialog(null) != JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null,"Operacion cancelada","Cancelado",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File origen= jfc.getSelectedFile();

        //=btener archivo de destino
        JOptionPane.showMessageDialog(null,"Seleccione la ruta de destino");
        if (jfc.showSaveDialog(null) != JFileChooser.APPROVE_OPTION){
            JOptionPane.showMessageDialog(null,"Operacion guardado cancelada","Guardar",JOptionPane.ERROR_MESSAGE);
            return;
        }
        File destino= jfc.getSelectedFile();

        //Preguntar si se desea sobreesscribir archivo en caso de que exista
        if (destino.exists()){
            int opcion= JOptionPane.showConfirmDialog(null,"¿El archivo de destino ya existe, desea sobreescribirlo?","Sobreesscribir",JOptionPane.YES_NO_OPTION);
            if (opcion==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null,"Operacion cancelada","Cancelado",JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        //Copiar archivo
        try(var br= new BufferedInputStream(new FileInputStream(origen));
            var bw = new BufferedOutputStream(new FileOutputStream(destino))){

            int byteLeido;
            while ((byteLeido = br.read())!=-1){
                bw.write(byteLeido);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
