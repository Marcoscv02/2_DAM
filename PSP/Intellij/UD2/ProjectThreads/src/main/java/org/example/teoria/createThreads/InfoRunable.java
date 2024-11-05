package org.example.teoria.createThreads;

public class InfoRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("hello my Thread "+Thread.currentThread().getName());
    }
}
