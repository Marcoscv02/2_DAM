package repaso.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PolybiusServer {
    //Puerto de conexión
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
        try(ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Servidor escuchando en el puerto : "+PORT);

            while (true){
                try(Socket clientSocket = serverSocket.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter writter = new PrintWriter(clientSocket.getOutputStream(),true)){

                    System.out.println("cliente conectado");

                    String text;
                    while ((text = reader.readLine()) !=null ){
                        System.out.println("Palabra recibida "+text);
                        String encrypt = cifrar(text);
                        writter.println(encrypt);
                        writter.flush();
                    }
                    System.out.println("Cerrando conexión");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String cifrar(String word) {
        StringBuilder result = new StringBuilder();
        word = word.toUpperCase()
                .replaceAll("[^A-Z0-9]", ""); // Permite letras y números

        for (char c : word.toCharArray()) {
            boolean found = false;
            // Recorremos la matriz
            for (int i = 0; i < POLYBIUS_SQUARE.length && !found; i++) {
                for (int j = 0; j < POLYBIUS_SQUARE[i].length && !found; j++) {
                    if (POLYBIUS_SQUARE[i][j] == c) {
                        result.append(i + 1).append(j + 1);
                        found = true;
                    }
                }
            }
            if (!found) {
                result.append("??"); // Opcional: Manejo de caracteres no encontrados
            }
        }
        return result.toString();
    }

}






