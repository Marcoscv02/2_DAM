package org.example.threads.randomNumRunnable;

public class Main {
    public static void main(String[] args) {
        RunnableApp ra= new RunnableApp();

        Thread t1= new Thread(ra, "Hilo 1");
        Thread t2= new Thread(ra, "Hilo 2");

        t1.start();
        t2.start();

        try {//Esto espera a que los dos hilos que se está ejecutando de forma paralela terminen, antes de seguir ejecutando el programa
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Threads's execution has been finished");
    }
}
