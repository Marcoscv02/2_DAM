package org.example.REPASO.readNumbers;

import java.io.*;
import java.util.Scanner;

public class PrincipalNumbers {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb= new StringBuilder();

        System.out.println("introduce la cantidad de números con los que desea operar");
        int numOperandos= sc.nextInt();
        //Se añaden el número de operandos al StringBuilder
        sb.append(numOperandos).append("\n");

        //Se inicia proceso 1
        Process p1= new ProcessBuilder("java","-cp", "target/classes","org.example.REPASO.readNumbers.Program1" )
                .redirectErrorStream(true)
                .start();

        //Se inicia proceso 2
        Process p2= new ProcessBuilder("java","-cp", "target/classes","org.example.REPASO.readNumbers.Program2" )
                .redirectErrorStream(true)
                .start();

        //Se insertan los datos en los procesos
        try (var writter1 = new BufferedWriter(new OutputStreamWriter(p1.getOutputStream()));
             var writter2 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()))) {

            for (int i = 1; i <= numOperandos; i++) {

                System.out.println("Introduce operando " + i);
                int num = sc.nextInt();
                //Se añade cada operando al StringBuilder
                sb.append(num).append("\n");
            }

            writter1.write(sb.toString());
            writter2.write(sb.toString());
        }


        //Se declaran las variables del resultado
        String sumacuadrado;
        String cuadradoSuma;
        //Se lee la salida estandar de los procesos hijos
        try(var reader1= new BufferedReader(new InputStreamReader(p1.getInputStream()));
            var reader2= new BufferedReader(new InputStreamReader(p2.getInputStream()))){

            cuadradoSuma = reader1.readLine();
            sumacuadrado = reader2.readLine();
        }

        System.out.println(" El cuadrado de la suma de los números es "+cuadradoSuma);
        System.out.println(" La suma del cuadrado de los números es:"+sumacuadrado);
    }
}
