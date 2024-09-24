package ejerciciosClaseFile;

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class    Ejerc6 {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("datos.bin", "rw")) {
            // Escribir 10 enteros en el archivo
            for (int i = 1; i <= 10; i++) {
                raf.writeInt(i);
            }

            // Leer los números antes de la modificación
            System.out.println("Números antes de la modificación:");
            raf.seek(0);
            for (int i = 0; i < 10; i++) {
                System.out.println(raf.readInt());
            }

            // Solicitar al usuario un nuevo número para el tercer número
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese un nuevo número para reemplazar el tercer número: ");
            int nuevoNumero = sc.nextInt();

            // Modificar el tercer número (posición 2 en base 0, cada entero ocupa 4 bytes)
            raf.seek(2 * 4);
            raf.writeInt(nuevoNumero);

            // Leer los números después de la modificación
            System.out.println("Números después de la modificación:");
            raf.seek(0);
            for (int i = 0; i < 10; i++) {
                System.out.println(raf.readInt());
            }

        } catch (IOException e) {
            System.out.println("Ocurrió un error de entrada/salida.");
            e.printStackTrace();
        }
    }
}
