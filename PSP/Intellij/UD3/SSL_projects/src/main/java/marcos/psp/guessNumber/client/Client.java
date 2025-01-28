package marcos.psp.guessNumber.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static final String HOST="localhost";
    public static final int PORT=60000;

    public static void main(String[] args) {
        try (Socket socket= new Socket(HOST,PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userReader= new BufferedReader(new InputStreamReader(System.in))){

            System.out.println("Servidor conectado");




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
