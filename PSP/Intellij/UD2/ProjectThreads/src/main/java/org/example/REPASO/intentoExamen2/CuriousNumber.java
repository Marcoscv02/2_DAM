package org.example.REPASO.intentoExamen2;

import java.util.concurrent.Callable;

public class CuriousNumber implements Callable <Integer> {
    private Integer curiousNumber;

    public CuriousNumber() {
    }

    public CuriousNumber(Integer curiousNumber) {
        this.curiousNumber = curiousNumber;
    }

    @Override
    public Integer call() throws Exception {

        int curiousCuadrado= (int) Math.pow(curiousNumber,2);

        String curiousString = String.valueOf(curiousNumber);
        String curiousStringCuadrad0= String.valueOf(curiousCuadrado);

        if (curiousStringCuadrad0.endsWith(curiousString)) {
            return curiousNumber;
        }

        return 0;
    }
}
