package marcos.DateServer.client;


import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DateClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Pass the server IP as the sole command line argument");
            return;
        }
        Socket socket = new Socket(args[0], 57778);
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println("Server response: " + in.nextLine());
        System.out.println("Press a key");
        Scanner inkey= new Scanner(System.in);
        inkey.nextLine();
    }
}