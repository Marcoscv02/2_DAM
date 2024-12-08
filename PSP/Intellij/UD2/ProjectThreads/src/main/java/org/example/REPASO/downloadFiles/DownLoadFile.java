package org.example.REPASO.downloadFiles;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownLoadFile implements Runnable{
    URL url;
    int numImagen;

    public DownLoadFile(URL url, int numImagen) {
        this.url = url;
        this.numImagen = numImagen;
    }

    @Override
    public void run() {
        Path fileP= Paths.get("src/main/resultsUrls/animal"+numImagen+".jpg");
        File f= fileP.toFile();

        try (var br= new BufferedInputStream(url.openConnection().getInputStream());
             var bw= new BufferedOutputStream(new FileOutputStream(f))){

            int byteLeido;

            while ((byteLeido=br.read())!=-1){
                bw.write(byteLeido);
            }
            System.out.println("Imagen "+numImagen+" cargada con éxito");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
