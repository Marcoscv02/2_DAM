package marcos.exercise4.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareServerWorker implements Runnable {
    private Socket socket;

    public SquareServerWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try(//Buffer para recojer la informacion enviada por el servidor
            var br= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Se crea el PrintWritter que enviara lOs datos al hilo del cliente
            PrintWriter out= new PrintWriter(socket.getOutputStream())){

            //El input es el número introducido por el usuario
            String intput= br.readLine();

            if(intput!=null){

                System.out.println("Numero recibido y elevado al cuadrado");
                int num= Integer.parseInt(intput);
                int numCuadrado= (int) Math.pow(2,num);

                //Envía la respuesta al cliente
                out.println(numCuadrado);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
