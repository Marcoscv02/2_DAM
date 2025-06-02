package marcos.psp.examen.gestorTareas.pop3;

import jakarta.mail.*;

import java.io.*;
import java.util.Properties;

public class GetMails implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Se ha iniciado el proceso getMails");
        Properties pop3Props = new Properties();

        try(FileReader reader= new FileReader("src/main/resources/pop3.properties")){
            pop3Props.load(reader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades de pop3");
            throw new RuntimeException(e);
        }

        Session session = Session.getInstance(pop3Props);

        try {
            //Conectarse al servidor pop3
            Store store = session.getStore("pop3");
            store.connect(
                    "cdelaisla88@gmail.com",
                    "pacafhgcorgkxgak"
            );

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messages = inbox.getMessages();

            int i = 0;
            for (Message m: messages){

                File f = new File("src/main/resources/gestorTareas/reportFiles/report"+i+".html");
                File parentFile = f.getParentFile();
                if (!parentFile.exists())
                    parentFile.mkdirs();

                try (FileWriter fw = new FileWriter(f)){
                    fw.write(m.getContent().toString());
                } catch (IOException e) {
                    System.out.println("Error en la escritura del archivo tras la obtención por pop3: "+e.getMessage());
                    throw new RuntimeException(e);
                }
                i++;
            }
            inbox.close(false);
            store.close();
            System.out.println("Se ha finalizado el proceso getMails");
        } catch (MessagingException e) {
            System.out.println("Error en la obtencion de mensajes pop3: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
