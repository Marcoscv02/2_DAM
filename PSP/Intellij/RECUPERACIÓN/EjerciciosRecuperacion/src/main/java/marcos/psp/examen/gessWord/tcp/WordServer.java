package marcos.psp.examen.gessWord.tcp;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class WordServer {
    public static final int PORT = 59999;
    public static void main(String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT)){
            System.out.println("Servidor escuchando en puerto "+PORT);

            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Se ha conectado un nuevo cliente");

                Thread thread = new Thread(new WordServerWorker(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
