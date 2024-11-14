package org.example.atomicVariables;

public class Number {
    private int number;
    private boolean isSuperpar;

    public Number(int number) {
        this.number = number;
        this.isSuperpar = true;  // Inicializamos como superpar
    }

    public int getNumber() {
        return number;
    }

    public boolean isSuperpar() {
        return isSuperpar;
    }

    public void setSuperpar(boolean isSuperpar) {
        this.isSuperpar = isSuperpar;
    }
}

