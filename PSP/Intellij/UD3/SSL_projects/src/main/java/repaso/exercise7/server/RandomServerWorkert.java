package repaso.exercise7.server;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class RandomServerWorkert implements Runnable{
    SSLSocket clientSocket;

    public RandomServerWorkert(SSLSocket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintWriter writter = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true){

                String input = reader.readLine();
                System.out.println("Obtenido comando "+input);
                input = input.toLowerCase();
                String [] userInput = input.split(" ");
                String command = userInput[0];
                int wordLenght = Integer.parseInt(userInput[1]);

                switch (command){
                    case "quit":
                        writter.println("Cerrando programa...");
                        writter.flush();
                        break;

                    case "word":
                        String word = getWordFromApi(wordLenght);
                        writter.println(word);
                        writter.flush();
                        break;

                    default:
                        writter.println("Comando no reconocido");
                        writter.flush();
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

    private static String getWordFromApi(int lenght){
        String word;
        try {
            System.out.println("llegado al metodo de url");
            URL url = new URI("https://random-word-api.herokuapp.com/word?length="+lenght).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            BufferedReader urlReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String apigetter = urlReader.readLine();


            String [] apiInput = apigetter.split("\"");
            word=apiInput[1];
            System.out.println("Palabra obtenida desde la api: "+word);


        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error en la obtencion de la palabra desde la API");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return word;
    }

}
