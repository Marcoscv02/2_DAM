package org.example.REPASO2.encryptProgram;

import java.io.*;
import java.util.Scanner;

public class AppEncrypt {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduce la palabra que desee encriptar");
        String word = sc.nextLine();

        Process process= new ProcessBuilder("java","-cp","target/classes","org.example.REPASO2.encryptProgram.Encryptation")
        .redirectErrorStream(true)
        .start();

        var br= new BufferedReader(new InputStreamReader(process.getInputStream()));
        var bw= new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

        bw.write(word); //Envia la palabra que se va a encriptar
        bw.flush();
        String encryptWord= br.readLine();//Recibe la palabra encriptada

        System.out.println("La palabra encriptada es "+encryptWord);
    }
}
