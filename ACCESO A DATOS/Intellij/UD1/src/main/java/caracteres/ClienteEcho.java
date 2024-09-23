package caracteres;

import java.io.*;
import java.net.*;

public class ClienteEcho {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.err.println("Uso: java ClienteEcho <nombre host> <número puerto>");
            System.exit(1);
        }

        String nombreHost = args[0];
        int numeroPuerto = Integer.parseInt(args[1]);

        try (Socket echoSocket = new Socket(nombreHost, numeroPuerto); // Socket es un flujo de bytes
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true); // PrintWriter es un flujo de caracteres que envía datos a un flujo de bytes. true para autoflush. Escribirá en el flujo de bytes cada vez que se llame a println
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream())); // InputStreamReader es un puente byte a carácter, leemos bytes del flujo de bytes y los convertimos a caracteres
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)) // InputStreamReader es un puente byte a carácter
        ) {
            String entradaUsuario;
            while ((entradaUsuario = stdIn.readLine()) != null) {
                out.println(entradaUsuario); // envía la entrada del usuario al servidor
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Host desconocido " + nombreHost);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("NO ha sido posible establecer la conexión con " +
                    nombreHost);
            System.exit(1);
        }
    }
}
