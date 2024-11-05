package org.example.teoria.PoolThreads;

public class RunnableThreads implements Runnable{
    private String name;

    public RunnableThreads(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("How are you "+name+"?");
    }
}
