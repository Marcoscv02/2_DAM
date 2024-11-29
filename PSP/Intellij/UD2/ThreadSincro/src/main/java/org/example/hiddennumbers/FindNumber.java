package org.example.hiddennumbers;

import java.util.Random;

/*
Cada hilo intenta adivinar el número generando valores aleatorios hasta que adivinan o el juego termina.
*/

public class FindNumber extends Thread {
    private final NumeroOculto hiddenNumber;

    public FindNumber(NumeroOculto hiddenNumber) {
        this.hiddenNumber = hiddenNumber;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int guess = random.nextInt(101); // Generar un número entre 0 y 100
            int result = hiddenNumber.numberGuess(guess);
            if (result == 1 || result == -1) {
                break; // Fin del juego si se adivina o ya terminó
            }
        }
    }
}

