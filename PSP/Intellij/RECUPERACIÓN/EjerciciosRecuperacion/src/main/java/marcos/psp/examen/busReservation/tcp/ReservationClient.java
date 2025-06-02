package marcos.psp.examen.busReservation.tcp;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReservationClient {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try (SSLSocket socket = (SSLSocket) factory.createSocket(HOST,PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writter = new PrintWriter(socket.getOutputStream(), true)){

            System.out.println("----WELCOME TO BUS RESERVATION APP----\n" +
                    "-START <name>- To login in bus reservation app\n" +
                    "-ESTATUS- To view seat status\n" +
                    "-BOOK <seat number> <email>- To book a seat\n" +
                    "-UNDO <seat number>- To cancel a booking (you only can cancel your bookings)\n" +
                    "-EXIT - To get out of the app\n" +
                    "-UPLOAD- To upload all reservations reports to an ftpServer\n(This command just can be executed if you are an admin)");

            while (true){
                String userinput = scanner.nextLine();

                writter.println(userinput);

                //Obtener la respuesta del servidor
                String serverResponse = reader.readLine();
                System.out.println(serverResponse);

                if (userinput.equalsIgnoreCase("Exit"))
                    break;
            }

        } catch (IOException e) {
            System.out.println("Error en el cliente: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
