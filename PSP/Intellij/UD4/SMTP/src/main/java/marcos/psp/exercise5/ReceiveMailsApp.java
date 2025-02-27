package marcos.psp.exercise5;

import jakarta.mail.*;

import java.io.*;
import java.util.Properties;

public class ReceiveMailsApp {


    public static void main(String[] args) {
        Properties props = new Properties();

        try (InputStream inputStream= new FileInputStream("src/main/resources/smtp3.properties")){
            props.load(inputStream);

        } catch (IOException e) {
            System.out.println("Error al cargar las propiedades");
            throw new RuntimeException(e);
        }

        String user = props.getProperty("mail.smtp.user");
        String password = props.getProperty("mail.smtp.password");

        Session session= Session.getDefaultInstance(props);

        try {
            //Conectarse al servidor a
            Store store= session.getStore("pop3");
            store.connect(user,password);

            //Se accede a la carpeta con todos los mensajes y se dan permisos solo de lectura
            Folder folder= store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            int contador=0;
            Message [] mensajes = folder.getMessages();
            for (Message m: mensajes){
                System.out.println("Mensaje "+contador+":\n" +
                        "Asunto: "+m.getSubject());
            }

            System.out.println("Todos los mensajes se han obtenido con éxito");

            folder.close();
            store.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
