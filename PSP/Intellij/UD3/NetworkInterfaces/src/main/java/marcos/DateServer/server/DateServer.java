package marcos.DateServer.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServer {
    public static void main(String[] args) throws IOException {
        // Crea un ServerSocket en el puerto 57777
        try (ServerSocket listener = new ServerSocket(57778)) //ServerSocket autocloseable
        {
            System.out.println("The date server is running...");

            // Bucle infinito para mantener el servidor en ejecución
            while (true) {
                // Espera y acepta una conexión de cliente

                try (   //Socket autocloseable
                        Socket socket = listener.accept()){

                    System.out.println("cliente connected to server");
                    Thread serverThread= new Thread(new DateServerWorker(socket));
                    serverThread.start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        // El ServerSocket se cierra automáticamente al final de este bloque try
    }
}



