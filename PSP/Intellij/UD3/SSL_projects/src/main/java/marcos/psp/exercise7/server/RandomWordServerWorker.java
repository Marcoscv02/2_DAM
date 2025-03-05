package marcos.psp.exercise7.server;

import java.io.*;
import java.net.*;

public class RandomWordServerWorker implements Runnable{
    String [] comando;
    String orden;
    String num;

    private  final Socket clientSocket;

    public RandomWordServerWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {


        try (var reader= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             var writter= new PrintWriter(clientSocket.getOutputStream(), true)){

            while (true){
                String userInput= reader.readLine();

                comando= userInput.split(" ");
                orden= comando[0];
                num= comando[1];

                switch (orden){
                    case "end":
                        System.exit(0);
                        break;

                    case "word":
                        //Abre la conecion con la api
                        URLConnection url= new URI("https://random-word-api.herokuapp.com/word?length="+num).toURL().openConnection();

                        BufferedReader urlReader= new BufferedReader(new InputStreamReader(url.getInputStream()));
                        String word = urlReader.readLine();

                        writter.println(word);
                        break;

                    default:
                        writter.println("No se detecta el comando especificado");
                        break;
                }

            }

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
