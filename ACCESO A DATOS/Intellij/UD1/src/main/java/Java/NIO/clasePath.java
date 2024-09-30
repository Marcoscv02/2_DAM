package Java.NIO;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class clasePath {
    public static void main(String[] args) {
        Path p= Path.of("pom.xml");//RECOMENDABLE
        Path p2= Paths.get("pom.xml");//Mas antigua

        File archivo=p.toFile(); //Convertir path a archivo
    }
}
