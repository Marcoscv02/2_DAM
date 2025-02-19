package org.example.REPASO.superEvenNumbers;

import java.util.concurrent.Callable;

public class SuperEvenTask implements Callable<Integer> {
    private Integer number;

    public SuperEvenTask(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        String numberValue = String.valueOf(number);
        char [] separatedNumber= numberValue.toCharArray();

        boolean evenNumber = true;
        for (char c: separatedNumber){
            if (c%2!=0){
               evenNumber = false;
            }
        }

        if (evenNumber) return number;

        return 0;
    }
}
