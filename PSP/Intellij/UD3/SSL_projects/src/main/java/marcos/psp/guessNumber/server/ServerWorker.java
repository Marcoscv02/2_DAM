package marcos.psp.guessNumber.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable{
    private int lives; //Numero de vidas
    private boolean play;//Variable que indica si el jugador está e cun juego
    private int secretNumber; //Número Aleatorio generado por el servidor
    private int intento; //Numero intento



    private final Socket clientSocket;

    public ServerWorker(Socket socket) {
        this.clientSocket = socket;
    }


    @Override
    public void run() {
        secretNumber= (int) (Math.random()*20);


        try {
            //Declara entrada y salida de elementos del thread
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out= new PrintWriter(clientSocket.getOutputStream(), true);

            while (true){
                //Entrada del cliente
                String userInput= reader.readLine();

                System.out.println(userInput);

                //Separación por palabras
                String [] palabras= userInput.split(" ");


                //Conversion de la segunda palabra a entero (Se usará para new y num)
                String userCommand= palabras[0];
                int userNumber= Integer.parseInt(palabras[1]);

                switch (userCommand.toLowerCase()){

                    case "new":
                        //El jugador no puede estar dentro de un juego para ejecutar este comando
                        if (!play){
                            play=true;
                            System.out.println("new");
                            lives=userNumber;
                            out.println("20 PLAY. Start a new game"); //Inicio de juego
                            break;
                        }else out.println("80 ERR. Input command is not allowed currently");//Error

                    case "num":
                        System.out.println("num");
                        //El jugador debe estar jugando para poder ejecutar este comando
                        if (play){

                            intento=userNumber;
                            if(secretNumber!=intento){ //Jugador falla número

                                lives--;

                                if (intento>secretNumber){ //Si escribe un número mayor que el número secreto
                                    out.println("35 HIGH. Number guessed is higher than secret number (lives:"+lives+")");

                                } else if (lives==0) { //Si el usuario se queda con 0 vidas
                                    out.println("70 LOSE. You have not more Lives");
                                    play=false;


                                } else out.println("25 LOW. Number guessed is lower than secret number (lives:"+lives+")"); //Si escribe un número menor que el número secreto

                            }else {//jugador acierta el número
                                out.println("50 WIN. ¡¡You win!!");;
                                play=false;
                            }

                        }else out.println("80 ERR. Input command is not allowed currently");;

                        break;

                    case "help":
                        out.println("40 INFO. Help about the game");;
                        break;

                    case "quit":
                        out.println("11 BIE. Exiting to the game...");;
                        out.close();
                        reader.close();
                        System.exit(0);
                        break;

                    default:
                        out.println("90 UNKNOWN. Input command is incorrect");;
                }
            }

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}

