package org.example.REPASO.downloadFilesUrl;


import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;


public class DownLoadFile implements Runnable {
    private  int numImage;
    private String url;
    private String outputPath = "src/main/resultsUrls";

    public DownLoadFile(int numImage, String url) throws URISyntaxException, IOException {
        this.numImage = numImage;
        this.url = url;
    }


    @Override
    public void run() {
        File directorio= new File(outputPath);
        if (!directorio.exists()) directorio.mkdirs();

        try {

            URLConnection con= new URI(url).toURL().openConnection();

            try(BufferedInputStream reader= new BufferedInputStream(con.getInputStream());
                FileOutputStream writter= new FileOutputStream(directorio+"/animal"+numImage+".png")){

                int byteLeido;
                while ((byteLeido= reader.read())!=-1) {
                    writter.write(byteLeido);
                }

            }
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }


    }
}
