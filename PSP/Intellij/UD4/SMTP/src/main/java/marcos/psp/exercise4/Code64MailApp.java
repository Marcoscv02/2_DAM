package marcos.psp.exercise4;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;

import java.io.*;
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

            //Se envia el mensaje normal a la cuenta de outloook
            mensaje.setRecipients(Message.RecipientType.TO, "a24Marcoscv@outlook.com");
            //Se envia copia oculta a las cuentas de yopmail y gmail
            mensaje.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(
                    "a24marcoscv@yopmail.com, a24marcoscv@iessanlemente.net"
                    ));

            MimeBodyPart text1= new MimeBodyPart();
            String html1 = "<h1>Hello Everione!</h1><br>"+
                    "<p>Lets's talk about when we use 'the' with transport</p><br>";
            text1.setContent(html1, "text/html");

            MimeBodyPart imagen= new MimeBodyPart();
            imagen.attachFile("src/main/resources/exercise4/transports.png");
            imagen.setContentID("<TransportImagen>");
            imagen.setDisposition(Part.INLINE);

            MimeBodyPart text2= new MimeBodyPart();
            String html2= "<p>First, we often use the when we are talking about a form of transport as " +
                    "a general idea.We usually do this with public transport (not with cars or bikes) and " +
                    "we usually useverbs such as take, be on, get on and get off:</p><br>"+

                    "<p>-  We took the bus to school.</p><br>" +
                    "<p>-  Julie's on the train at the moment.</p><br>" +
                    "<p>-  She gets off the underground in central London.</p><br>"+

                    "<p>In all of these examples, I'm not talking about a particular bus, train or plane but " +
                    "rather the system of transport as an idea.</p><br>"
                    ;

        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}
