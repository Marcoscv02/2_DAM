package repaso.exercise6.server;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServerWorker implements Runnable{
    private static  boolean play;
    private static int lives;
    private SSLSocket clientSocket;

    public ServerWorker(SSLSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        int secretNumber = (int) (Math.random()*100);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writter = new PrintWriter(clientSocket.getOutputStream(),true);

            while (true){
                String command = reader.readLine();
                System.out.println("Comando recibido "+command);

                String [] input = command.split(" ");
                String first = input[0];
                int second = Integer.parseInt(input[1]);

                switch (first.toLowerCase()){
                    case "new":

                         lives = second;
                         play=true;
                         writter.println("20 PLAY . You have "+lives+" attemps");
                         writter.flush();
                         break;


                    case "num":

                        String numToGuess = input[1];
                        int num = Integer.parseInt(numToGuess);

                        if (play){

                            if (num!=secretNumber){
                                lives--;

                                if (lives==0) {
                                    play=false;
                                    writter.println("70 LOSE. The number was " + secretNumber);
                                }

                                if (num<secretNumber){
                                    writter.println("25 LOW. You have "+lives+" attemps");
                                }else{
                                    writter.println("35 HIGH. You have "+lives+" attemps");
                                }

                            } else {
                                writter.println("50 WIN. You win the game, the number was "+secretNumber);
                                play=false;
                            }
                        }else {
                            writter.println( " 80 ERR. This command cannot be used at this time.");
                        }

                        writter.flush();
                        break;


                    case "help":
                        writter.println("40 INFO.");
                        writter.flush();
                        break;


                    case "quit":
                        writter.write("11 BYE.");
                        clientSocket.close();
                        writter.close();
                        reader.close();
                        break;

                    default:
                        writter.println("90 UNKNOWN. The command used is incorrect.");
                        break;

                }
            }

        } catch (IOException e) {
            System.out.println("Error en el thread");
            throw new RuntimeException(e);
        }
    }
}
