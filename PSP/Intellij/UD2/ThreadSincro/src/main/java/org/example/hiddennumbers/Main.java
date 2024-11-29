package org.example.hiddennumbers;

import java.util.Random;

/*
- Genera un número aleatorio oculto entre 0 y 100.
- Crea y lanza 10 hilos para adivinar el número.
*/

public class Main {
    public static final int RANDOMNUM=0;
    public static void main(String[] args) {
        Random random = new Random();
        int hiddenNumber = random.nextInt(101); // Número oculto entre 0 y 100
        System.out.println("Número oculto generado.");

        NumeroOculto hiddenNumberObj = new NumeroOculto (hiddenNumber);

        // Crear y lanzar 10 hilos
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new FindNumber (hiddenNumberObj);
            threads[i].start();
        }

        // Esperar a que los hilos terminen
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Juego terminado.");
    }
}
