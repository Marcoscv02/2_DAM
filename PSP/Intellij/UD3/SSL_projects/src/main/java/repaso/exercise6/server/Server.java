package repaso.exercise6.server;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.*;

public class Server {
    public static final int PORT = 59999;

    public static void main(String[] args) {

        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            while (true){

                System.out.println("10 Number game server ready. Listening in port "+PORT);

                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Conexion establecida");

                Thread th = new Thread(new ServerWorker(clientSocket));
                th.start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor");
            throw new RuntimeException(e);
        }

    }
}
