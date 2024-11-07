package org.example.threads.palindromes;

import java.util.HashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        String [] palabras={"kayak", "hello", "deified","word" , "rotator", "repaper", "deed"};
        HashSet<FutureTask> hilos= new HashSet<>();

        for (int i = 0; i < palabras.length; i++) {
            Callable pc= new PalindromeCallable(palabras[i]);
            FutureTask ft= new FutureTask(pc);
            Thread th= new Thread(ft);
            th.start();
            hilos.add(ft);
        }

        try {
            for (FutureTask task:hilos){
                    System.out.println(task.get().toString()); //Se debe utilizar el metodo get para obtener el return del hilo
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
