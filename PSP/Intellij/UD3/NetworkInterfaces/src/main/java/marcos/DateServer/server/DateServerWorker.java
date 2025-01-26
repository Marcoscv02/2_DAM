package marcos.DateServer.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class DateServerWorker implements Runnable{
    private Socket clientsocket;

    public DateServerWorker(Socket clientsocket) {
        this.clientsocket = clientsocket;
    }

    @Override
    public void run() {
        // Crea un PrintWriter para enviar datos al cliente
        PrintWriter out = null;
        try {
            out = new PrintWriter(clientsocket.getOutputStream(), true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Envía la fecha y hora actual al cliente
        out.println(new Date().toString());
    }
}

