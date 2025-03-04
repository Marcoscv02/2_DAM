package repaso.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PolybiusClient {
    public static final String HOST = "localhost";
    public static final int PORT = 57777;

    public static void main(String[] args) {

        try(Socket socket= new Socket(HOST, PORT);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream(), true)){
            System.out.println("Servidor conectado");

            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el texto que desea encriptar o escriba la palabra salir para salir: ");
            while (true){
                String encripting = sc.nextLine();

                if (encripting.equalsIgnoreCase("salir"))
                    break;


                writter.println(encripting);
                writter.flush();//Palabra enviada al servidor
                System.out.println(encripting);

                String encryptCode = reader.readLine();
                System.out.println("texto encriptado: "+encryptCode);

            }

        } catch (IOException e) {
            System.out.println("Error de I/O en la conexión" +e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
