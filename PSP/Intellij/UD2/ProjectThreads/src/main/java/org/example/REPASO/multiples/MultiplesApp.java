package org.example.REPASO.multiples;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class MultiplesApp {
    public static void main(String[] args) {
        ExecutorService numberGeneratorPool = Executors.newSingleThreadExecutor(); // Un solo hilo para generar números
        ExecutorService calculationPool = Executors.newFixedThreadPool(12); // 12 hilos para los cálculos

        numberGeneratorPool.execute(() -> {
            for (int i = 0; i < 50; i++) {
                String bigNumber = generateBigNumber(); // Genera un número aleatorio de 20 a 50 dígitos
                BigInteger number = new BigInteger(bigNumber);

                Runnable task = new MultipleTask(number);
                calculationPool.execute(task);
            }
            numberGeneratorPool.shutdown(); // Finaliza el pool de generación una vez terminada la tarea
        });

        calculationPool.shutdown(); // Finaliza el pool de cálculos cuando todas las tareas se completen
    }

    private static String generateBigNumber() {
        Random random = new Random();
        int length = random.nextInt(31) + 20; // Entre 20 y 50 dígitos

        StringBuilder bigNumber = new StringBuilder();
        bigNumber.append(random.nextInt(9) + 1); // Primer dígito entre 1 y 9 para evitar el 0

        for (int i = 1; i < length; i++) {
            bigNumber.append(random.nextInt(10)); // Dígitos entre 0 y 9
        }

        return bigNumber.toString();
    }
}
