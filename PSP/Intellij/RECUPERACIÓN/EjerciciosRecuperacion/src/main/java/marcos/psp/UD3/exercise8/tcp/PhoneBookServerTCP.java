package marcos.psp.UD3.exercise8.tcp;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class PhoneBookServerTCP {
    public static final int PORT = 59999;

    public static void main(String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor escuchando en el puerto "+PORT);

            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Cliente conectado");

                Runnable task = new PhoneBookServerWorkerTCP(clientSocket);
                new Thread(task).start();

                System.out.println("Cliente desconectado");
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
