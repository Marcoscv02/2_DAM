package org.example.callable;

import java.util.concurrent.Callable;

public class GreetCallable implements Callable {
    private String name;

    public GreetCallable(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        String res= "Hello "+name+"!";
        return res;
    }
}
