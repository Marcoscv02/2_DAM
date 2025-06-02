package marcos.psp.examen.chuckNorris.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChuckNorrisServer {
    public static final int PORT = 59999;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);){
            System.out.println("Servidor escuchando en el puerto: "+PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado");

                new Thread(new ChuckNorrisServerWorker(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
