package marcos.psp.UD3.exercise6;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GuessClient {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try(SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream(),true)) {


            while (true){
                System.out.println(
                        "NEW. This command indicates that the client wants to start a new game. As an argument it accept the number of tries the user want to have to guess the number. Example: NEW 8\n" +
                        "NUM. The client sends its guess to the server. A new game has to be created before using this command. Example: NUM 42.\n" +
                        "HELP. The client asks the server for information about the game and the commands to use.\n" +
                        "QUIT. The client sends the request to terminate the communication with the server.\n"
                );

                String command = sc.nextLine();
                writter.println(command);
                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if (command.equalsIgnoreCase("quit")) break;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
