package repaso.exercise1;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class NetworkInterfaces {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

        while (interfaces.hasMoreElements()){
            NetworkInterface interface_ = interfaces.nextElement();

            if (!interface_.isUp()  || interface_.isLoopback())
                continue;

            System.out.println("Nombre de red: "+interface_.getName());
            System.out.println("Nombre de display: "+interface_.getDisplayName());
            System.out.println("Nombre de IP: "+interface_.getInetAddresses());
            System.out.println("------------------------------------------------------------------------------");
        }
    }
}
