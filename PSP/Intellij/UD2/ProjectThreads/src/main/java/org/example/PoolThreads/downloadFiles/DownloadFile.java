package org.example.PoolThreads.downloadFiles;

import java.io.*;
import java.net.*;

public class DownloadFile implements Runnable {
    // URL de la imagen a descargar y número de la imagen para nombrar el archivo de salida
    String urlString;
    int numberImage;

    // Constructor que inicializa la URL y el número de imagen
    public DownloadFile(String urlString, int numberImage) {
        this.urlString = urlString;
        this.numberImage = numberImage;
    }

    @Override
    public void run() {
        // Carpeta de salida para las imágenes descargadas
        File outputFile = new File("src/main/resultsUrls");

        if (!outputFile.exists()){
            outputFile.mkdirs();
        }

        // Comprobación para evitar URLs vacías o nulas
        if (urlString == "" || urlString == null) {
            System.out.println("No se ha podido descargar esta URL");
        } else {
            try {
                // Se establece una conexión a la URL
                URLConnection con = (new URI(urlString).toURL()).openConnection();

                // Se abre un flujo de entrada y un flujo de salida para guardar la imagen
                try (BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
                     FileOutputStream fos = new FileOutputStream(outputFile + "/animal" + numberImage + ".jpg")) {

                    int byteLeido;
                    // Se lee cada byte desde el flujo de entrada y se escribe en el archivo de salida
                    while ((byteLeido = bis.read()) != -1) {
                        fos.write(byteLeido);
                    }

                } catch (IOException e) {
                    // Mensaje en caso de error durante la copia de la imagen
                    System.out.println("Error en ejecución de copiado de imagen");
                    throw new RuntimeException(e);
                }

            } catch (MalformedURLException e) {
                // Mensaje en caso de que la URL esté mal formada
                System.out.println("Error en URL");
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                // Mensaje en caso de error de sintaxis en la URI
                System.out.println("Error en sintaxis de URI");
                throw new RuntimeException(e);
            } catch (IOException e) {
                // Mensaje en caso de error de entrada/salida general
                System.out.println("Error en entrada/salida");
                throw new RuntimeException(e);
            }
        }
    }
}
