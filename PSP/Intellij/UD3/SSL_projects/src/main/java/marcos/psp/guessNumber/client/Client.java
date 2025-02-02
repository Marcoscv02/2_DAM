package marcos.psp.guessNumber.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Scanner;

public class Client {
    public static final String HOST="localhost";
    public static final int PORT=60000;

    public static void main(String[] args) {

        //Mapa con los codigos de comunicacion y el mensaje que transmite
        HashMap<Integer, String> codigos= new HashMap<>(){{
            put(10,"Number game server is ready to receive request from the client in port:");
            put(11, "BIE. Exiting to the game...");
            put(15, "Server is ready again after a communication error");
            put(20, "PLAY. Start a new game");
            put(25, "LOW. Number guessed is lower than secret number");
            put(35, "HIGH. Number guessed is higher than secret number");
            put(40, "INFO. Help about the game");
            put(50, "WIN. ¡¡You win!!");
            put(70, "LOSE. You have not more Lives");
            put(80, "ERR. Input command is not allowed currently");
            put(90, "UNKNOWN. Input command is incorrect");
        }};


        try (Socket socket= new Socket(HOST,PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             BufferedReader reader= new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner userReader= new Scanner(System.in)){

            System.out.println("Servidor conectado");

            while (true){

                System.out.println("Welcome to Guess The Number Game\n"+
                                   "---------------------------------------\n"+
                                   "1. Write NEW with a number of tries you want for start a game (example NEW 3)\n"+
                                   "2. Write NUM with a number you think to is it to try to guess\n"+
                                   "3. White HELP if you need help to play\n"+
                                   "4. White QUIT to quit the game"
                );
                System.out.println("Write Command");
                String userInput= userReader.nextLine();

                out.println(userInput);
                int responseCode= Integer.parseInt(reader.readLine());

                System.out.println(codigos.getOrDefault(responseCode,"Código desconocido"));

                if (userInput.equalsIgnoreCase("quit")){
                    System.exit(0);
                }

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
