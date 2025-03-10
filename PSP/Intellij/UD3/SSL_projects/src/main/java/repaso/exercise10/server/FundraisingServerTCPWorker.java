package repaso.exercise10.server;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FundraisingServerTCPWorker implements Runnable{
    SSLSocket socket;

    public FundraisingServerTCPWorker(SSLSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream());


           while (true){

               String userInput = reader.readLine();
               userInput = userInput.toLowerCase();
               String[] userInputArray = userInput.split(" ");

               String command = userInputArray[0];

               switch (command){
                   case "add":
                       String amountString = userInputArray[1];

                       if (isNumeric(amountString)){
                           int amount = Integer.parseInt(amountString);
                           FundraisingServerTCP.updateTotalAmount(amount);

                           writter.println("Tank you for your contribution of "+amount+" euros. Current amount is "+FundraisingServerTCP.getTotalAmount());
                           writter.flush();
                           break;
                       }else{
                           writter.println("Amount only can be a number");
                           writter.flush();
                           break;
                       }

                   case "show":
                       writter.println("Current amount is "+FundraisingServerTCP.getTotalAmount());
                       writter.flush();
                       break;

                   case "quit":
                       writter.println("Closing program...");
                       writter.flush();
                       break;

                   default:
                       writter.println("This command is not valid");
                       writter.flush();
                       break;
               }

               if (command.equalsIgnoreCase("quit")){
                   writter.close();
                   reader.close();
                   socket.close();
                   break;
               }
           }

        } catch (IOException e) {
            System.out.println("Error en el hilo servidor");
            throw new RuntimeException(e);
        }
    }


    private static boolean isNumeric(String cadena) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }


}
