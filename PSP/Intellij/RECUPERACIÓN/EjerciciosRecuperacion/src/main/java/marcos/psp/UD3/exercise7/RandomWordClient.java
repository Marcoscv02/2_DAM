package marcos.psp.UD3.exercise7;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class RandomWordClient {
    public static final String HOST = "localhost";
    public static final int PORT = 59999;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte [] receiveData = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket()){
            InetAddress serverAddres = InetAddress.getByName(HOST);

            while (true){
                System.out.println("introduce el numero de caracteres que debe tener la palabra obtenida o quit para salir");
                String command = sc.nextLine();

                byte [] sendData = command.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddres, PORT);
                socket.send(sendPacket);


                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println(response);

                if (command.equalsIgnoreCase("quit")) break;
            }

        } catch (SocketException | UnknownHostException e) {
            System.out.println("Error en el cliente: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en envio o recepcion de paquetes "+e.getMessage());
            throw new RuntimeException(e);
        }

    }
}