package Java.Boletines.boletin0102.ex2;

import java.io.IOException;
import java.nio.file.*;

public class CreaDirectorio {
    public static void main(String[] args) throws IOException {
        Path directorio= Paths.get("data/kk");

        Files.createDirectories(directorio);

        Files.createFile(Paths.get("data", "kk.txt"));
    }
}
