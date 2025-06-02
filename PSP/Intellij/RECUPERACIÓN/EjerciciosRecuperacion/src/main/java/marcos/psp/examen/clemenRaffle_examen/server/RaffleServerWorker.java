package marcos.psp.examen.clemenRaffle_examen.server;

import marcos.psp.examen.clemenRaffle_examen.model.Ticket;
import marcos.psp.examen.clemenRaffle_examen.model.Winner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class RaffleServerWorker implements Runnable{
    private final Socket clientSocket;
    private final List <Ticket> soldTickets;
    private Winner winner;



    public RaffleServerWorker (Socket clientSocket, List<Ticket> soldTickets, Winner winner) {
        this.clientSocket = clientSocket;
        this.soldTickets = soldTickets;
        this.winner = winner;
    }

    @Override
    public void run() {
        String name = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writter = new PrintWriter(clientSocket.getOutputStream(), true)) {

            while (true){
                String fullInput = reader.readLine();
                String[]splitInput = fullInput.split(" ");
                String command = splitInput[0];

                switch (command){
                    case "client":
                        if (name==null){
                            name = splitInput[1];
                            writter.println("Hello "+name);
                            break;
                        }else {
                            writter.println("Name is not modiable");
                            break;
                        }

                    case "buy":
                        if (name!=null){

                            if (RaffleServer.canStillBuy()) {
                                Ticket ticket = RaffleServer.buyTicket(name);
                                if (ticket != null)
                                    writter.println(name+"- "+name+" has got the raffle "+ticket.getValue()+".");
                                else
                                    writter.println(name+"- Ticket sales are closed.");
                            }else {
                                writter.println(name+"- Ticket sales are closed.");
                            }
                            break;

                        }else {
                            writter.println("Client name required");
                            break;
                        }

                    case "calc":
                        if (name!=null){

                            if (RaffleServer.canStillBuy()) {
                                writter.println(name+"- The odds are 1/"+soldTickets.size()+".");
                            }else {
                                writter.println(name+"- The raffle has ended");
                            }
                            break;

                        }else {
                            writter.println("Client name required");
                            break;
                        }

                    case "quit":
                        break;

                    default:
                        writter.println(name+"- Unknown command");
                        break;
                }

                if (command.equalsIgnoreCase("quit")){
                    writter.close();
                    reader.close();
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("Error de IO en el serverWorker: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("interrupted Exception en el server worker: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
