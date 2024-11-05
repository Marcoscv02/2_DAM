package org.example.teoria.PoolThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int NUM_THREADS=7;
    public static void main(String[] args) {
        String [] names= {"Marcos", "Pepe", "Josefina", "Andrea", "Jorge", "Noemi", "Carmen"};

        ExecutorService pool= Executors.newFixedThreadPool(NUM_THREADS);

        for (int i = 0; i < NUM_THREADS; i++) {
            Runnable rt= new RunnableThreads(names[i]);
            pool.execute(rt);//Se utiliza para iniciar el pool
        }
        //En los pools de sebe indicar explicitamente el cierre de la ejecucion
        pool.close();//Cierra la ejecucion cuando termine de jecutar las tareas que tiene pendientes
        pool.shutdown();//para la ejecucion del hilo en el momento en que se indica
    }
}
