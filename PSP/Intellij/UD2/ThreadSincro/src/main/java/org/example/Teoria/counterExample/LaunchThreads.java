package org.example.Teoria.counterExample;

import java.util.ArrayList;
import java.util.List;

public class LaunchThreads {
    public static final int NUM_THREADS=10;
    public static void main(String[] args) throws InterruptedException {
        Counter counter= new Counter();
        List<Thread> listThread = new ArrayList<Thread>();

        for (int i = 0; i <NUM_THREADS; i++) {
            CounterRunnable cr= new CounterRunnable(counter);
            Thread th= new Thread(cr);
            listThread.add(th);
            th.start();
        }

        for (int i = 0; i < NUM_THREADS; i++) {
            listThread.get(i).join();
        }
        System.out.println("The final value of counter is "+counter.getCount());
    }
}