package repaso.exercise7.server;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class RandomWordServer {
    public static final int PORT = 59999;

    public static void main(String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket severSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor escuchando en puerto... "+PORT);

            while (true){
                SSLSocket clientSocket = (SSLSocket) severSocket.accept();
                System.out.println("Cliente conectado");

                Thread th = new Thread(new RandomServerWorkert(clientSocket));
                th.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor");
            throw new RuntimeException(e);
        }
    }
}
