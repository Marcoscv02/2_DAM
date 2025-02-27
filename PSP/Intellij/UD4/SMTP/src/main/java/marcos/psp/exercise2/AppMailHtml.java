package marcos.psp.exercise2;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class AppMailHtml {
    //Declarar emisor y receptor del mensaje
    public static final String SENDER = "cdelaisla88@gmail.com";
    public static final String RECEIVER = "a24marcoscv@yopmail.com";

    public static void main(String[] args) {

        //Obtiene el archivo de propiedades y las carga
        Properties props = null;
        try (InputStream input = new FileInputStream("src/main/resources/smtp.properties")) {
            props = new Properties();
            // load a properties file
            props.load(input);

            //Crear sesion
            Session sesion = Session.getInstance(Objects.requireNonNull(props));

            //Crear mensaje
            Message message = new MimeMessage(sesion);

            //Emisor
            message.setFrom(new InternetAddress(SENDER, "Marcos caetano"));
            //Receptor
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(RECEIVER,"Marcos Caetano"));
            //Asunto del mensaje
            message.setSubject("hello from java");

            //Crear la parte mensaje html
            MimeBodyPart cuerpoMensaje= new MimeBodyPart();
            String htmlContent = "<h1>Este es un documento html</h1>"
                    + "<p>Este correo contiene un adjunto y se envía usando TLS.</p>";
            cuerpoMensaje.setContent(htmlContent,"text/html");


            //Crear la parte del adjunto
            MimeBodyPart adjunto= new MimeBodyPart();
            adjunto.attachFile(new File("src/main/resources/exercise2/WindowsProcesses.pdf"));


            MimeMultipart multipart= new MimeMultipart();
            multipart.addBodyPart(cuerpoMensaje);
            multipart.addBodyPart(adjunto);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("email sent");

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
