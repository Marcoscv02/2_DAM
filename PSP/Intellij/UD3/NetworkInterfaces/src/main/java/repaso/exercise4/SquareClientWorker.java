package repaso.exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SquareClientWorker implements Runnable{
    private Socket socket;

    public SquareClientWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            int numCuadrado = reader.read();
            System.out.println("Número recibido");
            System.out.println("Resultado: "+numCuadrado);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
