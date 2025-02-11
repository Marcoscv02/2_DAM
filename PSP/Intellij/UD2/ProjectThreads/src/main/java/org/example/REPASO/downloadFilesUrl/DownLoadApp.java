package org.example.REPASO.downloadFilesUrl;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownLoadApp {
    public static final int POOL_SIZE = 10;
    public static final String FILE_PATH = "src/main/resources/animals-urls.txt";

    public static void main(String[] args) {
        ExecutorService pool= Executors.newFixedThreadPool(POOL_SIZE);

        File file= Paths.get(FILE_PATH).toFile();

        try (BufferedReader reader= new BufferedReader(new FileReader(file))){

            String url;
            int numImagen=0;
            while ((url = reader.readLine())!=null){
               Runnable task= new DownLoadFile (numImagen,url);
               pool.execute(task);
               numImagen++;
            }

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
