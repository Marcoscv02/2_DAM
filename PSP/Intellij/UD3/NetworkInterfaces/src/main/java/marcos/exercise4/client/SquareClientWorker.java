package marcos.exercise4.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareClientWorker implements Runnable{
    private Socket socket;

    public SquareClientWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (//Buffer que recibirá el número al cuadrado del hilo del server
             var br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var out= new PrintWriter(new PrintWriter(socket.getOutputStream()))
             ){

            String respuesta= br.readLine();

            if(respuesta != null){
                int num= Integer.parseInt(respuesta);
                out.println(num);
            }

        } catch (IOException e) {
            System.out.println("Por favor ingrese un numero valido");
            throw new RuntimeException(e);

        }
    }
}
