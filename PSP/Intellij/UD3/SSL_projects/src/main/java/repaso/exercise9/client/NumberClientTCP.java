package repaso.exercise9.client;

import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class NumberClientTCP {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try {
            Socket socket = factory.createSocket(HOST,PORT);
            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var writter = new PrintWriter( socket.getOutputStream());

            System.out.println(
                    "___WELCOME TO NUMBER FACTS APP___\n"+
                    "(You must use this commands to play)"+
                    "- NUMBER <number_letters> <number_type>\n" +
                            "\t number_letters can be a number or the word `random`.\n" +
                            "\t number-type can be one of three values: trivia, math, date  or year\n"+
                    "- END to finsh the game"
            );


            while (true){
                System.out.println("Writte a command");
                String command = sc.nextLine();

                command = command.toLowerCase();
                writter.println(command);
                writter.flush();

                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if ( command.equalsIgnoreCase("end"))
                    break;

            }

            reader.close();
            writter.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Error en el cliente");
            throw new RuntimeException(e);
        }
    }
}
