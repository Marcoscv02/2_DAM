package Java.Boletines.boletin0102.ex3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ListarDirectorio {
    public static void main(String[] args) throws IOException {
        Long Tinicio=System.nanoTime();
        Path directorio= Paths.get("C:\\Users\\a24marcoscv\\Documents\\2_DAM\\ACCESO A DATOS\\Intellij\\UD1\\src\\main\\java\\Java\\Boletines\\boletin0102\\ex1");


            // Filtrar para mostrar solo los archivos que son archivos Java y no directorios
            Files.list(directorio) //Se utiliza el metodo list de la clase File
                    .filter(p->Files.isRegularFile (p))           // Filtrar solo archivos regulares (no directorios)
                    .filter(p2->p2.toString().endsWith(".java"))  // Filtrar solo archivos con extensión .java
                    .forEach(System.out::println);          // Mostrar cada archivo encontrado


        Long Tfinal= System.nanoTime();
        Long Tejecucion= Tfinal-Tinicio;
        System.out.println("Tiempo ejecucion = "+Tejecucion);

    }
}
