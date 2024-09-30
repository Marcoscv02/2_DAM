package Java.IO.ejerciciosClaseFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejerc5 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf= new RandomAccessFile("nums.txt","rw");
        for (int i = 1; i < 11; i++) {
            raf.writeInt(i);
        }
        raf.seek(0);
        for (int i = 0; i < 10; i++) {
            System.out.println(raf.readInt());
        }
        raf.close();
    }
}
