package org.example.threads.randomNumRunnable;

import java.util.Random;

public class RunnableApp implements java.lang.Runnable {
    @Override
    public void run() {
        String threaName= Thread.currentThread().getName();
        System.out.println("Welcome I'm Thread: "+threaName);

        Random random= new Random();

        for (int i = 0; i < 5; i++) {
           int numdelay= 10+random.nextInt(491);//De esta forma el número random estaá entre 10 y 500

            try {//Hacer que el proceso espere el número de milisegundos que se ha generado de forma aleatoria
                Thread.sleep(numdelay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread "+threaName+" stopped at "+numdelay+" miliseconds");
        }
        System.out.println("Good Bye");
    }
}
