package org.example.teoria.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static final int NUM_PERSONAS=7;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String [] names= {"Marcos", "Pepe", "Josefina", "Andrea", "Jorge", "Noemi", "Carmen"};

        for (int i = 0; i < NUM_PERSONAS; i++) {
            //Se crea el objeto Callable
            Callable gt= new GreetCallable(names[i]);
            //Se geera un objeto FutureTask
            FutureTask ft= new FutureTask(gt);
            //Se genera hilo
            Thread th= new Thread(ft);
            th.start();
            String msg= ft.get().toString(); //se obtiene el return del hilo
            System.out.println(msg);
        }
    }
}
