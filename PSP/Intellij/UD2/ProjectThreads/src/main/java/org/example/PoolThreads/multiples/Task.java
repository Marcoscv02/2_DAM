package org.example.PoolThreads.multiples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Task implements Runnable {
    BigInteger numero;
    boolean multiplo3,multiplo5,multiplo11;


    public Task(BigInteger numero) {
        this.numero = numero;
    }

    @Override
    public void run() {

        //COMPROBAR MÚLTIPLO DE 3
        String numString = numero.toString();
        char[]numSeparado = numString.toCharArray();

        List<Integer>nums= new ArrayList<>();

        for (char c:numSeparado){
            nums.add((int)c);
        }
        int sumanums=0;
        for (int n:nums){
            sumanums+=n;
        }
        if(sumanums%3==0){
            System.out.println("El número es múltiplo de 3");
            multiplo3=true;
        }else multiplo3=false;



        //COMPROBAR MULTIPLO DE 5
        char lastValue= numSeparado[numString.length()-1];

        if ((int)lastValue==0||(int)lastValue==5){
            System.out.println("El número es múltiplo de 5");
            multiplo5=true;
        }else multiplo5=false;




        //COMPROBAR MÚLTIPLO DE 11

        int sumaPares=0;
        int sumaImpares=0;

        for (int i = 0; i < numSeparado.length; i++) {

            int valor= (int)numSeparado[i];

            if (i%2==0){
                sumaPares+=valor;
            }

            if (!(i%2==0)){
                sumaImpares+=valor;
            }
        }

        int resta;
        if ((resta=sumaPares-sumaImpares)%11==0){
            System.out.println("El número es múltiplo de 11");
            multiplo11=true;
        }else multiplo11=false;


        if (multiplo3==false & multiplo5==false & multiplo11==false){
            System.out.println("El número no es multiplo de 3, 5 o 11");
        }


    }
}
