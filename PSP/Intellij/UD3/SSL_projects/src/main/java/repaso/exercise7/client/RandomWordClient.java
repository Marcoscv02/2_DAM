package repaso.exercise7.client;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class RandomWordClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");


        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
            PrintWriter writter = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            System.out.println("____WELCOME TO RANDOM WORD APP____");
            System.out.println("+ write `WORD <numberof letters>` to get a new random word. Example: 'WORD 5'");
            System.out.println("+ write 'QUIT' to exit the program");

           while (true) {
               System.out.println("write command: ");
               String command = sc.nextLine();
               command = command.toLowerCase();

               writter.println(command);
               writter.flush();

               String serverResponse = reader.readLine();
               System.out.println(serverResponse);

               if (command.equalsIgnoreCase("quit"))
                   break;

           }
        } catch (IOException e) {
            System.out.println("Error en cliente");
            throw new RuntimeException(e);
        }
    }
}
