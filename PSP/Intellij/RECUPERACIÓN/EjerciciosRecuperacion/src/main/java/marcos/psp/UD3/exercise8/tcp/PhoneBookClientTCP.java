package marcos.psp.UD3.exercise8.tcp;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBookClientTCP {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try(SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream(), true)){

            while (true){
                System.out.println(
                        "ADD <name><telephone_number>. This command indicates that the client wants to add a new contact to the phonebook.\n" +
                        "FIND <name>. The client wants to know if a contact exists and, if so, to know his contact details.\n" +
                        "EXIT. The client informs the server that he wants to leave.\n"+
                        "Write command:"
                );
                String command = scanner.nextLine();

                writter.println(command);
                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if (command.equalsIgnoreCase("exit")) break;
            }
        } catch (IOException e) {
            System.out.println("Error en el socket cliente: "+e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
