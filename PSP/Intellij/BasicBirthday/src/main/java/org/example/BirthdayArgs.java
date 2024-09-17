package org.example;

public class BirthdayArgs {
    public static void main(String[] args) {
        //Se guarda en una variable de tipo entero el numero de casos totales
        int numCases= Integer.parseInt(args[0]);
        //Se crea un contador inicial llamado casos
         int cases =1;
         //Mientras casos no sea igual a num de casos
         while(cases<=numCases){
             //Dentro del bucle se van guardando en la variable edad el valor entero del argumento con ese índice (cases)
             int age= Integer.parseInt(args[cases]);
             //El valor entero age se convierte a numero binario y se guarda en una variable de tipo String
             String binaryAge= Integer.toBinaryString(age);
             //Se crea un segundo contador
             int cont=0;
             //Desde i=0 hasta la longitud de la variable binaryAge
             for (int i = 0; i < binaryAge.length(); i++) {
                 //Si el caracter en el indice i == 1 contador suma 1
                 if (binaryAge.charAt(i)==('1')){
                     cont++;
                 }
             }
             //Se imprime contador
             System.out.println(cont);
             //Se suma un caso y una iteracción nueva del bucle while
             cases++;
         }
    }
}
