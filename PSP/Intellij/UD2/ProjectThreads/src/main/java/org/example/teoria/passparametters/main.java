package org.example.teoria.passparametters;

public class main {
    private static int NUM_THREADS=7;

    public static void main(String[] args) {
        String [] names= {"Marcos", "Pepe", "Josefina", "Andrea", "Jorge", "Noemi", "Carmen"};

        for (int i = 0; i < NUM_THREADS; i++) {
            Runnable gr= new GreetRunnable(names[i]);
            Thread th= new Thread(gr);
            th.start();

        }
    }
}
