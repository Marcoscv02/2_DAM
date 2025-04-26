package marcos.psp.UD4.SMTP;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class Exercise4 {
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

        try {
            InternetAddress[] recipents = {
                    new InternetAddress("andreitaav909@gmail.net"),
                    new InternetAddress("marcoscvwork@gmail.com"),
                    new InternetAddress("a24marcoscv@iessanclemente.net")
            };

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.CC,recipents);
            message.setSubject("Imagen codificada base64");

            File file = new File("src/main/resources/exercise4/DSC_0859.JPG");
            byte[] imageData = new byte[(int) file.length()];
            String imageBase64 = Base64.getEncoder().encodeToString(imageData);

            MimeBodyPart textPart= new MimeBodyPart();
            String text =
                    "<h1>Holaaaaaa</h1>"+
                    "<p>Aqui vai unha foto codificada en base64, xa sei que non sabes o que é, pero estou facendo pruebas</p>"+
                    "<img src=\"data:image/jpg;base64, imageBase64\"/>"+
                    "<p>Estouno facendo desde un programa que fixen porque teño que aprobar para irnos por ahi en veranio jajajajja:)</p>";


            textPart.setContent(text, "text/html");

            MimeMultipart multipart= new MimeMultipart();
            multipart.addBodyPart(textPart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Mensaje enviado con éxito");

        } catch (MessagingException e) {
            System.out.println("Error en el envio del mensaje");
            throw new RuntimeException(e);
        }
    }
}
