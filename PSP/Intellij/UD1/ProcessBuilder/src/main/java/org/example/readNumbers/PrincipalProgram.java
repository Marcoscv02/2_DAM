package org.example.readNumbers;

import java.io.*;
import java.util.Scanner;

/**
 * Clase principal que solicita al usuario una lista de números y los procesa
 * utilizando dos programas secundarios: `Program1` y `Program2`.
 *
 * <p>El programa realiza los siguientes pasos:</p>
 * <ol>
 *   <li>Solicita al usuario la cantidad de números y los números a procesar.</li>
 *   <li>Ejecuta el programa `Program1`, que calcula el cuadrado de la suma de los números.</li>
 *   <li>Ejecuta el programa `Program2`, que calcula la suma de los cuadrados de los números.</li>
 *   <li>Lee la salida estándar de ambos programas y también captura posibles errores.</li>
 *   <li>Muestra los resultados o errores en la consola.</li>
 * </ol>
 */
public class PrincipalProgram {
    /**
     * Método principal que ejecuta el programa.
     *
     * @param args Argumentos de la línea de comandos (no se usan).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar y leer la cantidad de números a procesar
            System.out.println("Introduzca la cantidad de números que se van a procesar");
            int n = scanner.nextInt();

            // Construir la entrada para los programas secundarios
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(n).append("\n");

            for (int i = 0; i < n; i++) {
                System.out.println("Introduzca número " + (i + 1));
                int num = scanner.nextInt();
                stringBuilder.append(num).append("\n");
            }

            // Convertir la entrada a una cadena
            String input = stringBuilder.toString();
            System.out.println("Esto es el input: " + input);

            // Ejecutar Program1
            Process proceso1 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program1").start();
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(proceso1.getOutputStream(), "UTF-8"))) {
                bw.write(input);
                bw.flush();
            }
            proceso1.waitFor();

            // Leer el resultado de Program1
            String resultado1;
            try (BufferedReader reader1 = new BufferedReader(new InputStreamReader(proceso1.getInputStream()))) {
                resultado1 = reader1.readLine();
            }

            // Capturar errores de Program1
            StringBuilder error1Builder = new StringBuilder();
            try (BufferedReader processError1 = new BufferedReader(new InputStreamReader(proceso1.getErrorStream()))) {
                String errorLine;
                while ((errorLine = processError1.readLine()) != null) {
                    error1Builder.append(errorLine).append("\n");
                }
            }
            String error1 = error1Builder.toString();

            // Ejecutar Program2
            Process proceso2 = new ProcessBuilder("java", "-cp", "target/classes", "org.example.readNumbers.Program2").start();
            try (BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(proceso2.getOutputStream(), "UTF-8"))) {
                bw1.write(input);
                bw1.flush();
            }
            proceso2.waitFor();

            // Leer el resultado de Program2
            String resultado2;
            try (BufferedReader reader2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()))) {
                resultado2 = reader2.readLine();
            }

            // Capturar errores de Program2
            StringBuilder error2Builder = new StringBuilder();
            try (BufferedReader processError2 = new BufferedReader(new InputStreamReader(proceso2.getErrorStream()))) {
                String errorLine;
                while ((errorLine = processError2.readLine()) != null) {
                    error2Builder.append(errorLine).append("\n");
                }
            }
            String error2 = error2Builder.toString();

            // Mostrar los resultados de ambos programas
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
