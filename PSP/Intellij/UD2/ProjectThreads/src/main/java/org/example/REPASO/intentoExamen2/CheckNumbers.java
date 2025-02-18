package org.example.REPASO.intentoExamen2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class CheckNumbers {
    public static final String PATH = "src/main/resources/intentoExamen2/";

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String fileName = sc.nextLine();
        int startRange = sc.nextInt();


        String fullPath = PATH+fileName;

        ExecutorService pool = Executors.newFixedThreadPool(15);
        List<FutureTask<Integer>> tareas= new ArrayList<>();

        for (int i = startRange; i < 100 ; i++) {
            Callable<Integer> tarea = new CuriousNumber(i);
            FutureTask<Integer>task = new FutureTask<>(tarea);
            tareas.add(task);

            pool.execute(task);
        }
        pool.shutdown();

        File file= new File(fullPath);
        try(BufferedWriter writter = new BufferedWriter(new FileWriter(file))){

            for (FutureTask<Integer> tarea: tareas){
                String result= tarea.get().toString();

                if (!result.equalsIgnoreCase("0")) writter.write(result+" ");

            }

        } catch (IOException | ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
