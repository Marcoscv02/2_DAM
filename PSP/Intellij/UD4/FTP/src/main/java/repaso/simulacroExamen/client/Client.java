package repaso.simulacroExamen.client;

import javax.net.ssl.SSLSocketFactory;

public class Client {
    public static final String HOST = "localhost";
    public static final int PORt = 59999;

    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.trustStore", "ClientKeys.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "abc123.");

        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
    }
}
