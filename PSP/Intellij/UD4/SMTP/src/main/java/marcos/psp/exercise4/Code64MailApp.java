package marcos.psp.exercise4;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.io.*;
import java.util.Base64;
import java.util.Properties;

public class Code64MailApp {
    public static void main(String[] args) {
        Properties props = new Properties();

        //Se carga el archivo de propiedades con el objeto propiedades ya creado e instanciado;
        try(InputStream input = new FileInputStream("src/main/resources/smtp2.properties")){
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Se obtienen del archivo de propiedades el usuario y la contraseña desde la que mandamos el correo
        String user= props.getProperty("mail.smtp.user");
        String password= props.getProperty("mail.smtp.password");

        //Se crea una sesion con las propiedades y generando un nuevo authenticator al que tendemos que insertar el nombre y la contraseña
        Session session= Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
        try{//Se crea el objeto mensaje y se introduce como parámetro la sesión
            MimeMessage mensaje= new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(user));
            //Se envia copia oculta a las cuentas de yopmail y outloook
            mensaje.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(
                    "a24marcoscv@yopmail.com, a24Marcoscv@outlook.com"
                    ));
            mensaje.setSubject("Learning about transport");


            //Convertir la imagen en un array de byte para convertir posteriormente a base 64
            File file= new File("src/main/resources/exercise4/transports.png");
            FileInputStream fis= new FileInputStream(file);
            byte[] imageData = new byte[(int) file.length()];
            fis.read(imageData);
            String base64Image = Base64.getEncoder().encodeToString(imageData);

            //Primera parte de html
            MimeBodyPart text1= new MimeBodyPart();
            String html1 = "<h1>Hello Everione!</h1><br>"+
                    "<p>Lets's talk about when we use 'the' with transport</p>"+
                    "<img src=\"data:image/png;base64," + base64Image + "\"/>"
                    ;
            text1.setContent(html1, "text/html");

            //segundo html
            MimeBodyPart text2= new MimeBodyPart();
            String html2=
                    "<p>First, we often use the when we are talking about a form of transport as a general idea." +
                            "We usually do this with public transport (not with cars or bikes) and we usually " +
                            "useverbs such as take, be on, get on and get off:</p>" +
                            "<ul><li>We took the bus to school.</li>\n" +
                            "<li>Julie's on the train at the moment.</li>\n" +
                            "<li>She gets off the underground in central London.</li></ul>\n" +
                            "In all of these examples, I'm not talking about a particular bus, train or plane but rather the system of transport as an idea.\n" +
                            "However, we use 'no article' when we use a form of transport with by:\n" +
                            "\n" +
                            "<ul><li>We travelled by plane.</li>\n" +
                            "<li>He goes to work by bus.</li>\n" +
                            "<li>We went to Scotland by train.</li></ul>\n" +
                            "Remember, we can't say <del>'by foot'</del> or <del>'by feet'</del> when we're talking about walking. We say 'on foot' (also no article)\n" +
                            "\n" +
                            "I hope that helps, and really good luck with your English!\n" +
                            "\n" +
                            "\n" +
                            "Pam";;
            text2.setContent(html2, "text/html");

            //Multipart par unir todas las partes
            MimeMultipart multipart= new MimeMultipart();
            multipart.addBodyPart(text1);
            multipart.addBodyPart(text2);

            //Enviar mensaje
            mensaje.setContent(multipart);
            Transport.send(mensaje);
            System.out.println("Mensaje con codificacion64 enviado con éxito");

        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
