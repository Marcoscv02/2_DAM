package repaso.exercise9.server;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class NumberServerTCP {
    public static final int PORT = 59999;

    public static void main(String[] args) {

        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT)){
            System.out.println("Servidor escuchando en puerto "+PORT);

            //Este servidor permite conectarse hasta 5 usuarios
            for (int i = 0; i < 5; i++) {
                SSLSocket clienSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Cliente concectado");

                Thread thread = new Thread(new NumberServerTCPWorker(clienSocket));
                thread.start();

            }

        } catch (IOException e) {
            System.out.println("Error en el servidor");
            throw new RuntimeException(e);
        }
    }
}
