package marcos.psp.exercise1;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Properties;

public class AppClient {
    public static void main(String[] args) {

        String sender = "cdelaisla88@gmail.com";
        String receiver="a24marcoscv@yopmail.com";



        //Obtiene el archivo de propiedades y las carga
        Properties props = null;
        try (InputStream input = new FileInputStream("src/main/resources/smtp.properties")) {
            props = new Properties();
            // load a properties file
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Session sesion = Session.getInstance(Objects.requireNonNull(props));

        try {
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(sender, "Marcos caetano"));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(receiver,"Marcos Caetano"));
            message.setSubject("hello from java");
            message.setText("Pablito clavo un clavito, que clavito clavó pablito");
            Transport.send(message);
            System.out.println("email sent");

        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
