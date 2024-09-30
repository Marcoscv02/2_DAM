package Java.IO.caracteres;

import java.io.IOException;

public class CharacterStreams {
    public static void main(String[] args) throws IOException {
        int c;
        while ((c=System.in.read()) != -1){
            System.out.println((char) c);
        }
    }
}
