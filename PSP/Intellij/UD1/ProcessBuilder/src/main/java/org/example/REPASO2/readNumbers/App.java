package org.example.REPASO2.readNumbers;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();

        System.out.println("Introduce el número de operandos que desea calcular:");
        int operandos= sc.nextInt();
        sb.append(operandos).append("\n");


        Process process1= new ProcessBuilder("java", "-cp", "target/classes" , "org.example.REPASO2.readNumbers.CuadradoSuma")
                .redirectErrorStream(true)
                .start();

        Process process2= new ProcessBuilder("java", "-cp", "target/classes" , "org.example.REPASO2.readNumbers.SumaCuadrados")
                .redirectErrorStream(true)
                .start();

        for (int i = 0; i < operandos; i++) {
            System.out.println("introduce num: " + (i + 1));
            sb.append(sc.nextInt()).append("\n");
        }
        System.out.println("Input:\n"+sb);

        var writer= new PrintWriter(process1.getOutputStream(),true);
        var writer1= new PrintWriter(process2.getOutputStream(), true);
        var br1= new BufferedReader(new InputStreamReader(process1.getInputStream()));
        var br2= new BufferedReader(new InputStreamReader(process2.getInputStream()));

        writer.write(sb.toString());
        writer.flush();
        writer1.write(sb.toString());
        writer1.flush();

        process1.waitFor();
        process2.waitFor();

        String cuadradoSuma= br1.readLine();
        String sumaCuadrado= br2.readLine();

        System.out.println("El cuadrado de la suma de todos los números es: "+cuadradoSuma);
        System.out.println("La suma del cuadrado de todos los números es: "+sumaCuadrado);

    }
}
