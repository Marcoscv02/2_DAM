package marcos.psp.UD3.exercise8.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class PhoneBookServerUDP {
    public static final int PORT =59999;

    public static void main(String[] args) {
        byte [] buffer = new byte[1024];

        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Servidor escuchando enpuerto "+PORT);

            while (true){
                DatagramPacket packet= new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packet);
                System.out.println("Paquete de datos recibido del cliente "+packet.getLength());

                Runnable task = new PhoneBookServerWorkerUDP(serverSocket, packet);
                new Thread(task).start();
            }
        } catch (SocketException e) {
            System.out.println("Error en el socket del servidor "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en el recibi del paquete de datos desde el cliente "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
