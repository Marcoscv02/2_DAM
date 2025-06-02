package marcos.psp.examen.gestorTareas.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.gestorTareas.model.Task;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SendMailToBoss implements Runnable{
    private Task task;

    public SendMailToBoss(Task task) {
        this.task = task;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Iniciado el proceso sendMails");
        Properties properties = new Properties();

        try (FileReader propsReader = new FileReader("src/main/resources/smtp.properties")){
            properties.load(propsReader);

        } catch (IOException e) {
            System.out.println("Error en la lectura de propiedades smtp: "+e.getMessage());
            throw new RuntimeException(e);
        }

        String user = properties.getProperty("mail.smtp.user");
        String password = properties.getProperty("mail.smtp.password");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user));
            message.setSubject("Tarea completada");

            String content = "<h2>Empleado "+task.getWorker()+" ha completado su tarea</h2>" +
                    "<h4>Name</h4>" +
                    "<p>"+task.getName()+"</p>" +
                    "<h4>Description</h4>" +
                    "<p>"+task.getDescripcion()+"</p>"+
                    "<p>La tarea ha sido realizada</p>";

            message.setContent(content, "text/html");
            Transport.send(message);
            System.out.println("finalizado el proceso sendMails");

            //Este código se encargaría de crear un archivo de cada mail y guardarlo, lo use para omitir pop3
//            File f = new File("src/main/resources/gestorTareas/reportFiles/reportTask"+task.getId()+".html");
//            File parentFile = f.getParentFile();
//            if (!parentFile.exists())
//                parentFile.mkdirs();
//
//            try (FileWriter fw = new FileWriter(f)){
//                fw.write(content);
//            } catch (IOException e) {
//                System.out.println("Error en la escritura del archivo tras la obtencion por pop3: "+e.getMessage());
//                throw new RuntimeException(e);
//            }

        } catch (MessagingException e) {
            System.out.println("Error en el envío del mensaje smtp "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
