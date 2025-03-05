package repaso.exercise4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SquareServer {
    public static final int PORT = 57777;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Servidor escuchando en el puerto "+PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Servidor conectado");

                Thread thread= new Thread(new SquareServerWorker(clientSocket));
                thread.start();

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
