package marcos.psp.examen.chuckNorris.tcp;

import com.google.gson.Gson;
import marcos.psp.examen.chuckNorris.ftp.ChuckNorrisDownLoad;
import marcos.psp.examen.chuckNorris.model.Category;
import marcos.psp.examen.chuckNorris.model.Joke;
import marcos.psp.examen.chuckNorris.smtp.SendChuckNorris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChuckNorrisServerWorker implements Runnable{
    private final Socket socket;

    public ChuckNorrisServerWorker(Socket socket) {
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){
            Joke joke = null;
            while (true){
                String[] userInput = reader.readLine().trim().split(" ");
                String command = userInput[0].toLowerCase();

                switch (command){
                    case "joke":
                        if (userInput.length>2){
                            writer.println("User Input format incorrect");
                        }else {
                            String category = null;

                            StringBuilder url = new StringBuilder();
                            url.append("https://api.chucknorris.io/jokes/random");

                            if (userInput.length==2){
                                category = userInput[1];
                                url.append("?category=").append(category);
                            }
                            joke = getJoke(String.valueOf(url));
                            writer.println(joke.getValue());

                        }
                        break;
                    case "categories":
                        if (userInput.length!=1){
                            writer.println("User Input format incorrect");
                        }else {
                            List<String> categories = getCategories();
                            System.out.println(categories);
                            writer.println(categories.toString());
                        }
                        break;
                    case "send":
                        if (userInput.length!=3){
                            writer.println("User Input format incorrect");
                        }else {
                            if (joke!=null){
                                String sender = userInput[1];
                                String receptor = userInput[2];
                                new Thread(new SendChuckNorris(sender,receptor, joke));
                                writer.println("Joke was send to your friend");
                            }else {
                                writer.println("There arent still a joke to send");
                            }
                        }
                        break;
                    case "download":
                        new Thread(new ChuckNorrisDownLoad(joke)).start();
                        writer.println("File was download on server");
                        break;
                    case "exit":
                        writer.println("Good bye");
                        break;
                    default:
                        writer.println("unknown command");
                        break;
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para obtener una broma de la API a traves de una url previamente creada
     * @param url
     * @return broma
     */
    private static Joke getJoke (String url){
        Joke joke;
        try {
            URL url1 = new URI(url).toURL();
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();

            joke = gson.fromJson(reader, Joke.class);
            System.out.println(joke);

        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error en la lectura de la API: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en la API: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return joke;
    }

    /**
     * Metodo para obtener las categorías de bromas disponibles en la Api
     * @return Lista de categorías
     */
    private static List<String> getCategories(){
        List <String> categories;
        try {
            URL url1 = new URI("https://api.chucknorris.io/jokes/categories").toURL();
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            String[] categoriesArray = gson.fromJson(reader, String[].class);

            categories = Arrays.asList(categoriesArray);

        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error en la lectura de la API: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en la API: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return categories;
    }
}
