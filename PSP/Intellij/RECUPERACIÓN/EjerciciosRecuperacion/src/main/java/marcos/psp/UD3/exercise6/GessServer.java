package marcos.psp.UD3.exercise6;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class GessServer {
    public static final int PORT = 59999;

    public static void main(String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try{
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor escuchando en puerto "+PORT);
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Se ha conectado un cliente");

            Runnable task = new GessServerWorker(clientSocket);
            task.run();

            System.out.println("Se ha desconectado un cliente");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
