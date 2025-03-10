package repaso.exercise4;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class Code64AppMail {
    public static void main(String[] args) {
        Properties props = new Properties();

        try(FileInputStream readProperties = new FileInputStream("src/main/resources/smtp2.properties")){
            props.load(readProperties);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String user = props.getProperty("mail.smtp.user");
        String password = props.getProperty("mail.smtp.password");


        try {
            InternetAddress [] receptors = {
                    //new InternetAddress("a24marcoscv@iessanclemente.net"),
                    //new InternetAddress("marcoscvwork@gmail.com"),
                    new InternetAddress("a24marcoscv@outlook.com"),
                    new InternetAddress("a24marcoscv@yopmail.com")
                    };

            InternetAddress sender = new InternetAddress(user);


            Session session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user,password);
                }
            });

            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(sender);
            mensaje.setSubject("Exercise4");
            mensaje.setRecipients(Message.RecipientType.CC, receptors);

            File file=new File("src/main/resources/exercise4/transports.png");
            FileInputStream imageInFile = new FileInputStream(file);
            byte imageData[] = new byte[(int)file.length()];
            imageInFile.read(imageData);
            String imageB64= Base64.getEncoder().encodeToString(imageData);

            MimeBodyPart htmlPart = new MimeBodyPart();
            String textPart = "<h2>Hello everyone!</h2>" +
                    "<p>Let's talk about when we use 'the' with transport.</p>" +

                    "<img src=\"data:image/png;base64, "+imageB64+"\" />" +


                    "<p>First, we often use the when we are talking about a form of transport as a general idea." +
                    "We usually do this with public transport (not with cars or bikes) and we usually useverbs such" +
                    " as take, be on, get on and get off:</p>" +

                    "<ul>" +
                    "<li>We took the bus to school.</li>" +
                    "<li>Julie's on the train at the moment.</li>" +
                    "<li>She gets off the underground in central London.</li>" +
                    "</ul>" +

                    "<p>In all of these examples, I'm not talking about a particular bus, train or plane but rather the system of transport as an idea.</p>" +

                    "<p>However, we use 'no article' when we use a form of transport with by:</p>" +

                    "<ul>" +
                    "<li>We travelled by plane.</li>" +
                    "<li>He goes to work by bus.</li>" +
                    "<li> We went to Scotland by train.</li>" +
                    "</ul>" +

                    "<p>Remember, we can't say 'by foot' or 'by feet' when we're talking about walking. We say 'on foot' (also no article)</p>" +

                    "<p>I hope that helps, and really good luck with your English!</p>" +

                    "<p>Pam</p>";
            htmlPart.setContent(textPart, "text/html");

            MimeMultipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);

            mensaje.setContent(multipart);
            Transport.send(mensaje);
            System.out.println("Mensaje enviado con éxito");



        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}
