package boletin0101;

import java.io.File;

public class Ex3Documento {
    File archivo;

    //Constructor que recoje un nombre de archivo y crea un objetode tipo File
    public Ex3Documento(String nombreArchivo){
        File archivo= new File(nombreArchivo);
    }
    //Constructor que recoje un objeto de tipo file
    public Ex3Documento(File archivo) {
        this.archivo = archivo;
    }

    public File existe(File archivo){
        
    }
}
