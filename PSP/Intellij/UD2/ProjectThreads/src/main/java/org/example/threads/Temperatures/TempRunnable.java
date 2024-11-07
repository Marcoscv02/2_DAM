package org.example.threads.Temperatures;

import java.util.Arrays;
import java.util.Random;

public class TempRunnable implements Runnable{
    //Se declaran dos variables, una que es un subarray y la otra que es una suma
    private final int[] subArray;
    private int sum;

    //Constructor
    public TempRunnable(int[] subArray) {
        this.subArray = subArray;
        this.sum = 0;
    }

    @Override
    public void run() {
        // Calcula la suma de las temperaturas del subarray
        for (int temp : subArray) {
            sum += temp;
        }
        System.out.printf("Suma del subarray %s es: %d\n", Arrays.toString(subArray), sum);
    }
    //Llamada al metodo para obtener la suma
    public int getSum() {
        return sum;
    }
}
