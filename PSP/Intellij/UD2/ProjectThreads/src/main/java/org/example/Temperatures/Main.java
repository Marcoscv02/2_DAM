package org.example.Temperatures;

import java.util.Arrays;
import java.util.Random;

public class Main {
    private static final int TOTAL_DIAS = 3650;
    private static final int NUM_ANIOS = 10;
    private static final int DIAS_POR_ANIO = TOTAL_DIAS / NUM_ANIOS;

    public static void main(String[] args) {
        int[] temperaturas = new int[TOTAL_DIAS];
        Random random = new Random();

        // Generamos temperaturas aleatorias entre -30 y 50
        for (int i = 0; i < TOTAL_DIAS; i++) {
            temperaturas[i] = random.nextInt(81) - 30;
        }

        // Array para almacenar los objetos TempRunnable y los hilos
        TempRunnable[] tareas = new TempRunnable[NUM_ANIOS];
        Thread[] hilos = new Thread[NUM_ANIOS];

        // Dividimos el array en 10 partes, creamos los TempRunnable y lanzamos los hilos
        for (int i = 0; i < NUM_ANIOS; i++) {
            int inicio = i * DIAS_POR_ANIO;
            int fin = inicio + DIAS_POR_ANIO;
            int[] subArray = Arrays.copyOfRange(temperaturas, inicio, fin);

            // Creamos un nuevo TempRunnable para el subarray
            tareas[i] = new TempRunnable(subArray);

            // Creamos y lanzamos el hilo asociado al TempRunnable
            hilos[i] = new Thread(tareas[i]);
            hilos[i].start();
        }

        // Esperamos a que todos los hilos terminen
        try {
            for (Thread hilo : hilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            System.err.println("Error en la espera de los hilos.");
        }

        // Calculamos la suma de las sumas obtenidas por cada hilo
        int sumaTotal = 0;
        for (int i = 0; i < NUM_ANIOS; i++) {
            int sumaAnual = tareas[i].getSum();
            System.out.printf("Suma del año %d: %d\n", i + 1, sumaAnual);
            sumaTotal += sumaAnual;
        }

        // Calculamos la temperatura media de los últimos 10 años
        double media = (double) sumaTotal / TOTAL_DIAS;
        System.out.printf("La temperatura media de los últimos 10 años es: %.2f°C\n", media);
    }
}

