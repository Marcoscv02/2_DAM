package marcos.psp.guessNumber.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static final String HOST="localhost";
    public static final int PORT=60000;

    public static void main(String[] args) {
        try (Socket socket= new Socket(HOST,PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userReader= new BufferedReader(new InputStreamReader(System.in))){

            System.out.println("Servidor conectado");

            String userInput;
            while ((userInput=userReader.readLine())!=null){

                System.out.println("Welcome to Guess The Number Game\n"+
                                   "---------------------------------------\n"+
                                   "1. Write NEW with a number of tries you want for start a game (example NEW 3)"+
                                   "2. Write NUM with a number you think to is it to try to guess"+
                                   "3. White HELP if you need help to play"+
                                   "4. White QUIT to quit the game"
                );

                out.println(userInput);

                if (userInput.equalsIgnoreCase("quit")){
                    System.exit(0);
                }
                //Lógica de contacto con servidor
                //Mandar los argumentos en toLowerCase

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
