package org.example.REPASO.intentoExamen1;

import java.util.Map;
import java.util.concurrent.Callable;

public class CuriousNumber implements Callable<Integer> {
    private Integer number;

    public CuriousNumber(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int numCuadrado= (int) Math.pow(number,2);

        String stringNumCuadrado= String.valueOf(numCuadrado);
        String stringNum= String.valueOf(number);

        return stringNumCuadrado.endsWith(stringNum) ?  number : 0;
    }
}
