package Java.Boletines.boletin0103.ex3;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LocalDateTime  date= LocalDateTime.of(2023,11,12,9,45,00);

        List participantes= new ArrayList<>();
        participantes.add("Rosalia de Casto");
        participantes.add("Almudena Grandes");
        participantes.add("Silvia Plath");
        participantes.add("Fida Kalo");
        participantes.add("Concha Lagos");
        //Creacion objeto examen
        Examen examen1= new Examen("Acceso a datos",date,participantes);

        //Creacion de JsonbBuilder
        Jsonb jsonb= JsonbBuilder
                .newBuilder()
                .withConfig(new JsonbConfig().withFormatting(true)).build(); //Se añade formato al JSON *IMPORTANTE*
        String strJson= jsonb.toJson(examen1);
        //Creacion del archivo
        File f= new File("AccesoDAtos.js");

        if (!f.exists()){
            f.createNewFile();
        }
        BufferedWriter bw= new BufferedWriter(new FileWriter (f));
        bw.write(strJson);
        bw.close();
        System.out.println("JSon guardado en"+f.getAbsolutePath());
    }
}
