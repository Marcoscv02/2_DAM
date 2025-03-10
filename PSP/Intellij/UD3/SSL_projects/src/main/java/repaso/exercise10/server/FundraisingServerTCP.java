package repaso.exercise10.server;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FundraisingServerTCP {
    public static final int PORT = 59999;
    private static  int totalAmount =0;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);

        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT);
            System.out.println("Servidor escuchando en puerto "+PORT);

            for (int i = 0; i < 10; i++) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Cliente conectado");

                Runnable task = new FundraisingServerTCPWorker(clientSocket);
                pool.execute(task);
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor");
            throw new RuntimeException(e);
        }
    }

    public synchronized static void updateTotalAmount (int cuantity){
        totalAmount += cuantity;
    }

    public synchronized static int getTotalAmount (){
        return totalAmount;
    }
}
