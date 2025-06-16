package marcos.psp.examen.harryPotter.smtp;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import marcos.psp.examen.harryPotter.model.Book;
import marcos.psp.examen.harryPotter.model.Character;
import marcos.psp.examen.harryPotter.model.House;
import marcos.psp.examen.harryPotter.model.Spell;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SendHarryPotter implements Runnable{
    private Object object;
    private String email;

    public SendHarryPotter(Object object, String email) {
        this.object = object;
        this.email = email;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        Properties props = new Properties();

        try(FileReader propsReader = new FileReader("src/main/resources/harryPotter/smtp.properties")){
            props.load(propsReader);
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo de propiedades");
            throw new RuntimeException(e);
        }

        String user = props.getProperty("cdelaisla88@gmail.com");
        String password = props.getProperty("paca fhgc orgk xgak");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user,password);
            }
        });

        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress());

            if (object instanceof Book){
                message.setSubject("Dato interesante sobre un libro de Harry Potter");
                String content ="<h2>"+((Book) object).getTitle()+"</h2>" +
                        "<p>Título original: "+((Book) object).getOriginalTitle()+"</p>"+
                        "<p>Fecha de Lanzamiento: "+((Book) object).getReleaseDate()+"</p>"+
                        "<p>sinopsis: "+((Book) object).getDescription()+"</p>"+
                        "<p>numPages: "+((Book) object).getPages()+"</p>";

                message.setContent(content, "text/html");
            }else if (object instanceof Spell){
                message.setSubject("Dato interesante sobre un hechizo de Harry Potter");
                String content ="<h2>"+((Spell) object).getSpell()+"</h2>" +
                        "<p>Para que sirve? : "+((Spell) object).getUse()+"</p>";

                message.setContent(content, "text/html");
            } else if (object instanceof House) {

            } else if (object instanceof Character) {

            }

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
