package marcos.psp.examen.trivialQuiz.tcp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {
    public static final int PORT = 59999;
    public static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (Socket clientSocket = new Socket(HOST, PORT);
             BufferedReader reader = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writter = new PrintWriter(clientSocket.getOutputStream(),true)){

            System.out.println("---TRIVIAL GAME---");
            System.out.println(
                    "- NEW <Nombre>\n"+
                    "- TRIVIAL <Category> <Difficulty> <NumQuestions>\n"+
                    "- SHOW (Para mostrar las categorias disponibles)\n"+
                    "- CORRECTION <email>(Para enviar un email con las correcciones del trivial)\n"+
                    "- EXIT"
            );


            while (true){

                System.out.println("command:");
                String command = sc.nextLine();

                if (command.equalsIgnoreCase("show")){
                    printCategories();

                }else {
                    writter.println(command);
                    String serverResponse = reader.readLine();
                    System.out.println(serverResponse);


                    if (command.equalsIgnoreCase("exit")) break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error en el cliente");
            throw new RuntimeException(e);
        }
    }

    public static void printCategories (){
        StringBuilder sb = new StringBuilder();
        try {
            URL categoryURL = new URI("https://opentdb.com/api_category.php").toURL();

            BufferedReader reader = new BufferedReader(new InputStreamReader(categoryURL.openStream()));

            String line;
            while ((line= reader.readLine())!=null){
                sb.append(line);
            }
            reader.close();

            // Formatear el JSON con Gson
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonElement jsonElement = JsonParser.parseString(sb.toString());
            String formattedJson = gson.toJson(jsonElement);

            System.out.println(formattedJson);

        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error en la URL de acceso a la API: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en el acceso a las categorias de la API: "+e.getMessage());
            throw new RuntimeException(e);
        }


    }
}
