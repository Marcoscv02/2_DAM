package marcos.psp.UD3.exercise6;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class GessServerWorker implements Runnable{
    private SSLSocket socket;
    private int numLives;
    int numAleatorio = 0;


    public GessServerWorker(SSLSocket socket) {
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writter = new PrintWriter(socket.getOutputStream(),true)){
            boolean playing = false;



            while (true){
                String userInput = reader.readLine();
                String [] userInputArray = userInput.split(" ");
                String command = userInputArray[0];

                switch (command){
                    case "new":
                        if (!playing){
                            playing = true;
                            numLives = Integer.parseInt(userInputArray[1]);
                            numAleatorio = startRandomNumber();
                            writter.println("20 PLAY."+numLives);
                        }else {
                            writter.println("80 ERR.");
                        }
                        break;

                    case "num":
                        if (playing){
                            int num = Integer.parseInt(userInputArray[1]);

                            if (num < numAleatorio){
                                numLives--;

                                if (numLives>0){
                                    writter.println("25 LOW."+numLives);
                                }else {
                                    writter.println("70 LOSE NUM. "+numAleatorio);
                                }
                                break;

                            } else if (num > numAleatorio) {
                                numLives--;

                                if (numLives>0){
                                    writter.println("35 HIGH."+num);
                                }else {
                                    writter.println("70 LOSE NUM. "+numAleatorio);
                                }
                                break;

                            }else {
                                writter.println("50 WIN.");
                                playing = false;
                                break;
                            }

                        }else {
                            writter.println("80 ERR.");
                            break;
                        }

                    case "help":
                        writter.println("40 INFO.");
                        break;

                    case "quit":
                        writter.println("11 BYE.");
                        break;

                    default:
                        writter.println("90 UNKNOWN.");
                        break;
                }

                if (command.equalsIgnoreCase("quit"))
                    break;
            }


        } catch (IOException e) {
            System.out.println("Error en el hilo del servidor");
            throw new RuntimeException(e);
        }
    }

    public static int startRandomNumber(){
        return (int) (Math.random()*100);
    }
}
