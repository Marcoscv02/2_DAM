package ejerciciosClaseFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejerc4 {
    public static void main(String[] args) throws IOException {
        try {
            RandomAccessFile raf = new RandomAccessFile("prueba.txt", "rw");
            raf.writeUTF("Hola, mundo!");
            raf.seek(0);
            System.out.println(raf.readUTF());
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
