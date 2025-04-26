package marcos.psp.UD4.SMTP;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

public class Exercise3 {
    public static void main(String[] args) {
        Properties props = new Properties();


        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream("src/main/resources/exercise3/smtp.properties"))){
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

            //Parte de la imagen
            String cid = UUID.randomUUID().toString();
            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.attachFile("src/main/resources/exercise3/professionals.png");
            imagePart.setContentID("<"+cid+">");
            imagePart.setDisposition(MimeBodyPart.INLINE);

            //Parte del texto
            MimeBodyPart mensajePart= new MimeBodyPart();
            String text =
                    "<h2>Hello everyone!</h2>" +
                            "<p>Today, we have another mini lesson about suffixes that talk about people. As you may know, 'suffixes' are little groups of letters that we put on the end of other words.</p>" +

                            "<img src=\"cid:"+cid+"\"/>"+//Asociar CID de la imagen en la etiqueta html

                            "<p>We can use the suffix '-er' to talk about a person who does something.</p>" +

                            "<ul>"+
                                "<li>teach - teacher</li>"+
                                "<li>learn - learner</li>"+
                                "<li>work - worker</li>"+
                                "<li>bank - banker</li>"+
                                "<li>dance - dancer</li>"+
                            "</ul>"+

                            "We can also use '-ist' with the same meaning.\n" +
                            "<ul>"+
                                "<li>cycle - cyclist</li>"+
                                "<li>psychology - psychologist</li>"+
                                "<li>piano - pianist</li>"+
                                "<li>guitar - guitarist</li>"+
                                "<li>art - artist</li>"+
                            "</ul>"+
                            "<p>Unfortunately, there's no easy way to know which ending to use with each word. We just need to learn the forms.</p>" +

                            "<p>I kope that helps, and really good luck with your English!</p></br>" +

                            "<p>Edwin</p>";
            mensajePart.setContent(text,"text/html");

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(mensajePart);
            multipart.addBodyPart(imagePart);

            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Mensaje enviado con éxito");

        } catch (MessagingException e) {
            System.out.println("Error en el envio del mensaje");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

