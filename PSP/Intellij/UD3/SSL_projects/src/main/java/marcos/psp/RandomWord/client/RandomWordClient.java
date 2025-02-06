package marcos.psp.RandomWord.client;

import marcos.psp.prueba1.SSLClient;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class RandomWordClient {
    public static final String HOST = "localhost" ;
    public static final int PORT = 60000 ;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLSocketFactory factory= (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket clientSocket= (SSLSocket) factory.createSocket(HOST,PORT);

        var writter= new PrintWriter(clientSocket.getOutputStream()); //envia
        var reader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //recibe

        System.out.println("input word's lenght like this   'WORD <number_letters>' or write 'END' to finish the game");
        String userInput= sc.nextLine();

        while (!userInput.equalsIgnoreCase("end")){
            writter.println(userInput);//Envia la entrada al servidor

            String word= reader.readLine(); //Recibe la palabra random del servidor
            System.out.println("Random word is: "+word);
        }
        if (userInput.equalsIgnoreCase("end"))System.exit(0);
    }
}
