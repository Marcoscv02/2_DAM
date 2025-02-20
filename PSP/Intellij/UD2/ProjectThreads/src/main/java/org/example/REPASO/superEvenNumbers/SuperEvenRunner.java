package org.example.REPASO.superEvenNumbers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SuperEvenRunner {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        int firstNumber = (int) (Math.random()*9999+1);
        int lastNumber = 0;

        int generatedValue = 0;
        while (generatedValue<=firstNumber) generatedValue= (int) (Math.random()*9999+1);

        lastNumber=generatedValue;

        List<FutureTask<Integer>>futureList= new ArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i = firstNumber; i < lastNumber; i++) {
            Callable<Integer> task= new SuperEvenTask(i);
            FutureTask<Integer> futureTask= new FutureTask<>(task);

            futureList.add(futureTask);
            pool.execute(futureTask);
        }
        pool.shutdown();

        System.out.println("Primer número: "+firstNumber);
        System.out.println("Último número: "+lastNumber);

        for (FutureTask<Integer> taskResult : futureList){

            int numResult= taskResult.get();

            if (numResult != 0) System.out.println("Even num: "+numResult);
        }


    }
}
