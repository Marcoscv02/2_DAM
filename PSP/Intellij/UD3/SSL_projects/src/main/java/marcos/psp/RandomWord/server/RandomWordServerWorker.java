package marcos.psp.RandomWord.server;

import java.io.*;
import java.net.*;

public class RandomWordServerWorker implements Runnable{
    private  final Socket clientSocket;

    public RandomWordServerWorker(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {


        try (var br= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             var bw= new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){

            //Abre la conecion con la api
            URLConnection url= new URI("https://random-word-api.herokuapp.com/word?length=").toURL().openConnection();

            while (true){
                String userInput= br.readLine();

                String[] comando= userInput.split(" ");
                String orden= comando[0];

                switch (orden){
                    case "end":
                        System.exit(0);
                        break;
                    case "word":
                        String num= comando[1];
                        num.
                        break;
                    default:
                        break;
                }




                var urlReader= new BufferedReader(new InputStreamReader(url.getInputStream()));
                String apiWord= urlReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
