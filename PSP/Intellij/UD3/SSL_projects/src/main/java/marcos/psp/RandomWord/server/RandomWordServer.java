package marcos.psp.RandomWord.server;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.*;

public class RandomWordServer {
    public static final int PORT=60000;
    public static void main(String[] args) throws IOException {
        SSLSocket clientSocket=null;

        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory= (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket= (SSLServerSocket) factory.createServerSocket(PORT);

        System.out.println("Number game server is ready to receive a client");

        while (true){
            //Acepta las peticiones de conexión con el cliente
            clientSocket= (SSLSocket) serverSocket.accept(); //Acepta la peticion del cliente
            System.out.println("client petition has been accepted");

            Thread th= new Thread(new RandomWordServerWorker(clientSocket));
            th.start();
        }

    }
}
