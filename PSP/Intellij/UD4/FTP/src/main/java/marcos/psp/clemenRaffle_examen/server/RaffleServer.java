package marcos.psp.clemenRaffle_examen.server;

import marcos.psp.clemenRaffle_examen.model.Ticket;
import marcos.psp.clemenRaffle_examen.model.Winner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class RaffleServer {
    public static final int PORT = 55555;
    public static final int MAX_TICKETS = 10;
    public static final int TICKETS_LENGHT = 5;

    private static List <Ticket> soldTickets;
    private static Winner winner;

    public static void main(String[] args) {
        try (ServerSocket serverSocket= new ServerSocket(PORT)){
            System.out.println("Servidor escuchando en puerto "+ PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Se ha conectado un nuevo cliente");

                Thread th = new Thread(new RaffleServerWorker(clientSocket,soldTickets,winner));
                th.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized static Ticket buyTicket (String name){
        Ticket ticket= new Ticket(name,TICKETS_LENGHT);
        ticket.generatedValue();

        soldTickets.add(ticket);
        return ticket;
    }

    public synchronized static boolean canStillBuy (){
        return soldTickets.size() < MAX_TICKETS;
    }


}
