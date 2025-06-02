package marcos.psp.UD3.exercise4;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class SquareServer {
    public static final int PORT = 59999;
    public static void main(String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor escuchando en puerto: "+PORT);

            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("cliente conectado");

                Runnable task = new SquareServerWorker(clientSocket);
                task.run();
            }
        } catch (IOException e) {
            System.out.println("Error en servidor");
            throw new RuntimeException(e);
        }
    }
}
