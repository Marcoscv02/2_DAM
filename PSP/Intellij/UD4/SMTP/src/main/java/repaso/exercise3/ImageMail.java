package repaso.exercise3;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ImageMail {
    public static void main(String[] args) throws MessagingException, IOException {
        Properties properties =new Properties();

        InternetAddress[] receptors ={
                new InternetAddress("andreitaav909@gmail.com"),
                new InternetAddress("a24marcoscv@iessanclemente.net")
        };

        try (FileInputStream readProperties = new FileInputStream("src/main/resources/smtp.properties")){
            properties.load(readProperties);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.smtp.user");
        String pasword = properties.getProperty("mail.smtp.password");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,pasword);
            }
        });

        Message mensaje = new MimeMessage(session);
        mensaje.setFrom(new InternetAddress(user));


        mensaje.setRecipients(Message.RecipientType.CC, receptors);
        mensaje.setSubject("Hola prinsesa");


        MimeBodyPart htmlPart = new MimeBodyPart();
        String htmlText = "Hello Prinsesitaaaa.!\n" +
                "Estou estudiando e mandoche este correo desde un programa que fixen"+
                "Today, we have another mini lesson about suffixes that talk about people. As you may know, 'suffixes' are little groups of letters that we put on the end of other words.\n" +
                "\n" +
                "Professionals\n" +
                "We can use the suffix '-er' to talk about a person who does something.\n" +
                "\n" +
                "teach - teacher\n" +
                "learn - learner\n" +
                "work - worker\n" +
                "bank - banker\n" +
                "dance - dancer\n" +
                "\n" +
                "We can also use '-ist' with the same meaning.\n" +
                "\n" +
                "cycle - cyclist\n" +
                "psychology - psychologist\n" +
                "piano - pianist\n" +
                "guitar - guitarist\n" +
                "art - artist\n" +
                "Unfortunately, there's no easy way to know which ending to use with each word. We just need to learn the forms.\n" +
                "\n" +
                "I kope that helps, and really good luck with your English!\n" +
                "\n" +
                "\n" +
                "Edwin";
        htmlPart.setContent(htmlText, "text/html");

        MimeBodyPart attachedImage = new MimeBodyPart();
        attachedImage.attachFile("src/main/resources/exercise3/img_1.png");
        attachedImage.setContentID("ProfessionalImage");
        attachedImage.setDisposition(MimeBodyPart.INLINE);


        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(htmlPart);
        multipart.addBodyPart(attachedImage);

        mensaje.setContent(multipart);
        Transport.send(mensaje);
        System.out.println("Mensaje enviado con éxito");
    }
}
