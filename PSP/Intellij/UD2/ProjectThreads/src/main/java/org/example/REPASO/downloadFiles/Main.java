package org.example.REPASO.downloadFiles;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Path filePath= Paths.get("src/main/resources/animals-urls.txt");
        File file= filePath.toFile();



        if (!file.exists()){
            file.mkdir();
        }
        int contador=1;
        try (BufferedReader br= new BufferedReader(new FileReader(file));
             ExecutorService pool= Executors.newFixedThreadPool(10)){
            String linea;

            while ((linea=br.readLine())!=null){
                URI uri= new URI(linea);
                URL url= uri.toURL();

                pool.execute(new DownLoadFile(url,contador));

                System.out.println("imagen "+contador+" entregada");
                sleep(500);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado en la ruta ");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida en archivo");
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            System.out.println("Error en sintaxis de url");
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Error de ejecución");
            throw new RuntimeException(e);
        }
    }
}
