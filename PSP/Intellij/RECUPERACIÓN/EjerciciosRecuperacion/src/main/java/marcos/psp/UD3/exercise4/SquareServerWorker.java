package marcos.psp.UD3.exercise4;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SquareServerWorker implements Runnable {
    SSLSocket socket;

    public SquareServerWorker(SSLSocket socket) {
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writter = new PrintWriter(socket.getOutputStream(), true)) {

            while (true){
                String cadenaTexto = reader.readLine();

                if (cadenaTexto.equalsIgnoreCase("quit")) {
                    System.out.println("Cliente desconectado");
                    writter.println("good bye");
                    break;
                }

                if (isNumeric(cadenaTexto)) {
                    int cadenaNum = Integer.parseInt(cadenaTexto);
                    int numCuadrado = (int) Math.pow(cadenaNum,2);
                    writter.println(numCuadrado);

                }else {
                    writter.println("La cadena introducida debe ser numérica");
                }
            }

        } catch (IOException e) {
            System.out.println("Error en el hilo del servidor");
            throw new RuntimeException(e);
        }
    }

    public static boolean isNumeric(String cadenaLeida) {
        try {
            int numero = Integer.parseInt(cadenaLeida);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
