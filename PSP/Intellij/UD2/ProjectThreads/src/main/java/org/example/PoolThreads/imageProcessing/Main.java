package org.example.PoolThreads.imageProcessing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int NUM_THREADS = 5;

    public static void main(String[] args) {
        File origins = new File("src/main/resources/originals");


        File[] files = origins.listFiles();
        List<String> fileNames = new ArrayList<>();

        //Se guardan los nombres de todos los ficheros en un arrayList
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    fileNames.add(f.getName());
                }
            }
        } else {
            System.out.println("No se encontraron archivos en la carpeta 'originals'.");
            return;
        }

        //Se crea el execuotrService
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        //Hace un foreach en el que va ejecutando una tarea para cada hilo
        for (String fileName : fileNames) {
            Runnable task = new ProcessImage(fileName);
            pool.execute(task);
        }

        pool.shutdown();


        System.out.println("Procesamiento de todas las imágenes completado.");
    }
}
