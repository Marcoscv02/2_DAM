package marcos.psp.UD3.exercise7;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class RandomWordServer {
    public static final int PORT = 59999;

    public static void main(String[] args) {
        try(DatagramSocket serverSocket = new DatagramSocket(PORT)){
            System.out.println("Servidor escuchando en puerto "+PORT);

            while (true){
                byte buffer[] = new byte[1024];
                InetAddress address = serverSocket.getInetAddress();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(packet);

                Runnable task = new RandomWordServerWorker(packet, serverSocket);
                new Thread(task).start();

            }
        } catch (SocketException e) {
            System.out.println("Error en el servidor "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en el servidor "+e.getMessage());
            throw new RuntimeException(e);
        }

    }

}