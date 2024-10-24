package org.example;

/*Se trata de un programa diseñado para ser ejecutado desde la consola de comandos a través del comando
 java -cp target/classes org.example.BirthdayArgs una vez estemos situados en la carpeta del proyecto.
 El programa se constituye en un contador de "1" que devuelve la cantidad de "1" registrados en el argumento
  o argumentos después de pasar este a binario*/


public class BirthdayArgs {
    public static void main(String[] args) {
        if (args.length==0) {
            //se crea un mensaje de error ara el caso de que el número de argumentos sean 0
            System.out.println("Use: BirthdayArgs n  n1 n2... num n");
        }else {
            //Se guarda en una variable de tipo entero el número de casos totales
            int numCases = Integer.parseInt(args[0]);
            //Se crea un if para gestionar que el numcasos introducido sea igual al numcasos introducido
            if (numCases == args.length-1) {
                //Se crea un contador inicial llamado casos
                int cases = 1;
                //Mientras casos no sea igual a num de casos
                while (cases <= numCases) {
                    //Dentro del bucle se van guardando en la variable edad el valor entero del argumento con ese índice (cases)
                    int age = Integer.parseInt(args[cases]);
                    //El valor entero age se convierte a número binario y se guarda en una variable de tipo String
                    String binaryAge = Integer.toBinaryString(age);
                    //Se crea un segundo contador
                    int cont = 0;
                    //Desde i=0 hasta la longitud de la variable binaryAge
                    for (int i = 0; i < binaryAge.length(); i++) {
                        //Si el caracter en el índice i == 1 contador suma 1
                        if (binaryAge.charAt(i) == ('1')) {
                            cont++;
                        }
                    }
                    //Se imprime contador
                    System.out.println(cont);
                    //Se suma un caso y una iteracción nueva del bucle while
                    cases++;
                }
            }else {
                System.out.println("Use as num of cases as the first num is");
            }
        }
    }
}
