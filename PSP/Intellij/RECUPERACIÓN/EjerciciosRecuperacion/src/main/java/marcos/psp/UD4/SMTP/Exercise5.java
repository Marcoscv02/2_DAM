package marcos.psp.UD4.SMTP;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Exercise5 {
    public static void main(String[] args) {
        Properties props = new Properties();

        try(FileInputStream fis = new FileInputStream("src/main/resources/pop3.properties")){
            props.load(fis);

        } catch (IOException e) {
            System.out.println("Error en la carga del archivo de propiedades");
            throw new RuntimeException(e);
        }
    }
}
