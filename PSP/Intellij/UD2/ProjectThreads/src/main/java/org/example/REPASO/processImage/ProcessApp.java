package org.example.REPASO.processImage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ProcessApp {
    public static final int POOL_SIZE = 5;
    public static void main(String[] args) {
        File origin= new File("src/main/resources/originals");

        if (origin.isDirectory()){
            File[]archivos = origin.listFiles();

            List<String>fileNames= new ArrayList<>();
            for (File archivo: archivos){
                fileNames.add(archivo.getName());
            }

            ExecutorService pool= Executors.newFixedThreadPool(POOL_SIZE);

            for (String name: fileNames){
                Runnable task= new ProcessImage(name);

                pool.execute(task);
            }

        }

    }
}
