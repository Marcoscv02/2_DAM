package marcos.psp.UD4.SMTP;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Exercise2 {
    public static void main(String[] args) {
        Properties props = new Properties();
        try(FileInputStream fis = new FileInputStream("src/main/resources/smtp.properties")){
            props.load(fis);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades");
            throw new RuntimeException(e);
        }

        String user = props.getProperty("mail.smtp.user");
        String password = props.getProperty("mail.smtp.password");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress("a24marcoscv@iessanclemente.net"));
            message.setSubject("Prueba archivo adjunto");

            MimeBodyPart textPart= new MimeBodyPart();
            String text =
                    "<h3>Envio archivo adjunto</h3>"+
                    "<p>Esto es una prueba de envio de un archivo adjunto</p>";
            textPart.setContent(text, "text/html");

            MimeBodyPart attachFile = new MimeBodyPart();
            attachFile.attachFile("src/main/resources/exercise2/DU4-NetworkServices.pdf");

            MimeMultipart multipart = new MimeMultipart(textPart,attachFile);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Mensaje enviado con éxito");

        } catch (MessagingException | IOException e) {
            System.out.println("Error en el envio del mensaje");
            throw new RuntimeException(e);
        }
    }
}
