package marcos.exercise3;

import java.io.*;
import java.net.*;

public class PolybiusClient {
    private static final String HOST = "localhost";
    private static final int PORT = 57777;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Servidor conectado. Ingrese palabras para cifrar (o 'salir' para terminar):");
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                if ("salir".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
                String serverResponse = in.readLine();
                System.out.println("Palabra cifrada: " + serverResponse);
            }
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido: " + HOST);
        } catch (IOException e) {
            System.err.println("Error de I/O en la conexión a " + HOST);
        }
    }
}

