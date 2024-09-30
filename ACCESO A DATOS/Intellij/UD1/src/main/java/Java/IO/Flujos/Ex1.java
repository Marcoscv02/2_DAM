package Java.IO.Flujos;

import java.io.*;

public class Ex1 {
    public static void main(String[] args) {
        // Try-with-resources para que los recursos se cierren automáticamente
        try (FileReader in = new FileReader("marcos.txt");
             FileWriter out = new FileWriter("hello.txt")) {

            int c;
            // Lee cada caracter del archivo marcos.txt y lo escribe en hello.txt
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } catch (IOException e) {
            // Manejo de excepciones si hay un problema con los archivos
            throw new RuntimeException(e);
        }
    }
}