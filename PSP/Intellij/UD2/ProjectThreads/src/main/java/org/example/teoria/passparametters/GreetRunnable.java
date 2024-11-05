package org.example.teoria.passparametters;

public class GreetRunnable implements Runnable {
    private String name;

    public GreetRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Hello "+name);
    }
}
