package marcos.psp.exercise3;

import jakarta.mail.*;
import jakarta.mail.internet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppMailImage {
    //Se declara la lista de los receptores de nuestro mensaje
    public static InternetAddress[] receptors;
    //Se añaden valores al array
    static {
        try {
            receptors = new InternetAddress[]{
                    new InternetAddress("a24Marcoscv@outlook.com"),
                    new InternetAddress("a24marcoscv@yopmail.com"),
                    new InternetAddress("a24marcoscv@iessanclemente.net")

            };
        } catch (AddressException e) {
            System.out.println("Error al declarar la lista de receptores");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        //se carga el archivo de propiedades que configurará nuestra sesión
        try (InputStream input= new FileInputStream("src/main/resources/smtp2.properties")){
            Properties prop= new Properties();
            prop.load(input);

            //Declarar contraseña y usuario
            String  user = prop.getProperty("mail.smtp.user");
            String  passsword = prop.getProperty("mail.smtp.password");

            //Se crea una sesion con nombre de usuario y contraseña a traves del objeto Authenticator
            Session session= Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user,passsword);
                }
            });

            //Aquí se creará mensaje y se añadirán sus repectivas partes
            try{
                //Aquí se crea el objeto mensaje y se declaran los receptores a quienes va dirigido
                MimeMessage mensaje= new MimeMessage(session);
                mensaje.setFrom(new InternetAddress(user));
                mensaje.setRecipients(Message.RecipientType.TO,receptors);

                //Aqui se añade la primera parte del mensaje de texto que precederá a la imagen
                MimeBodyPart textpart1= new MimeBodyPart();
                String htmlContent1 = "<h1>Hello everyone!</h1>" +
                        "<p>Today, we have another mini lesson about suffixes that talk about people. " +
                        "As you may know, 'suffixes' are little groups of letters that we put on the end " +
                        "of other words.</p>";
                textpart1.setContent(htmlContent1,"text/html");


                //Aquí se añade la imagen que irá dentro del mensaje
                MimeBodyPart imagen= new MimeBodyPart();
                imagen.attachFile("src/main/resources/exercise3/email-embed-image.png");
                imagen.setContentID("<ProfesionalsImagen>");
                imagen.setDisposition(MimeBodyPart.INLINE);


                //Aquí se crea la segunda parte en texto del mensaje que irá después de la imagen
                MimeBodyPart textpart2= new MimeBodyPart();
                String htmlContent2 =
                        "<p>We can use the suffix '-er' to talk about a person who does something.</p><br>" +

                        "<p>teach - teacher</p>" +
                        "<p>learn - learner</p>" +
                        "<p>work - worker</p>" +
                        "<p>bank - banker</p>" +
                        "<p>dance - dancer</p><br>" +

                        "<p>We can also use '-ist' with the same meaning.</p><br>" +

                        "<p>cycle - cyclist</p>" +
                        "<p>psychology - psychologist</p>" +
                        "<p>piano - pianist</p>" +
                        "<p>guitar - guitarist</p>" +
                        "<p>art - artist</p><br>" +
                        "<p>Unfortunately, there's no easy way to know which ending to use with each word. We " +
                                "just need to learn the forms.</p><br>" +

                        "<p>I kope that helps, and really good luck with your English!</p>";
                textpart2.setContent(htmlContent2,"text/html");


                //Se crea un objeto multipart que albergará todos los bodyparts creados
                MimeMultipart multipart= new MimeMultipart();
                multipart.addBodyPart(textpart1);
                multipart.addBodyPart(imagen);
                multipart.addBodyPart(textpart2);

                //se añade el objeto multipart al mensaje y se envía
                mensaje.setContent(multipart);
                Transport.send(mensaje);

                System.out.println("Correo enviado exitosamente");

            } catch (MessagingException e) {
                System.out.println("Error en el envio o el formato del correo");
                throw new RuntimeException(e);
            }


        } catch (IOException e) {
            System.out.println("Error en la gestión de las propiedades del correo");
            throw new RuntimeException(e);
        }

    }
}
