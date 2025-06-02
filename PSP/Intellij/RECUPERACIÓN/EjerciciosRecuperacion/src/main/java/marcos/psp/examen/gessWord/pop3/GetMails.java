package marcos.psp.examen.gessWord.pop3;

import jakarta.mail.*;

import java.io.*;
import java.util.Properties;

public class GetMails implements Runnable{
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        Properties props = new Properties();
        try(FileReader pop3Reader = new FileReader("src/main/resources/pop3.properties")){
            props.load(pop3Reader);
        } catch (IOException e) {
            System.out.println("Error de lectura en el archivo de propiedades de pop3: "+e.getMessage());
            throw new RuntimeException(e);
        }

        Session session = Session.getInstance(props);
        try {
            Store store = session.getStore();
            store.connect("r0ex1c0x@mailosaur.net", "ilFsQ4Mdvwl00haQbGMlee57YTWqDulg");

            Folder folder=store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message[] messages=folder.getMessages();

            for (int i = 0; i < messages.length; i++) {
                File f = new File("src/main/resources/gessWord/ReportHtmlEmails/mensaje"+i+".html");

                try(FileWriter fw = new FileWriter(f)){
                    fw.write(messages[i].getContent().toString());
                } catch (IOException e) {
                    System.out.println("Erro en la escritura de los emails obtenidos por pop 3 en un archivo: "+e.getMessage());
                    throw new RuntimeException(e);
                }

            }
        } catch (MessagingException e) {
            System.out.println("error en la obtención de correos con pop3");
            throw new RuntimeException(e);
        }
    }
}
