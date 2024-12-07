package org.example.REPASO.downloadFiles;

import java.net.URL;

public class DownLoadFile implements Runnable{
    URL url;
    int numImagen;

    public DownLoadFile(URL url, int numImagen) {
        this.url = url;
        this.numImagen = numImagen;
    }

    @Override
    public void run() {

    }
}
