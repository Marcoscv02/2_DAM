package caracteres;

import java.io.*;

public class Bufferes {
    public static void main(String[] args) throws IOException {

        Reader r= new InputStreamReader(System.in);
        BufferedReader br= new BufferedReader(r);
        String linha;
        while (!(linha= br.readLine()).equalsIgnoreCase("EXIT")){
            System.out.println("linha - " + linha);
        }

        /*BufferedWriter bw= new BufferedWriter(new FileWriter("kk.txt"));

        bw.write("El mundo es una kk");
        bw.flush();

        BufferedReader br= new BufferedReader(new FileReader("pom.xml"));
        br.readLine();*/
    }
}
