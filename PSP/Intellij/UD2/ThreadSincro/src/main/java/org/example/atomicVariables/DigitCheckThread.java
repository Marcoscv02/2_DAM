package org.example.atomicVariables;

public class DigitCheckThread extends Thread {
    private Number number;
    private int digitIndex;

    public DigitCheckThread(Number number, int digitIndex) {
        this.number = number;
        this.digitIndex = digitIndex;
    }

    @Override
    public void run() {
        int digit = Integer.toString(number.getNumber()).charAt(digitIndex) - '0';
        if (digit % 2 != 0) {
            number.setSuperpar(false);  // Si el dígito no es par, el número no es superpar
        }
    }
}

