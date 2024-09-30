package Java.Boletines.boletin0101;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

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


    //Metodo para saber si el archivo existe
    public boolean existe() {
        return archivo.exists();
    }


    //Metodo para leer el Archivo y meterlo en un StringBuilder
    public StringBuilder readFile() throws IOException {
        //Declaracion de variables del método
        StringBuilder sb= new StringBuilder();
        FileReader fr = new FileReader(String.valueOf(new FileInputStream(archivo)));

        //Si el archivo existe lee el archivo y lo mete en un stringbuilder, si no existe manda un mensaje
        if (archivo.exists()) {
            int letra;
            while ((letra = fr.read()) != -1) {
                sb.append(letra);
            }
            return sb;
        }else {
            return new StringBuilder("archivo no encontrado");
        }
    }

    public  String readFileNIO () {
        StringBuilder sb= new StringBuilder();

        if (!existe()) return null;

        try {
            return Files.readString(archivo.toPath().forEach(sb::append));
            return sb.toString();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
