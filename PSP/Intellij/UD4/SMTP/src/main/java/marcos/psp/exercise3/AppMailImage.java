package marcos.psp.exercise3;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppMailImage {
    //Declarar emisor y receptor
    public static final String EMISOR = "cdelaisla88@gmail.com";
    public static final String RECEPTOR = "a24marcoscv@iessanclemente.net";

    //Declarar contraseña y usuario
    private static final String  username = ;
    private static final String  passsword = ;



    public static void main(String[] args) {
        try (InputStream input= new FileInputStream("src/main/resources/smtp2.properties")){
            Properties prop= new Properties();
            prop.load(input);

            Session session= Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return super.getPasswordAuthentication();
                }
            })

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
