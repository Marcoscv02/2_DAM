package marcos.exercise4.client;

import marcos.exercise4.server.SquareServerWorker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareClient {

    public static final int PORT = 57778;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        try(//Se define el canal de comunicación con la ruta del servidor y el puerto
            var socket= new Socket(HOST,PORT);
            //Reader que leerá la información que llega del hilo cliente
            var br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Se define el printer que enviará el número al servidor
            var out= new PrintWriter(socket.getOutputStream())){

            System.out.println( "Ingrese un número para ser elevado al cuadrado (pulsa salir para terminar):");

            while (true){
                //Termina la ejecución del programa si el usuario escribe salir
                if (sc.nextLine().equalsIgnoreCase("salir")){
                    break;
                }
                SquareClientWorker sqw= new SquareClientWorker(socket);

                int num= sc.nextInt();
                out.println(num); //Enviar numero al servidor

                //Inicia el hilo que recibirá el número al cuadrado
                Thread th= new Thread(sqw);
                th.start();



                //Scanner inThread= new Scanner();
                var br= new BufferedReader(new InputStreamReader(SquareClientWorker))

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
