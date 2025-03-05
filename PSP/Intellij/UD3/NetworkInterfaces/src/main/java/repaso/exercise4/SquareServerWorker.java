package repaso.exercise4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareServerWorker implements Runnable {
    Socket socket;

    public SquareServerWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writter = new PrintWriter(new PrintWriter(socket.getOutputStream(), true))){

            int num = reader.read();
            System.out.println("Número recibido "+num);
            int numCuadrado = (int) Math.pow(num,2);

            writter.write(numCuadrado);
            writter.flush();
            System.out.println("Numero al cuadrado enviado al cliente");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
