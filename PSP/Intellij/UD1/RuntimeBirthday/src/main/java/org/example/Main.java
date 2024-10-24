package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Inicialización de la clase Runtime para ejecutar comandos del sistema
        Runtime rt = Runtime.getRuntime();

        // Creación de un objeto Random para generar números aleatorios
        var random = new Random();

        // Inicialización de un ArrayList con los comandos base para ejecutar un jar
        ArrayList<String> comando = new ArrayList<>(Arrays.asList("java", "-cp", ".\\src\\main\\resources\\BasicBirthday-1.0-SNAPSHOT.jar", "org.example.BirthdayArgs"));

        // ArrayList para almacenar los números generados aleatoriamente
        ArrayList<Integer> numIntroducidos = new ArrayList<>();

        // Genera un número aleatorio entre 1 y 5 para determinar el número de casos
        int numCases = random.nextInt(5) + 1;
        System.out.println("numero de casos: " + numCases);
        comando.add(String.valueOf(numCases));

        // Genera números aleatorios para cada caso y los añade al comando y a numIntroducidos
        for (int i = 0; i < numCases; i++) {
            int caso = random.nextInt(101);
            numIntroducidos.add(caso);
            comando.add(String.valueOf(caso));
        }

        // Convierte el ArrayList de comandos a un array de String
        String[] commandArray = comando.toArray(new String[0]);

        try {
            // Ejecuta el comando como un proceso separado
            Process process = rt.exec(commandArray);

            // Prepara un Scanner para leer la salida del proceso
            Scanner sc = new Scanner(process.getInputStream());

            // Lee y muestra la salida del proceso
            int posnum = 0;
            while (sc.hasNextLine()) {
                System.out.println(numIntroducidos.get(posnum++) + " - " + sc.nextLine());
            }

            // Espera a que el proceso termine y obtiene su código de salida
            int exiStatus = process.waitFor();

            // Comprueba si el proceso se ejecutó correctamente
            if (exiStatus == 0) {
                System.out.println("todo correcto");
            } else {
                System.out.println("Ocurrió un problema");
                // Si hubo un error, lee y muestra la salida de error del proceso
                Scanner scError = new Scanner(process.getErrorStream());
                while (scError.hasNextLine()) {
                    System.out.println(scError.nextLine());
                }
            }

        } catch (IOException | InterruptedException e) {
            // Captura y maneja las excepciones que puedan ocurrir durante la ejecución
            throw new RuntimeException(e);
        }
    }
}