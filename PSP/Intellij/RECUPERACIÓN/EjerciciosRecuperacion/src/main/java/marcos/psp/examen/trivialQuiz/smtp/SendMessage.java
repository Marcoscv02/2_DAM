package marcos.psp.examen.trivialQuiz.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import marcos.psp.examen.trivialQuiz.ftp.UploadToFtp;
import marcos.psp.examen.trivialQuiz.model.report.QuestionReport;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

public class SendMessage implements Runnable{
    private Socket socket;
    private String email;
    private List<QuestionReport> resultados;

    public SendMessage(Socket socket, String email, List<QuestionReport> resultados) {
        this.socket = socket;
        this.email = email;
        this.resultados = resultados;
    }


    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Se está procesando el envío de un mensaje smtp");
        Properties props = new Properties();

        try (BufferedReader propsReader = new BufferedReader(new FileReader("src/main/resources/Trivial/smtp.properties"))){
            props.load(propsReader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades SMTP: "+e.getMessage());
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

        try{
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(user));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            mensaje.setSubject("Resultados trivial");

            //Este stringBuilder sirve para mostrar todas las preguntas en una lista y mostrar si han sido acertadas o no
            StringBuilder printResults = new StringBuilder();
            for (QuestionReport qr: resultados){

                printResults.append("<li>");
                printResults.append("<p>").append(qr.getQuestion().getQuestion()).append("</p>");

                if (qr.getAcertada())
                    printResults.append("<p>").append("acertada").append("</p>");
                else
                    printResults.append("<p>").append("no acertada").append("</p>");
                printResults.append("</li>");
            }

            String contenidoMensaje =
                    "<h2>Resultados trivial</h2>"+
                            "<ul>"+
                            printResults+
                            "</ul>"+
                            "<p>Juud bye pringaooo</p>"
                    ;
            mensaje.setContent(contenidoMensaje, "text/html");


            File f = new File("src/main/resources/Trivial/ReportHtmlFiles/Report_"+email+".html");

            BufferedWriter writter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8));
            writter.write(contenidoMensaje);
            System.out.println("Guardando archivo.html con el mensaje enviado");;
            writter.close();
            Transport.send(mensaje);

            Thread ftpTask = new Thread(new UploadToFtp(f));
            ftpTask.start();
//            Thread sftpTask = new Thread(new UploadToSftp(f));
//            sftpTask.start();

        } catch (AddressException e) {
            System.out.println("Error en la direccion del emisor del mensaje smtp: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            System.out.println("Error en la formación del mensaje smtp: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error en la creacion del archivo con el mensaje HTML: "+e.getMessage());
            throw new RuntimeException(e);
        }

    }


    private static void createMessageFile (String htmlContent) throws IOException {

    }
}
