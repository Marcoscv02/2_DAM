package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class   main {
    public static void main(String[] args) {

        var random= new Random(); //Importación clase random

        //Comando para CMD (Se utiliza el metodo arrays.asList para inicializar el Arraylist con valores predeterminados)
        ArrayList<String>comando=new ArrayList<>(Arrays.asList("java", "-cp", ".\\src\\main\\resources\\BasicBirthday-1.0-SNAPSHOT.jar","org.exampe.main"));

        int numCases= random.nextInt(5)+1; //Se genera un número random enytre 1 y 5
        System.out.println("numero de casos: "+numCases);
        comando.add(String.valueOf(numCases));

        for (int i = 0; i < numCases; i++) {
            int caso= random.nextInt(101);//para cada argumento se genera un número aleatorio entre 0 y 100
            comando.add(String.valueOf(caso));
        }

        //Se transforma el ArrayList comando en un array normal
        String[] commandArray=comando.toArray(new String[0]); //Poniendo String[0] java generará el Array del tamaño que tuviese el arraylist

        try {
            Runtime runtime= Runtime.getRuntime(); //Se inicializa la clase runtime

        }


    }
}
