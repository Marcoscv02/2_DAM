package marcos.psp.examen.clemenRaffle_examen.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.clemenRaffle_examen.ftp.SaveMessgesOnServer;
import marcos.psp.examen.clemenRaffle_examen.model.Ticket;
import marcos.psp.examen.clemenRaffle_examen.model.Winner;

import java.io.*;
import java.util.Properties;

public class SendMail implements Runnable{
    String text;
    Winner winner;
    Ticket ticket;
    boolean testCredentials;


    public SendMail() {
    }

    public SendMail(Winner winner, Ticket ticket, boolean testCredentials) {

        this.winner = winner;
        this.ticket = ticket;
        this.testCredentials = testCredentials;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Se envía mensaje de resolución a jugador "+ticket.getClientName());

        //configuracion de propiedades
        Properties properties = new Properties();
        try (FileInputStream is = new FileInputStream("src/main/resources/clemenRaffle/mail.properties")) {
            properties.load(is);

        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades");
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.smtp.user");
        String password = properties.getProperty("mail.smtp.password");

        //Configuración de session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        if (winner.getTicket().equals(ticket))
            text = "<h2>Resolución clemenRaffle</h2>" +
                    "<p>has ganado</p>";
        else
            text = "<h2>Resolución clemenRaffle</h2>" +
                    "<p>has perdido</p>";




        //Configuración y envío del mensaje
        Message mensaje = new MimeMessage(session);
        try {
            mensaje.setSubject("Resolución clemenRaffle");
            mensaje.setFrom(new InternetAddress(user));

            InternetAddress [] receptors = {
                    new InternetAddress("a24marcoscv@yopmail.com"),
                    new InternetAddress(ticket.getClientName()+"@yopmail.com")
            };

            mensaje.setRecipients(Message.RecipientType.BCC, receptors);
            mensaje.setContent(text, "text/html");
            Transport.send(mensaje);
        } catch (MessagingException e) {
            System.out.println("Error en la formación del mensaje de correo electrónico");
            throw new RuntimeException(e);
        }
        System.out.println("Se han enviado todos los mensajes");

        File file = new File("src/main/resources/clemenRaffle/savedMessages/ResultTicket"+ticket.getValue()+".html");

        try {
            FileWriter writter = new FileWriter(file);
            writter.write(text);
        } catch (IOException e) {
            System.out.println("Error en la escritura del archivo que contiene el mensaje "+e.getMessage());
            throw new RuntimeException(e);
        }

        new Thread(new SaveMessgesOnServer(file)).start();
    }
}
