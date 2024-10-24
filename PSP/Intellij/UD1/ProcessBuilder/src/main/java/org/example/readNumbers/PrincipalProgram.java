package org.example.readNumbers;

import java.io.*;
import java.util.Scanner;

public class PrincipalProgram {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduzca la cantidad de números que se van a procesar");
            int n = scanner.nextInt();

            // Crear un StringBuilder para construir una cadena con la entrada del usuario
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");

            // Leer los n números del usuario y agregarlos al StringBuilder
            for (int i = 0; i < n; i++) {
                System.out.println("Introduzca número " + (i + 1));
                int num = scanner.nextInt();
                stringBuilder.append(num).append("\n");
            }

            // Convertir el contenido del StringBuilder en un String para enviar como entrada a otros programas
            String input = stringBuilder.toString();
            System.out.println("Esto es el intput"+input);



            // PRIMER PROCESO
            Process proceso1 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program1").start();
            try(BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(proceso1.getOutputStream(),"UTF-8"))) {
                bw.write(input);
                bw.flush();
            }
            // Esperar a que el proceso 1 termine
            proceso1.waitFor();

            // Leer el resultado que devuelve el proceso1 (Program1)
            String resultado1;
            try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()))) {
                resultado1 = reader1.readLine();
            }


            // Lectura de errores del proceso 1
            StringBuilder error1Builder = new StringBuilder();
            try (BufferedReader processError1 = new BufferedReader(new InputStreamReader(proceso1.getErrorStream()))) {
                String errorLine;
                while ((errorLine = processError1.readLine()) != null) {
                    error1Builder.append(errorLine).append("\n");
                }
            }
            String error1 = error1Builder.toString();



            // SEGUNDO PROCESO
            Process proceso2 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program2").start();
            try(BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(proceso2.getOutputStream(), "UTF-8"))) {
                bw1.write(input);
                bw1.flush();
            }
            // Esperar a que el proceso 1 termine
            proceso2.waitFor();

            // Leer el resultado que devuelve el proceso2 (Program2)
            String resultado2;
            try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()))) {
                resultado2 = reader2.readLine();
            }

            // Lectura de errores del proceso 2
            StringBuilder error2Builder = new StringBuilder();
            try (BufferedReader processError2 = new BufferedReader(new InputStreamReader(proceso2.getErrorStream()))) {
                String errorLine;
                while ((errorLine = processError2.readLine()) != null) {
                    error2Builder.append(errorLine).append("\n");
                }
            }
            String error2 = error2Builder.toString();



            // Mostrar los resultados de ambos programas en la salida estándar
            if (error1.isEmpty()) {
                System.out.println("Resultado de SumaCuadrado: " + resultado1);
            } else {
                System.err.println("Error en SumaCuadrado: " + error1);
            }

            if (error2.isEmpty()) {
                System.out.println("Resultado de CuadradoYSuma: " + resultado2);
            } else {
                System.err.println("Error en CuadradoYSuma: " + error2);
            }

        } catch (IOException e) {
            System.err.println("Ocurrió un error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
