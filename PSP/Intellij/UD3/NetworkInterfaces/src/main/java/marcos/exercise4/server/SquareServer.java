package marcos.exercise4.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SquareServer {
    public static final int PORT = 57778;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Servidor esperando en el puerto " + PORT);

            //Espera a que un cliente se conecte dentro de un bucle infinito
            while (true) {

                //acepta las peticiones de los clientes lo que permite a este conectarse con el servidor
                Socket clientSocket = serverSocket.accept();

                System.out.println("Cliente conectado con el servidor");

                //Se llama al hilo que será el que realice la operación(Por cada cliente se creara un nuevo hilo)
                Thread th = new Thread(new SquareServerWorker(clientSocket));
                th.start();

                System.out.println("Numero enviado al thread");
            }
         } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
