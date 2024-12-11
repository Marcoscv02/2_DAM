package org.example.PoolThreads.multiples;

import java.math.BigInteger;

import java.util.Random;

public class NumberGenerator  {
    Random random= new Random();

    public BigInteger getNum(){
        StringBuilder st= new StringBuilder();

        int numDigitos=20+ random.nextInt(30);

        st.append(random.nextInt(1,10));
        for (int i = 0; i < numDigitos; i++) {
            int digito= random.nextInt(9);
            st.append(digito);
        }
        return new BigInteger(st.toString()) ;
    }

}
