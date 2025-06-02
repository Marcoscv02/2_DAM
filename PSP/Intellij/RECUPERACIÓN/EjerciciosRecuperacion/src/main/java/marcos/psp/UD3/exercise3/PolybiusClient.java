package marcos.psp.UD3.exercise3;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PolybiusClient {
    public static final int PORT = 59666;
    public static final String HOST= "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);

            while (true){
                System.out.println("Introduce una palabra para cifrar o escribe \"quit\" para salir del programa");
                String word = sc.nextLine();

                writer.println(word);
                System.out.println(reader.readLine());

                if (word.equalsIgnoreCase("quit")) break;

            }


        } catch (IOException e) {
            System.out.println("Error en el cliente");
            throw new RuntimeException(e);
        }
    }
}
