package marcos.psp.clemenRaffle_examen.email;

import jakarta.mail.*;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.clemenRaffle_examen.model.Winner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class SendMail implements Runnable{
    Winner winner;
    boolean testCredentials;

    public SendMail(Winner winner, boolean testCredentials) {
        this.winner = winner;
        this.testCredentials = testCredentials;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        Properties properties= new Properties();

        try(FileInputStream is = new FileInputStream("src/main/resources/clemenRaffle/mail.properties")){
            properties.load(is);

        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades");
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.smtp.user");
        String password= properties.getProperty("mail.smtp.password");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }

}
