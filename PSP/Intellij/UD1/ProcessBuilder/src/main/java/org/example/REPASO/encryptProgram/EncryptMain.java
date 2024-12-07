package org.example.REPASO.encryptProgram;

import java.io.*;
import java.util.Scanner;

public class EncryptMain {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduce la palabra que desea encryptar");
        String word= sc.nextLine();

        Process p= new ProcessBuilder("java", "-cp", "target/classes", "org.example.REPASO.encryptProgram.encryptProgram")
                .redirectErrorStream(true) // Redirige errores al flujo estándar
                .start();

        String encryptWord;
        try(var br= new BufferedReader(new InputStreamReader(p.getInputStream()));
            var bw= new BufferedWriter(new OutputStreamWriter(p.getOutputStream()))){

            bw.write(word);
            bw.newLine();
            bw.flush();
            encryptWord = br.readLine();

        }

        System.out.println("La palabra encriptada es "+encryptWord);

    }
}
