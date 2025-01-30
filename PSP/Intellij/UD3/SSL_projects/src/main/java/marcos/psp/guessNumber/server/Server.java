package marcos.psp.guessNumber.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static final int PORT=60000;

    public static void main(String[] args) {


        try(ServerSocket serverSocket= new ServerSocket(PORT)) {
            System.out.println("Servidor esperando clientes");
            while (true){

                //Acepta las peticiones de conexión con el socket del cliente
                try (Socket clientSocket= serverSocket.accept();){
                    //Envía mensaje al cliente de que ha aceptado la petición y están conectados
                    System.out.println("Petición de cliente aceptada");

                    Thread thread= new Thread(new ServerWorker(clientSocket));

                }
            }
        } catch (IOException e) {
            System.out.println("Error en tiempo de ejecución");
            throw new RuntimeException(e);
        }
    }
}
