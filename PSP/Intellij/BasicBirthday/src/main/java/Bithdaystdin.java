import java.util.Scanner;

public class Bithdaystdin {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //Se inserta por consola el número de casos
        int casos= scanner.nextInt();

        //Se crea un bucle que genere tantas iteraciones como casos haya
        for (int i = 0; i < casos; i++) {

            //Se introducen las edades
            System.out.println("Escriba edad"+i+"en segundos");
            int edad= scanner.nextInt();

            //Se convierte la edad a numero binario
            String binaryAge=Integer.toBinaryString(edad);

            //Se crea un contador que revise todo el número y cada vez que detecte un número suba el contador
            int cont=0;
            for (int j = 0; j < binaryAge.length(); j++) {
                if (binaryAge.charAt(j)=='1'){
                    cont++;
                }
            }
            System.out.println(cont);
        }
    }
}
