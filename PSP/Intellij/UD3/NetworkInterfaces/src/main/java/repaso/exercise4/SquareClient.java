package repaso.exercise4;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareClient {
    public static final String HOST = "localhost";
    public static final int PORT = 57777;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket socket = new Socket(HOST,PORT);
             PrintWriter writter = new PrintWriter(socket.getOutputStream())){

            System.out.println("escriba un número para elevarlo al cuadrado o 0 para cerrar el programa");
            while (true){
                int num = sc.nextInt();

                if (num==0) {
                    System.out.println("saliendo del programa");
                    break;
                } else {
                    writter.write(num);
                    writter.flush();
                    System.out.println("Número enviado al servidor");

                    Thread thread= new Thread(new SquareClientWorker(socket));
                    thread.start();
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
