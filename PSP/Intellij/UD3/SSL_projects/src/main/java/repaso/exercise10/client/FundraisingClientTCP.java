package repaso.exercise10.client;

import marcos.psp.sslExample.SSLClient;
import repaso.exercise10.server.FundraisingServerTCP;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FundraisingClientTCP {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");


        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
            PrintWriter writter = new PrintWriter(socket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            System.out.println(" ___Fund Raising Program___\n" +
                    "ADD : Adds the specified amount to the funds.\n" +
                    "SHOW: Returns the current fundraising total.\n" +
                    "QUIT: Ends the communication with the server."
                    );

            while (true){
                System.out.println("writte Command:");
                String command = sc.nextLine();
                command=command.toLowerCase();

                writter.println(command);
                writter.flush();

                String serverResponse;
                while ((serverResponse= reader.readLine())!=null){
                    System.out.println("serverResponse = " + serverResponse);
                    break;
                }

                if (command.equalsIgnoreCase("quit")){
                    writter.close();
                    reader.close();
                    socket.close();
                    break;
                }
            }


        } catch (IOException e) {
            System.out.println("Error en el cliente");
            throw new RuntimeException(e);
        }
    }
}
