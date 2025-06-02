package marcos.psp.examen.chuckNorris.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.chuckNorris.model.Joke;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SendChuckNorris implements Runnable{
    private final String sender;
    private final String receptor;
    private final Joke joke;

    public SendChuckNorris(String sender, String receptor, Joke joke) {
        this.sender = sender;
        this.receptor = receptor;
        this.joke = joke;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("se inicia proceso de envío de mensaje smtp");
        Properties props = new Properties();

        try (FileReader propsReader = new FileReader("src/main/resources/smtp.properties")){
            props.load(propsReader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades smtp");
            throw new RuntimeException(e);
        }
        String user = props.getProperty("mail.smtp.user");
        String password = props.getProperty("mail.smtp.password");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(sender));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
            message.setSubject("Chiste Chuck Norris");

            String content = "<h2>Chiste Chuck Norris</h2>" +
                    "<p>"+joke.getValue()+"<p>";

            message.setContent(content, "text/html");
            Transport.send(message);

            System.out.println("se finaliza proceso de envío de mensaje smtp");
        } catch (MessagingException e) {
            System.out.println("Error en la construcción del mensaje smtp: "+e.getMessage());
            throw new RuntimeException(e);
        }

    }
}
