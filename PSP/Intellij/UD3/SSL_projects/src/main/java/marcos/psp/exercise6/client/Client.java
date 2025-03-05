package marcos.psp.exercise6.client;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.util.Scanner;

public class Client {
    public static final String HOST="localhost";
    public static final int PORT=60000;

    public static void main(String[] args) throws IOException {
        SSLSocket clientSocket=null;
        PrintWriter out=null;

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        //SSL ServerSocket Initialisation
        SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        clientSocket=(SSLSocket) sslSocketFactory.createSocket(HOST, PORT);

         out = new PrintWriter(clientSocket.getOutputStream(),true);
        BufferedReader reader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Scanner userReader= new Scanner(System.in);

        System.out.println("Servidor conectado");

        while (true){

            System.out.println("Welcome to Guess The Number Game\n"+
                    "---------------------------------------\n"+
                    "1. Write NEW with a number of tries you want for start a game (example NEW 3)\n"+
                    "2. Write NUM with a number you think to is it to try to guess\n"+
                    "3. White HELP if you need help to play\n"+
                    "4. White QUIT to quit the game"
            );
            System.out.println("Write Command");
            String userInput= userReader.nextLine();

            out.println(userInput.toLowerCase());

            System.out.println(reader.readLine());

            if (userInput.equalsIgnoreCase("quit")){
                System.exit(0);
            }
            reader.close();
            out.close();
            clientSocket.close();
        }

    }
}
