package marcos.psp.SMTP;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class exercise3 {
    public static void main(String[] args) {
        Properties props = new Properties();


        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream("src/main/resources/exercise3/smtp3.properties"))){
            props.load(is);

        } catch (IOException e) {
            System.out.println("Error en la carga de propiedades");
            throw new RuntimeException(e);
        }
        String user = props.getProperty("mail.smtp.user");
        String password = props.getProperty("mail.smtp.password");

        try {

            InternetAddress[] receptors = {
                    new InternetAddress("maroscvwork@gmail.com"),
                    new InternetAddress("a24marcoscv@iessanclemente.net"),
                    new InternetAddress("a24marcoscv@yopmail.com")
            };
            InternetAddress sender = new InternetAddress(user);

            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            //Definir las características generales del mensaje
            Message message= new MimeMessage(session);
            message.setFrom(sender);
            message.setRecipients(Message.RecipientType.BCC,receptors);
            message.setSubject("Ejercicio 3");

            MimeBodyPart mensajePart= new MimeBodyPart();
            String text =
                    "<h2>Hello everyone!</h2>" +
                            "<p>Today, we have another mini lesson about suffixes that talk about people. As you may know, 'suffixes' are little groups of letters that we put on the end of other words.</p>" +
                            "\n" +
                            "Professionals\n" +
                            "We can use the suffix '-er' to talk about a person who does something.\n" +
                            "\n" +
                            "teach - teacher\n" +
                            "learn - learner\n" +
                            "work - worker\n" +
                            "bank - banker\n" +
                            "dance - dancer\n" +
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
                            "Edwin"




        } catch (MessagingException e) {
            System.out.println("Error en el envio del mensaje");
            throw new RuntimeException(e);
        }
    }
}
