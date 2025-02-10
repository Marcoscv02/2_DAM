package org.example.REPASO.intentoExamen1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class CheckNumbers {
    public static final String PATH = "src/main/resources/" ;

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        Scanner sc= new Scanner(System.in);


        String fileName= sc.nextLine();
        String fullPath= PATH+fileName;

        ExecutorService pool= Executors.newFixedThreadPool(20);

        int firstNum= sc.nextInt();

        List<FutureTask<Integer>> tasks= new ArrayList<>();
        for (int i = firstNum; i < (firstNum+100) ; i++) {
            Callable <Integer> callable= new CuriousNumber(i);
            FutureTask <Integer> task= new FutureTask<>(callable);
            tasks.add(task);

            pool.execute(task);
        }
        pool.shutdown();

        File file= new File(fullPath);
        var br= new BufferedWriter(new FileWriter(file));

        for (FutureTask<Integer> task : tasks) {
            String result = task.get().toString();

            if (!result.equals("0")) br.write(result+"\t");
        }
        br.close();
    }
}
