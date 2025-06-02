package marcos.psp.UD3.exercise3;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class PolybiusServer {
    public static final int PORT= 59666;

    public static void main(String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "Serverkeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try{
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor escuchando en el puerto "+PORT);

            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("cliente conectado");

                Runnable task = new PolybiusServerWorker(clientSocket);
                task.run();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor");
            throw new RuntimeException(e);
        }


    }
}
