package Java.Boletines.boletin0101;

import java.io.*;

public class Ex1 {
    public static void main(String[] args) {
        try(
            //Se Crean Buffered para entrada y salida de bytes
            BufferedInputStream bi= new BufferedInputStream(new FileInputStream("pom.xml"));
            BufferedOutputStream bo= new BufferedOutputStream(new FileOutputStream("copia.xml"));){

            byte [] b= new byte[1024]; //Se crea un array de Bytes con el tamaño mas  adecuado al tamaño del carchivo que vamos a copiar

            while (bi.read()!=-1){
                bo.write(b); //Se meten los bytes del Array en el Buffered de salida
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
