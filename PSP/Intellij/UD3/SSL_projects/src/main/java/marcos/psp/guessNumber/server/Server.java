package marcos.psp.guessNumber.server;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.IOException;

public class Server {
    public static final int PORT=60000;

    public static void main(String[] args) throws IOException {
        SSLSocket clientSocket = null;

        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");


        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT);

        System.out.println("Number game server is ready to receive request from the client in port:"+PORT);

        while (true){

            //Acepta las peticiones de conexión con el socket del cliente
            clientSocket= (SSLSocket) serverSocket.accept();

            //Envía mensaje al cliente de que ha aceptado la petición y están conectados
            System.out.println("Petición de cliente aceptada");

            //Envía la información al hilo a través del socket
            Thread thread= new Thread(new ServerWorker(clientSocket));
            thread.start();
        }


    }
}
