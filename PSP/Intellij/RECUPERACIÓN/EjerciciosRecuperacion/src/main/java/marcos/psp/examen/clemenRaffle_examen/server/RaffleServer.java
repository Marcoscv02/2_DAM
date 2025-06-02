package marcos.psp.examen.clemenRaffle_examen.server;

import marcos.psp.examen.clemenRaffle_examen.smtp.SendMail;
import marcos.psp.examen.clemenRaffle_examen.model.Ticket;
import marcos.psp.examen.clemenRaffle_examen.model.Winner;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RaffleServer {
    public static final int PORT = 55555;
    public static final int MAX_TICKETS = 5;
    public static final int TICKETS_LENGHT = 5;

    private static List <Ticket> soldTickets = new ArrayList<>();
    private static Winner winner = new Winner();

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

    public synchronized static Ticket buyTicket (String name) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Ticket ticket= new Ticket(name,TICKETS_LENGHT);
        ticket.setValue(ticket.generatedValue());

        soldTickets.add(ticket);

        // Si se alcanzó el límite de tikets se realiza el sorteo
        if (soldTickets.size() >= MAX_TICKETS) {
            System.out.println("Se han vendido todos los tikets disponibles, comienza el sorteo");
            winner = getWinner();
            System.out.println("winner de método buyTicket" + ticket);

            for(Ticket w: soldTickets){
                Runnable task = new SendMail(winner, w, true);
                pool.execute(task);

            }
            System.out.println("Se han enviado todos los mensajes");
            pool.shutdown();
        }

        return ticket;
    }

    public synchronized static boolean canStillBuy (){
        return soldTickets.size() < MAX_TICKETS;
    }

    public synchronized static Winner getWinner(){
        Ticket ticket= soldTickets.get((int) (Math.random() * soldTickets.size()));
        winner= new Winner(ticket, true);

        return winner;
    }
}
