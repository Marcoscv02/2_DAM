package marcos.psp.UD3.exercise8.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class PhoneBookClientUDP {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte [] buffer = new byte[1024];

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddres = InetAddress.getByName(HOST);


            while (true){
                System.out.println(
                        "ADD <name><telephone_number>. This command indicates that the client wants to add a new contact to the phonebook.\n" +
                        "FIND <name>. The client wants to know if a contact exists and, if so, to know his contact details.\n" +
                        "EXIT. The client informs the server that he wants to leave.\n"+
                        "Write command:"
                );

                String command = sc.nextLine();

                //Enviar datos
                byte[] sendData = command.getBytes();
                DatagramPacket packet = new DatagramPacket(sendData, sendData.length, serverAddres, PORT);
                clientSocket.send(packet);
                System.out.println(packet.getLength());

                //Recibir datos
                DatagramPacket response  = new DatagramPacket(buffer, buffer.length);
                clientSocket.receive(response);
                String responseFormatted = new String(response.getData(),0,response.getLength(),"UTF-8");
                System.out.println(responseFormatted);

                //Salir del programa si se cumple la condición "exit"
                if (command.equalsIgnoreCase("exit")) break;
            }

        } catch (SocketException | UnknownHostException e) {
            System.out.println("Error en el cliente " +e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en el envío del paquete de datos "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
