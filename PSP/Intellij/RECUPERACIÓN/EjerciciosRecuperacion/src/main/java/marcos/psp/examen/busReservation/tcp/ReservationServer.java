package marcos.psp.examen.busReservation.tcp;

import marcos.psp.examen.busReservation.ftp.UploadReportToServer;
import marcos.psp.examen.busReservation.ftp.UploadedReportToSftpServer;
import marcos.psp.examen.busReservation.model.Seat;
import marcos.psp.examen.busReservation.smtp.SendConfirmationMail;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ReservationServer {
    public static final int PORT = 59999;
    public static final int SEAT_LIMIT = 10;
    public static List<Seat> seats = new ArrayList<>();

    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        //Se inician los asientos, disponibles todos en un principio
        for (int i = 0; i < SEAT_LIMIT; i++) {
            Seat seat = new Seat(i+1);
            seats.add(seat);
        }


        try (SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(PORT)){

            System.out.println("Servidor escuchando en puerto "+PORT);
            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Se ha conectado un nuevo cliente");

                Thread th = new Thread(new ReservationServerWorker(clientSocket,seats));
                th.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo que devuelve un array con todos los sitios libre que hay en el bus
     * @return Array of Seats
     */
    public synchronized static List<Seat> getFreeSeats(){
        List<Seat> freeSeats = new ArrayList<>();

        for (Seat seat: seats){
            if (seat.isFree())
                freeSeats.add(seat);
        }
        return freeSeats;
    }

    /**
     * Metodo que se encarga de reservar un sitio
     * @param numSeat
     * @param name
     */
    public synchronized static boolean bookSeat (int numSeat, String name, String email){
        if(numSeat>seats.size()){
            return false;
        }else {
            Seat seat = seats.get(numSeat-1);
            if (seat.isFree()){

                seat.setFree(false);
                seat.setUserName(name);
                seat.setEmail(email);
                new Thread(new SendConfirmationMail(seat)).start();
                System.out.println("Asiento reservado "+seat);
                return true;
            }else {
                System.out.println("No se ha realizado la operación porque este asiento ya esta cogido");
                return false;
            }
        }
    }

    /**
     * Metodo para cancelar una reserva
     * @param numSeat
     * @param name
     * @return success
     */
    public  synchronized static boolean undoReservation(int numSeat, String name){
        for (Seat seat: seats){
            if (seat.getNumber() == numSeat){
                if (seat.getUserName().equalsIgnoreCase(name)){
                    seat.setUserName(null);
                    seat.setFree(true);
                    new Thread( new SendConfirmationMail(seat)).start();
                    System.out.println("Se ha reservado el asienyo "+seat);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo que comprueba si el autobús ya está lleno
     * @return boolean lleno
     */
    public synchronized  static  boolean canStillBuy (){
        if (seats.size()<=SEAT_LIMIT)
            return true;
        else
            return false;
    }


    /**
     * Metodo para crear el archivo de reporte y llamar al hilo encargado de subirlo al servidor
     * @return boolean success
     */
    public synchronized static boolean createAndSendReport (){
        System.out.println("Se accede al método createAndSendReport");
        File reportFile = new File("src/main/resources/busReservation/reportFiles/report.txt");

        //Crear la ruta del archivo en caso de que esta no existiese
        File filePath = reportFile.getParentFile();
        if (!filePath.exists())
            filePath.mkdirs();


        //Escribir el reportSb en el archivo que enviaremos al hilo ftp
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(reportFile));){
            bw.write("Reporte de reservas para este bus: ");
            bw.newLine();
            for (Seat seat: seats){
                bw.write(seat.toString());
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error en la escritura del archivo");
            throw new RuntimeException(e);
        }

//        FutureTask<Boolean> future = new FutureTask<>(new UploadReportToServer(reportFile));
//        future.run();
        FutureTask<Boolean> futuresftp = new FutureTask<>(new UploadedReportToSftpServer(reportFile));
        futuresftp.run();

        //Obtener la respuesta del hilo que nos dirá si la operación se ha realizado correctamente o no
        try {
            return futuresftp.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error en la obtención del resultado del hilo encargado de subir los archivos ftp: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
