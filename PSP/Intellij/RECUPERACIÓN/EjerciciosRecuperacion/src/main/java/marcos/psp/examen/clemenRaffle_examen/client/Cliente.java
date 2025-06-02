package marcos.psp.examen.clemenRaffle_examen.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static final int PORT = 55555;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        try (
             Scanner sc= new Scanner(System.in);
             Socket clientSocket = new Socket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true)
        ){
            System.out.println(
                    "\n- CLIENT <client-name>. This command registers a client (client-name) in the system.\n" +
                    "- BUY. This command allows a registered client to purchase a raffle.\n" +
                    "- CALC. This command calculates and returns the winning probability of a raffle.\n" +
                    "- QUIT. This command disconnects the client.");

            while (true){
                System.out.println("Write command:");
                String userInput= sc.nextLine();

                writer.println(userInput.toLowerCase());
                String serverResponse= reader.readLine();
                System.out.println(serverResponse);

                if (userInput.equalsIgnoreCase("quit"))
                    break;

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
