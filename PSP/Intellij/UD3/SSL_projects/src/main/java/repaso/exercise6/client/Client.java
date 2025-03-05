package repaso.exercise6.client;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.nio.file.Files.write;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SSLSocket clientSocket = null;
        PrintWriter writter = null;
        BufferedReader reader = null;

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            clientSocket = (SSLSocket) factory.createSocket(HOST, PORT);
            writter = new PrintWriter(clientSocket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Welcome to Guess The Number Game\n"+
                    "---------------------------------------\n"+
                    "1. Write NEW with a number of tries you want for start a game (example NEW 3)\n"+
                    "2. Write NUM with a number you think to is it to try to guess\n"+
                    "3. White HELP if you need help to play\n"+
                    "4. White QUIT to quit the game"
            );

            while (true){
                System.out.println("write a command:");
                String comand = sc.nextLine();


                comand = comand.toLowerCase();
                writter.println(comand);
                writter.flush();

                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if (comand.equalsIgnoreCase("QUIT"))
                    break;
            }

            System.out.println("cerrando programa...");
            clientSocket.close();
            reader.close();
            writter.close();

        } catch (IOException e) {
            System.out.println("Error en cliente");
            throw new RuntimeException(e);
        }


    }
}
