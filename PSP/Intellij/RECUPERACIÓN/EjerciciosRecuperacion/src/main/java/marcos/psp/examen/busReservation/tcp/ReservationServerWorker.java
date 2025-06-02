package marcos.psp.examen.busReservation.tcp;

import marcos.psp.examen.busReservation.model.Seat;

import javax.net.ssl.SSLSocket;
import java.io.*;
import java.util.List;

public class ReservationServerWorker implements Runnable{
    private SSLSocket socket;
    private List<Seat> seats;

    public ReservationServerWorker(SSLSocket socket, List<Seat> seats) {
        this.socket = socket;
        this.seats = seats;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Se ha iniciado el hilo del cliente");
        String userName = null;
        boolean loged = false;

        try (PrintWriter writter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            while (true){
                String[] userInputonArray =  reader.readLine().trim().split(" ");
                String command = userInputonArray[0].toLowerCase();

                switch (command){
                    case "start":
                        if (userInputonArray.length!=2)
                            writter.println("NOT ACCEPT: command's format incorrect");
                        else {
                            if (loged)
                                writter.println("NOT ACCEPT: Your are loged already");
                            else {
                                userName = userInputonArray[1];
                                writter.println("ACCEPT: Hello "+userName);
                                loged = true;
                            }
                        }
                        break;

                    case "status":
                        if (userInputonArray.length!=1)
                            writter.println("NOT ACCEPT: command's format incorrect");
                        else {
                            if (!loged)
                                writter.println("NOT ACCEPT: first you need to be loged");
                            else {
                                List<Seat> freeSeats = ReservationServer.getFreeSeats();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Free seats are: ");
                                for (Seat seat:freeSeats){
                                    sb.append(seat.getNumber()).append(", ");
                                }
                                writter.println(sb);
                            }
                        }
                        break;

                    case "book":
                        if (userInputonArray.length!=3)
                            writter.println("NOT ACCEPT: command's format incorrect");
                        else {
                            if (!loged)
                                writter.println("NOT ACCEPT: first you need to be loged");
                            else {
                                int seatNumber = Integer.parseInt(userInputonArray[1]);
                                String email = userInputonArray[2];
                                boolean plazasLibres = ReservationServer.canStillBuy();

                                if (plazasLibres){
                                    boolean sucess = ReservationServer.bookSeat(seatNumber,userName, email);
                                    if (sucess)
                                        writter.println("ACCEPT: Booked seat "+seatNumber);
                                    else
                                        writter.println("NOT ACCEPT: This seat is booked already");
                                }else
                                    writter.println("NOT ACCEPT: Don't have free seats already");
                            }
                        }
                        break;

                    case "undo":
                        if (userInputonArray.length!=2)
                            writter.println("NOT ACCEPT: command's format incorrect");
                        else {
                            if (!loged)
                                writter.println("NOT ACCEPT: first you need to be logged");
                            else {
                                int seatNumber = Integer.parseInt(userInputonArray[1]);
                                boolean sucess = ReservationServer.undoReservation(seatNumber,userName);

                                if (sucess)
                                    writter.println("ACCEPT: Canceled reservation of seat "+seatNumber);
                                else {
                                    writter.println("NOT ACCEPT: Something was wrong, check that seat is at your name");
                                }
                            }
                        }
                        break;

                    case "exit":
                        writter.println("ACCEPT: Good Bye "+userName);
                        System.out.println("Se ha desconectado un cliente");
                        break;

                    case "upload":
                        if (!loged)
                            writter.println("NOT ACCEPT: first you need to be logged");
                        else {
                            if (userName.equalsIgnoreCase("admin")){
                                boolean success = ReservationServer.createAndSendReport();

                                if (success)
                                    writter.println("ACCEPT: Report File was uploaded successfully");
                                else
                                    writter.println("NOT ACCEPT: Can't upload report File, check your programa putísimo inutil");
                            }else
                                writter.println("NOT ACCEPT: you are not an admin");
                        }
                        break;

                    default:
                        writter.println("NOT ACCEPT: unknown command");
                        break;
                }

                if (command.equalsIgnoreCase("exit"))
                    break;
            }

        } catch (IOException e) {
            System.out.println("Error en el worker del servidor: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
