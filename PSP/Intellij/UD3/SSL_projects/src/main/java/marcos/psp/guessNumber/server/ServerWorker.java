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
        try( //Recibe las entradas del cliente
             BufferedReader reader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             //Manda las respuestas al cliente
             PrintWriter out= new PrintWriter(clientSocket.getOutputStream(), true)){


            while (reader.readLine()!=null){

                //Entrada del cliente
                String userInput= reader.readLine();

                //Separación por palabras
                String [] palabras= userInput.split(" ");


                //Conversion de la segunda palabra a entero ya que es un número (Se usara para new y num)
                int userNumber= Integer.parseInt(palabras[2]);


                switch (userInput){
                    case "new":
                        //El jugador no puede estar dentro de un juego para ejecutar este comando
                        if (!play){
                            play=true;
                            lives=userNumber;
                            out.println(20); //Inicio de juego
                            secretNumber= (int) (Math.random()*20);
                            break;
                        }else out.println(80);//Error

                    case "num":
                        //El jugador debe estar jugando para poder ejecutar este comando
                        if (play){

                            intento=userNumber;
                            if(secretNumber!=intento){ //Jugador falla número

                                lives--;

                                if (intento>secretNumber){ //Si escribe un número mayor que el número secreto
                                    out.println(35);

                                } else if (lives==0) { //Si el usuario se queda con 0 vidas
                                   out.println(70);
                                    play=false;


                                } else out.println(25); //Si escribe un número menor que el número secreto

                            }else {//jugador acierta el número
                                out.println(50);;
                                play=false;
                            }

                        }else out.println(80);;

                        break;

                    case "help":
                        out.println(40);;
                        break;

                    case "quit":
                        out.println(11);;
                        System.exit(0);
                        break;

                    default:
                        out.println(90);;
                }
            }
        } catch (IOException e) {
            System.out.println("Error entrada/salida en serverWorker");
            throw new RuntimeException(e);
        }
    }
}
