package marcos.psp.examen.harryPotter.tcp;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class HarryPotterClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SocketFactory factory = SSLSocketFactory.getDefault();
        try (SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){

            System.out.println("---WELCOME TO HARRY POTTER APPº\n" +
                    "Here you can get all information about Harry Potter books\n" +
                    "- SEEBOOKS get all book's title\n" +
                    "- BOOK <index> give information about that Harry potter book\n" +
                    "- SEECHARACTERS give all character's name\n" +
                    "- CHARACTER <index> give information about this character\n" +
                    "- SEEHOUSES get all house names\n" +
                    "- HOUSE <index> give information about this house\n" +
                    "- SEESPELLS get all spell names\n" +
                    "- SPELL <index> give information about this spell\n" +
                    "- SEND <type> <index> <email> to send information about any thing (type*: book, house, character, spell )\n" +
                    "- DOWNLOAD <type> <index> to download information about any thing (type*: book, house, character, spell )\n" +
                    "- EXIT close program"
            );

            while (true){
                System.out.println("Writte command:");
                String command = scanner.nextLine();

                writer.println(command);

                System.out.println(reader.readLine()); //ServerResponse

                if (command.equalsIgnoreCase("exit"))
                    break;
            }

        } catch (IOException e) {
            System.out.println("Error en el cliente: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
