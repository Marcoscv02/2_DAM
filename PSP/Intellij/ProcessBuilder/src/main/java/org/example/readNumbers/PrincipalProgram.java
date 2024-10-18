package org.example.readNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
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

            // PRIMER PROCESO
            Process proceso1 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program1").start();
            OutputStream outputStream1 = proceso1.getOutputStream();
            outputStream1.write(input.getBytes(StandardCharsets.UTF_8));  // Enviar la cadena como bytes
            outputStream1.flush();
            outputStream1.close();

            // Leer el resultado que devuelve el proceso1 (Program1)
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()));
            String resultado1 = reader1.readLine();
            reader1.close();

            // Lectura de errores
            BufferedReader processError1 = new BufferedReader(new InputStreamReader(proceso1.getErrorStream()));
            StringBuilder error1Builder = new StringBuilder();
            String errorLine;
            while ((errorLine = processError1.readLine()) != null) {
                error1Builder.append(errorLine).append("\n");
            }
            processError1.close();
            String error1 = error1Builder.toString();

            // SEGUNDO PROCESO
            Process proceso2 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program2").start();
            OutputStream outputStream2 = proceso2.getOutputStream();
            outputStream2.write(input.getBytes(StandardCharsets.UTF_8));
            outputStream2.flush();
            outputStream2.close();

            // Leer el resultado que devuelve el proceso2 (Program2)
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
            String resultado2 = reader2.readLine();
            reader2.close();

            // Lectura de errores
            BufferedReader processError2 = new BufferedReader(new InputStreamReader(proceso2.getErrorStream()));
            StringBuilder error2Builder = new StringBuilder();
            while ((errorLine = processError2.readLine()) != null) {
                error2Builder.append(errorLine).append("\n");
            }
            processError2.close();
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
