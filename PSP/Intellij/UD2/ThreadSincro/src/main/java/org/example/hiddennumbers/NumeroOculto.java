package org.example.hiddennumbers;

import java.util.concurrent.atomic.AtomicBoolean;

/*
- Comparte el número oculto entre los hilos.
- Controla la finalización del juego si un hilo adivina el número.
*/

public class NumeroOculto {
    private final int hiddenNumber;
    private final AtomicBoolean gameFinished = new AtomicBoolean(false);

    public NumeroOculto (int hiddenNumber) {
        this.hiddenNumber = hiddenNumber;
    }

    public synchronized int numberGuess(int num) {
        if (gameFinished.get()) {
            return -1; // El juego ya ha terminado
        }
        if (num == hiddenNumber) {
            gameFinished.set(true);
            System.out.println("¡Número adivinado: " + num + "!");
            return 1; // Número adivinado
        }
        return 0; // Número incorrecto
    }
}

