package marcos.psp.examen.jokes.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.jokes.model.Joke;

import java.io.*;
import java.util.Properties;

public class SendJokeMail implements Runnable{
    private String email;
    private Joke joke;

    public SendJokeMail(String email, Joke joke) {
        this.email = email;
        this.joke = joke;
    }


    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        Properties props = new Properties();
        try (FileReader reader = new FileReader("src/main/resources/smtp.properties")){
            props.load(reader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades smtp: "+e.getMessage());
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
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            message.setSubject("Your new Funny Joke :)");

            if (joke.getType().equalsIgnoreCase("single")) {
                String singlePart = "<h2>Jooooookeeeeeee</h2>" +
                        "<p>"+joke.getJoke()+"</p>";

                message.setContent(singlePart, "text/html");

            }else {
                String twoPart = "<h2>Jooooookeeeeeee</h2>"+
                        "<p>"+joke.getSetup()+"</p>"+
                        "<p>"+joke.getDelivery()+"</p>";

                message.setContent(twoPart, "text/html");
            }

            Transport.send(message);
            System.out.println("Mensaje enviado con éxito");

        } catch (MessagingException e) {
            System.out.println("Error en la construcción del mensaje smtp: "+e.getMessage());
            throw new RuntimeException(e);
        }

        File file= new File("src/main/resources/jokeApp/joke"+joke.getId()+".html");
        File parentFile = file.getParentFile();

        if (!parentFile.exists())
            parentFile.mkdirs();

        try (FileWriter jokeWritter = new FileWriter(file)){
            jokeWritter.write(message.getContent().toString());

        } catch (IOException|MessagingException e) {
            System.out.println("Error en la excritura del archivo.html: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
