package marcos.psp.guessNumber.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT=60000;

    public static void main(String[] args) {


        try(ServerSocket serverSocket= new ServerSocket(PORT)) {
            System.out.println("Servidor esperando clientes");
            while (true){

                //Acepta las peticiones de conexión con el socket del cliente
                try (
                        Socket clientSocket= serverSocket.accept();
                        BufferedReader br= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ){
                    //Envía mensaje al cliente de que ha aceptado la petición y están conectados
                    System.out.println("Petición de cliente aceptada");

                    System.out.println("Recibido "+br.readLine());
                    Thread thread= new Thread(new ServerWorker(clientSocket));
                    thread.start();

                    if (br.readLine().equalsIgnoreCase("quit")) {
                        System.out.println("Apagando servidor");
                        System.exit(0); //Apagar servidor si se escribe quit
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Error en tiempo de ejecución");
            throw new RuntimeException(e);
        }
    }
}
