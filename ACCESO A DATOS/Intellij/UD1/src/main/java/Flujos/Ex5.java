package Flujos;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        var sc= new Scanner(System.in);
        System.out.println("Introduce URL");
        String strurl= sc.nextLine();

        try (var is= new BufferedInputStream(new URI(strurl).toURL().openStream());
            var fos= new BufferedOutputStream(new FileOutputStream("copia.html"))){

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
