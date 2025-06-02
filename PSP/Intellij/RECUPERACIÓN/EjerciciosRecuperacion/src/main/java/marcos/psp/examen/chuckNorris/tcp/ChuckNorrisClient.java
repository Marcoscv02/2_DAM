package marcos.psp.examen.chuckNorris.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChuckNorrisClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(),true)){

            System.out.println("---CHUCK NORRIS APP---\n" +
                    "-JOKE <Category> To send an Email with a Chuck Norris Joke (Category can be null for a random category)\n" +
                    "-CATEGORIES To show all categories\n" +
                    "-SEND <your email> <friend email> To send That joke to a friend\n" +
                    "-DOWNLOAD To download that joke to an ftp server\n" +
                    "-EXIT");

            while (true){
                System.out.println("Writte command: ");
                String userinput = scanner.nextLine();

                writer.println(userinput);
                System.out.println(reader.readLine());

                if (userinput.equalsIgnoreCase("exit"))
                    break;
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
