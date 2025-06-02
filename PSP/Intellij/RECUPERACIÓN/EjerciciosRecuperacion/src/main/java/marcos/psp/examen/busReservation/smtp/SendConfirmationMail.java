package marcos.psp.examen.busReservation.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.busReservation.model.Seat;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SendConfirmationMail implements Runnable{
    private Seat seat;

    public SendConfirmationMail(Seat seat) {
        this.seat = seat;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Iniciando envio de mail de confirmacion para "+seat.getUserName());
        Properties properties = new Properties();

        try(FileReader fr = new FileReader("src/main/resources/smtp.properties")){
            properties.load(fr);

        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades "+e.getMessage());
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.smtp.user");
        String password = properties.getProperty("mail.smtp.password");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        Message mensaje = new MimeMessage(session);
        try{
            mensaje.setFrom(new InternetAddress(user));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(seat.getEmail()));
            mensaje.setSubject("Confirmation booked email");

            String content = "<h2>Confirmation booked email</h2>" +
                    "<p>You was booked seat "+seat.getNumber()+" at name of "+seat.getUserName()+"<p>";

            mensaje.setContent(content, "text/html");

            Transport.send(mensaje);
            System.out.println("Se ha enviado el mail de confirmación correctamente a "+seat.getUserName());


        } catch (MessagingException e) {
            System.out.println("Error en la formación o el envio del mensaje "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
