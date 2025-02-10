package org.example.REPASO.downloadFilesUrl;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.concurrent.Callable;

public class DownLoadFile implements Callable<byte[]> {
    private  int numImage;
    private String url;

    public DownLoadFile(int numImage, String url) throws URISyntaxException, IOException {
        this.numImage = numImage;
        this.url = url;
    }



    @Override
    public byte[] call() throws Exception {
        URLConnection urlImage= new URI(url).toURL().openConnection();

        var imageReader = new BufferedInputStream(urlImage.getInputStream());
        
        int byteLeido;
        while (imageReader.read()!=null){

        }
        return new byte[0];
    }
}
