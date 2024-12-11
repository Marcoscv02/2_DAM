package org.example.PoolThreads.multiples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int TOTALNUMS=50;
    public static final int POOLSIZE=12;
    public static void main(String[] args) {
        NumberGenerator bigNumber= new NumberGenerator();
        ExecutorService pool= Executors.newFixedThreadPool(POOLSIZE);
        ArrayList<BigInteger>numeros= new ArrayList<>();


        for (int i = 0; i < TOTALNUMS; i++) {

            BigInteger num = bigNumber.getNum();
            numeros.add(num);

        }

        for (BigInteger n:numeros){
            System.out.println("comprobacion de multiplo de 3,5 o 11 para numero: "+n);
            pool.execute(new Task(n));
        }
        pool.shutdown();

    }
}
