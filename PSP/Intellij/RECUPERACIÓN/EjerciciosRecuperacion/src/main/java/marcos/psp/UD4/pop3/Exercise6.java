package marcos.psp.UD4.pop3;

import jakarta.mail.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Exercise6 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try(FileReader propsReader = new FileReader("src/main/resources/exercise6/pop3Ex6.properties")) {
            properties.load(propsReader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades pop3");
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.pop3.user");
        String password = properties.getProperty("mail.pop3.password");

        Session session = Session.getDefaultInstance(properties);

        try {
            Store store = session.getStore("pop3");
            store.connect(user,password);

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message[] messages=folder.getMessages();
            for (int i = 0; i < messages.length; i++) {
                Message message=messages[i];
                System.out.println("Subject:"+ message.getSubject());
                System.out.println("Text:"+message.getContent().toString());
            }
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
