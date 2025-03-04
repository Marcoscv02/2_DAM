package marcos.psp.exercise10;

import java.io.*;
import java.net.*;

public class DownloadImage implements Runnable{
    String remotePath; //url
    String localPath; //fichero donde se guarda la imagen
    int index; //índice de la imagen con respecto a los otros hilos

    public DownloadImage(String remotePath, String localPath, int index) {
        this.remotePath = remotePath;
        this.localPath = localPath;
        this.index = index;
    }

    @Override
    public void run() {
        try {
            File imageFile = new File(localPath+"/imagen"+index+".jpg");

            URL url = new URI(remotePath).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode= connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK)
                System.out.println("Error en el establecimiento de la conexión http");

            InputStream is= new BufferedInputStream(connection.getInputStream()); //leer de url
            OutputStream os= new BufferedOutputStream(new FileOutputStream(imageFile)); //escribir en archivo

            int byteLeido;
            while ((byteLeido = is.read()) != -1){
                os.write(byteLeido);
            }
            System.out.println("imagen"+index+" descargada con exito");

        } catch (URISyntaxException | IOException e) {
            System.out.println("Error en conexión");
            throw new RuntimeException(e);
        }
    }
}
