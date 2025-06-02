package marcos.psp.examen.trivialQuiz.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static final int PORT = 59999;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Servidor escuchando en el puerto: " + PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Se ha conectado un cliente");

                Runnable task = new ServerWorkerTCP(clientSocket);
                new  Thread(task).start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
