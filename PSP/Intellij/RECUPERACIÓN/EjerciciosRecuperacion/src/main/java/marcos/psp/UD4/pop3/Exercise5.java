package marcos.psp.UD4.pop3;

import jakarta.mail.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Exercise5 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try(FileReader propsReader = new FileReader("src/main/resources/pop3.properties")){
            properties.load(propsReader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades: "+e.getMessage());
            throw new RuntimeException(e);
        }

        String user = "cdelaisla88@gmail.com";
        String password = "pacafhgcorgkxgak";

        Session session = Session.getDefaultInstance(properties);

        try {
            Store store = session.getStore("pop3");
            store.connect(user,password);

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                System.out.println("Asunto: " + message.getSubject());
                System.out.println("Contenido: " + message.getContent().toString());
            }

            folder.close();
            store.close();
        } catch (MessagingException e) {
            System.out.println("Error en la recopilación de correos por pop3: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
