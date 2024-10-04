package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class LaunchProcessSet {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();// Crea una instancia de ProcessBuilder

        Map<String, String> enviroment = pb.environment(); // Obtiene el mapa de variables de entorno del proceso

        // Establece dos variables de entorno NUM1 y NUM2
        enviroment.put("NUM1", "10");
        enviroment.put("NUM2", "40");

        // Configura el comando que se va a ejecutar en el proceso
        pb.command("cmd.exe", "/c", "set NUM1 & set NUM2 & set /a RESULT=%NUM1%+%NUM2");

        try {

             Process process = pb.start(); //Creacion e iniciacion de un nuevo proceso

            // Crea un BufferedReader para leer la salida del proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;

            // Lee cada línea de la salida del proceso
            while ((line = br.readLine()) != null) {
                System.out.println(line); // Imprime la línea leída en la consola
            }

            /*El método waitFor() de la clase Process en Java se utiliza para esperar a que el
            proceso asociado con el objeto Process termine su ejecución.*/
            int exitCode = process.waitFor();
            // Imprime el código de salida del proceso
            System.out.println("\nProcess exited with code " + exitCode);

        } catch (Exception e) {
            // Si ocurre un error, se imprime un mensaje y se termina el programa
            System.out.println("Error");
            System.exit(1); // Finaliza el programa con el código 1
        }
    }
}

