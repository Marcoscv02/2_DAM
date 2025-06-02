package marcos.psp.examen.gessWord.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.gessWord.ftp.UploadMailsSFTP;
import marcos.psp.examen.gessWord.ftp.UploadMailsToFTP;
import marcos.psp.examen.trivialQuiz.ftp.UploadToFtp;
import marcos.psp.examen.trivialQuiz.ftp.UploadToSftp;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class SendReportMail implements Runnable{
    private boolean winner;
    private List<String> words;
    private String email;
    private String serverWord;

    public SendReportMail(boolean winner, List<String> words, String email, String serverWord) {
        this.winner = winner;
        this.words = words;
        this.email = email;
        this.serverWord = serverWord;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("se ha iniciado el envio del mensaje");
        Properties props = new Properties();

        try (FileReader propsReader = new FileReader("src/main/resources/smtp.properties")){
            props.load(propsReader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades");
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


        Message mensaje = new MimeMessage(session);
        try {
            InternetAddress[] recipents = {
                    new InternetAddress(email),
                    new InternetAddress("a24marcoscv@iessanclemente.net")
            };

            mensaje.setFrom(new InternetAddress(user));
            mensaje.setRecipients(Message.RecipientType.BCC, recipents);
            mensaje.setSubject("Reporte Wordle");

            //Definir distintos mensajes dependiendo de si el jugador ha ganado o perdido
            StringBuilder sb = new StringBuilder();
            for (String word : words){
                sb.append("<li>").append(word).append("</li>");
            }
            String mensajeGanador ="<h2>Game Report</h2>" +
                    "<p>Felicidades, has adivinado la palabra correcta en tan solo "+words.size()+" intentos</p>" +
                    "<h3>Estes han sido tus intentos</h3>" +
                    "<ol>"+sb+"</ol>" +
                    "<p>Palabra correcta: "+serverWord+"</p>";

            String mensajePerdedor ="<h2>Game Report</h2>" +
                    "<p>Lo sentimos, has agotado todas tus vidas sin adivinar cual era pa palabra correcta</p>" +
                    "<h3>Estes han sido tus intentos</h3>" +
                    "<ol>"+sb+"</ol>" +
                    "<p>La palabra correcta era: "+serverWord+"</p>";

            if (winner)
                mensaje.setContent(mensajeGanador, "text/html");
            else
                mensaje.setContent(mensajePerdedor, "text/html");

            Transport.send(mensaje);
            System.out.println("se ha completado el envío del mensaje");

            File file = new File("src/main/resources/gessWord/ReportHtmlEmails/"+email+"GameReport.html");

            File parentDirs = file.getParentFile();
            if (!parentDirs.exists())
                parentDirs.mkdirs();


            try (FileWriter fw = new FileWriter(file)){
                fw.write(mensaje.getContent().toString());
            } catch (IOException e) {
                System.out.println("Error en la escritura de los emails en un archivo: "+e.getMessage());
                throw new RuntimeException(e);
            }
            System.out.println("Se ha guardado un archivo en local con el contenido del mensaje");
            Thread uploadMailToSftpTask = new Thread(new UploadMailsSFTP(file));
            uploadMailToSftpTask.start();
//            Thread uploadMailToFtpTask = new Thread(new UploadMailsToFTP(file));
//            uploadMailToFtpTask.start();

        } catch (MessagingException e) {
            System.out.println("Error en la formación del mensaje smtp: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
