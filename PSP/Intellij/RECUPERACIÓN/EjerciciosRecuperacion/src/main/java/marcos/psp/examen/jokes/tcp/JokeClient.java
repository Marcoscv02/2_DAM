package marcos.psp.examen.jokes.tcp;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class JokeClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){

            System.out.println("---JOKE APP---\n" +
                    "- JOKE <email>: To send a email with a joke\n" +
                    "- DOWNLOAD: To downLoad all jokes in html format\n" +
                    "- EXIT");

            while (true){
                System.out.println("Writte command:");
                String command = sc.nextLine();

                writer.println(command);
                //Printear el serverResponse
                System.out.println(reader.readLine());

                if (command.equalsIgnoreCase("exit"))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
