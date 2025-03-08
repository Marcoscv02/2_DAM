package repaso.exercise8.client;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ContactClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            SSLSocket socket = (SSLSocket) factory.createSocket(HOST, PORT);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("__WELCOME TO YOUT PHONEBOOK__\n" +
                    "Use thi command:\n" +
                    "\t - ADD <name> <telephone_number> to add a new contact (Example: ADD Marcos 666666666)\n" +
                    "\t - FIND <name> to search for a contact (Example: FIND Marcos) \n" +
                    "\t - DELETE <telephone_number> to search for a contact (example: REMOVE 666666666) \n" +
                    "\t - EXIT to close the program (Example: EXIT)"
            );
            while (true) {
                System.out.println("Write a command");
                String command = sc.nextLine();
                command= command.toLowerCase();

                writer.println(command);
                writer.flush();

                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if (command.equalsIgnoreCase("exit"))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente");
            throw new RuntimeException(e);
        }
    }
}
