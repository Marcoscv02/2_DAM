package marcos.psp.clemenRaffle_examen.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class cliente1 {
    public static final int PORT = 55555;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        try (
             Scanner sc= new Scanner(System.in);
             Socket clientSocket = new Socket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream())
        ){




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
