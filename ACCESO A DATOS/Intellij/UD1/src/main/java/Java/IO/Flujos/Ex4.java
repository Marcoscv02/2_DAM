package Java.IO.Flujos;

import javax.swing.*;
import java.io.*;
import java.net.URL;

//LEER URL Y GUARDAR EN ARCHIVO
public class Ex4 {
    public static void main(String[] args) throws Exception {

        Object[] option = {"importar paj web", "importar imagen", "seleccion"};
        String s = (String)JOptionPane.showInputDialog(null, "seleccione una opcion ",
                "Elección", JOptionPane.PLAIN_MESSAGE, null, option, "seleccion");

        if (s.equals("importar paj web")){

            //Se guarda la URL de la página
            String strurl = (String) JOptionPane.showInputDialog(null, "introduce una url  de página web",
                    "URL", JOptionPane.QUESTION_MESSAGE);
            URL url= new URL(strurl);

            //Se selecciona donde se quiere guardar la página
            JFileChooser fc= new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setDialogTitle("Indique donde quiere guardar la pagina web");
            fc.showSaveDialog(null);
            File ruta= fc.getSelectedFile();

            //Se guarda la url de tipo página web en un archivo de texto
            try (InputStream is = url.openStream(); FileOutputStream fos = new FileOutputStream(ruta+"/pax.txt")) {
                int byteLeido;
                while ((byteLeido = is.read()) != -1) {
                    fos.write(byteLeido);
                }
            }
        }else if (s.equals("importar imagen")){
            //Se guarda la URL de la imagen
            String strurl = (String) JOptionPane.showInputDialog(null, "introduce una url  de la imagen",
                    "URL", JOptionPane.QUESTION_MESSAGE);
            URL url= new URL(strurl);

            //Se selecciona donde se quiere guardar la imagen
            JFileChooser fc= new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setDialogTitle("Indique donde quiere guardar la imagen");
            fc.showSaveDialog(null);
            File ruta= fc.getSelectedFile();

            //Se guarda la url de tipo imagen en un archivo.png
            try (InputStream is = url.openStream(); FileOutputStream fos = new FileOutputStream(ruta+"/pax.png")) {
                int byteLeido;
                while ((byteLeido = is.read()) != -1) {
                    fos.write(byteLeido);
                }
            }
        }else {
            System.out.println("Opción no válida");
        }
    }
}
