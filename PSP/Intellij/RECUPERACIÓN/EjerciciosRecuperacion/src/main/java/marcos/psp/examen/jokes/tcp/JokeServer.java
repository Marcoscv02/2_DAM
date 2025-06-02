package marcos.psp.examen.jokes.tcp;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class JokeServer {
    public static final int PORT = 59999;
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory= (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try (SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);){
            System.out.println("Servidor escuchando en el puerto "+PORT);

            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Se ha conectado un nuevo cliente");
                new Thread(new JokeServerWorker(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
