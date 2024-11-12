package org.example.PoolThreads.downloadFiles;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Se crea un objeto File que representa el archivo donde están las URLs de las imágenes a descargar
        File animalsUrls = new File("src/main/resources/animals-urls.txt");

        // Se inicializa un contador para numerar cada imagen descargada
        int numImage = 1;

        // Se intenta abrir el archivo y leer su contenido línea por línea
        try (var br = new BufferedReader(new FileReader(animalsUrls));
             ExecutorService pool = Executors.newFixedThreadPool(10)) {
            String url;

            // Se crea un pool de threads con un tamaño fijo de 10 threads
//            ExecutorService pool = Executors.newFixedThreadPool(10);

            // Se leen las URLs una por una y se ejecuta una tarea de descarga para cada URL
            while ((url = br.readLine()) != null) {
                // Se crea una tarea Runnable que descargará el archivo de la URL especificada
                Runnable task = new DownloadFile(url, numImage);

                // Se envía la tarea al pool de threads para su ejecución
                pool.execute(task);

                // Se incrementa el contador de imágenes
                numImage++;
            }

            //Cierra el pollThreads al terminar
            pool.shutdownNow();
            System.out.println("Descargas realizadas correctamente");
            //System.exit(0);

        } catch (FileNotFoundException e) {
            // Mensaje en caso de que el archivo de URLs no se encuentre
            System.out.println("No se encontró el archivo " + animalsUrls);
            throw new RuntimeException(e);
        } catch (IOException e) {
            // Mensaje en caso de algún otro error de entrada/salida
            System.out.println("Error en entrada/salida en main");
            throw new RuntimeException(e);
        }
    }
}
