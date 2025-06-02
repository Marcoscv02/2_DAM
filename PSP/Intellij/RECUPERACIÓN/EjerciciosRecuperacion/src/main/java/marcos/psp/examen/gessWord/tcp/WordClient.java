package marcos.psp.examen.gessWord.tcp;


import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.util.Scanner;

public class WordClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();


        try (SSLSocket sslClient = (SSLSocket) sslSocketFactory.createSocket(HOST, PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(sslClient.getInputStream()));
             PrintWriter writter = new PrintWriter(sslClient.getOutputStream(), true)){
            System.out.println("WELCOME TO WORDLE OF HACENDADO");
            System.out.println("(El usuario tendrá 5 intentos para adivinar la palabra)\n" +
                    "- NEW <name> para iniciar un nuevo juego\n" +
                    "- WORD <palabra> para realizar un intento\n" +
                    "- CORRECTION <correo de usuario> para enviar los resultados a un correo electronico\n" +
                    "- HELP para solicitar ayuda sobre el juego\n" +
                    "- QUIT para salir del juego");

            while (true){
                System.out.println("Inser command");
                String userInput = sc.nextLine();

                writter.println(userInput.toLowerCase().trim());

                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if (userInput.equalsIgnoreCase("quit"))
                    break;

            }
        } catch (IOException e) {
            System.out.println("Error en el cliente: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
