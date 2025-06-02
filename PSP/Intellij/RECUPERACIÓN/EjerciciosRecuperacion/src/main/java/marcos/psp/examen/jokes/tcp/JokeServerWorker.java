package marcos.psp.examen.jokes.tcp;

import com.google.gson.Gson;
import marcos.psp.examen.jokes.ftp.SaveJokesFtp;
import marcos.psp.examen.jokes.ftp.SaveJokesSftp;
import marcos.psp.examen.jokes.model.Joke;
import marcos.psp.examen.jokes.smtp.SendJokeMail;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class JokeServerWorker implements Runnable{
    private Socket socket;

    public JokeServerWorker(Socket socket) {
        this.socket = socket;
    }

    private List<Joke> bromas = new ArrayList<>();
    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)){

            while (true){
                String[] userInput = reader.readLine().trim().toLowerCase().split(" ");
                String command = userInput[0];
                switch (command){

                    //Obtener una nueva broma
                    case "joke":
                        if (userInput.length!=2){
                            writer.println("User input format incorrect");
                        }else {
                            Joke joke = FetchAPI();

                            if (joke.getError())
                                writer.println("Occurred an error, can`t get a Joke");
                            else {
                                String email = userInput[1];
                                new Thread(new SendJokeMail(email, joke)).start();
                                System.out.println(joke);
                                writer.println("Accept, email was send");
                            }
                        }
                        break;

                    //Descargar las bromas del usuario al servidor ftp
                    case "download":
                        File[] directory = new File ("src/main/resources/jokeApp").listFiles();

//                        FutureTask<Boolean> ftpTask = new FutureTask<>(new SaveJokesFtp(directory));
//                        ftpTask.run();
//                        boolean success = ftpTask.get();

                        FutureTask<Boolean> SftpTask = new FutureTask<>(new SaveJokesSftp(directory));
                        SftpTask.run();
                        boolean success = SftpTask.get();


                        if (success)
                            writer.println("Files was saved correctly");
                        else
                            writer.println("Cant saved jokes");

                        break;

                    //salir
                    case "exit":
                        writer.println("Good Bye");
                        break;

                    default:
                        writer.println("unknown command");
                        break;

                }

                if (command.equalsIgnoreCase("exit"))
                    break;

            }

        } catch (IOException e) {
            System.out.println("Error en el worker del server: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Error en la obtencion del resultado de la tarea Callable: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * Metodo para Acceder a la api y obtener una broma
     * @return Joke
     */
    private static Joke FetchAPI(){
        Joke joke;
        try {
            URL url = new URI("https://v2.jokeapi.dev/joke/Any?lang=es").toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            Gson gson = new Gson();

            BufferedReader apiReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            joke = gson.fromJson(apiReader, Joke.class);

            return joke;


        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error en el acceso a la API: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en el acceso a la API: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
