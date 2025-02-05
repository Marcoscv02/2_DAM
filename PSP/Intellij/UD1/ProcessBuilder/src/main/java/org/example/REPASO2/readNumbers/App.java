package org.example.REPASO2.readNumbers;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();

        System.out.println("Introduce el número de operandos que desea calcular:");
        int operandos= sc.nextInt();
        sb.append(operandos).append("\n");


        Process process1= new ProcessBuilder("java", "-cp", "target/classes" , "org.example.REPASO2.readNumbers.CuadradoSuma")
                .start();

        Process process2= new ProcessBuilder("java", "-cp", "target/classes" , "org.example.REPASO2.readNumbers.SumaCuadrados")
                .start();

        try (var bw1= new BufferedWriter(new OutputStreamWriter(process1.getOutputStream()));
             var bw2= new BufferedWriter(new OutputStreamWriter(process2.getOutputStream()));
             var br1= new BufferedReader(new InputStreamReader(process1.getInputStream()));
             var br2= new BufferedReader(new InputStreamReader(process1.getInputStream()))) {

            for (int i = 0; i < operandos; i++) {
                System.out.println("introduce num: " + (i + 1));
                sb.append(sc.nextInt()).append("\n");
            }

            bw1.write(sb.toString());
            bw2.write(sb.toString());

            String cuadradoSuma= br1.readLine();
            String sumaCuadrado= br2.readLine();

            System.out.println("El cuadrado de la suma de todos los números es: "+cuadradoSuma);
            System.out.println("La suma del cuadrado de todos los números es: "+sumaCuadrado);
        }
    }
}
