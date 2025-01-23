package marcos.exercise3;

import java.io.*;
import java.net.*;

public class PolybiusServer {
    //Puerto en que se realiza la conexión y el servidor escuchara las peticiones
    private static final int PORT = 57777;
    //Matriz que representa el cifrado polybius
    private static final char[][] POLYBIUS_SQUARE = {
            {'A', 'B', 'C', 'D', 'E', 'F'},
            {'G', 'H', 'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P', 'Q', 'R'},
            {'S', 'T', 'U', 'V', 'W', 'X'},
            {'Y', 'Z', '0', '1', '2', '3'},
            {'4', '5', '6', '7', '8', '9'}
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PORT);

            // Espera a que un cliente se conecte dentro de un bucle infinito
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("Cliente conectado");
                    String inputLine;
                    // Lee las palabras enviadas por el cliente
                    while ((inputLine = br.readLine()) != null) {
                        String encrypted = encrypt(inputLine);
                        out.println(encrypted);
                    }
                } catch (IOException e) {
                    System.out.println("Error en la conexión con el cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }

    //Recorre la matriz cambiando las letras por los valores corrspondientes con este cifrado
    private static String encrypt(String word) {
        StringBuilder result = new StringBuilder();
        word = word.toUpperCase().replace("J", "I");
        for (char c : word.toCharArray()) {
            for (int i = 0; i < POLYBIUS_SQUARE.length; i++) {
                for (int j = 0; j < POLYBIUS_SQUARE[i].length; j++) {
                    if (POLYBIUS_SQUARE[i][j] == c) {
                        result.append(i + 1).append(j + 1).append(' ');
                        break;
                    }
                }
            }
        }
        return result.toString();
    }
}

