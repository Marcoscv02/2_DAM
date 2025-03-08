package marcos.psp.exercise6;

import jakarta.mail.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReceiveMailsApp {
    public static void main(String[] args) {
        Properties properties = new Properties();

        try (FileInputStream propertisReader = new FileInputStream("src/main/resources/imap.properties")){
           properties.load(propertisReader);

        } catch (IOException e) {
            System.out.println("Error en la carga de propiedades");
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.user");
        String passsword = properties.getProperty("mail.password");

        Session session = Session.getDefaultInstance(properties);
        try {
            Store store = session.getStore("imap");
            store.connect(user, passsword);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] correos = inbox.getMessages();

            for (Message m: correos){
                System.out.println("Asunto:"+m.getSubject());
            }


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
