package marcos.exercise1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfaces {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces =NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()){
            NetworkInterface networkInterface = interfaces.nextElement();

            // ignorar interfaces inactivas y de loopback
            if (!networkInterface.isUp() || networkInterface.isLoopback()) {
                continue;
            }

            System.out.println("Nombre de red: "+networkInterface.getName());
            System.out.println("Nombre de display: "+networkInterface.getDisplayName());
            System.out.println("Nombre de IP: "+networkInterface.getInetAddresses());
            System.out.println("------------------------------------------------------------------------------");
        }
    }
}
