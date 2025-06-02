package marcos.psp.examen.gessWord.tcp;

import marcos.psp.examen.gessWord.ftp.UploadMailsSFTP;
import marcos.psp.examen.gessWord.smtp.SendReportMail;

import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class WordServerWorker implements Runnable{
    private final SSLSocket socket;

    public WordServerWorker(SSLSocket socket) {
        this.socket = socket;
    }

    public static final String ANSI_YELLOW = "\u001B[43m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[42m";

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        boolean playing = false;
        boolean winner = false;
        String userName;
        String word = null;
        int lives = 5;
        List<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream(), true)){
            while (true){
                String userInput = reader.readLine().trim().toLowerCase();
                String[] userInputOnArray = userInput.split(" ");
                String command = userInputOnArray[0];

                switch (command){
                    case "new":
                       if (playing){
                           writter.println("You are already playing");
                       }else {
                           userName = userInputOnArray[1];

                           word = fetchWordFromApi().toUpperCase();
                           System.out.println("La palabra es: "+word);
                           writter.println("Hello: "+userName);
                           playing = true;
                       }
                        break;

                    case "word":
                        if (!playing){
                            writter.println("First insert command 'NEW'");
                        }else {
                            String userWord = userInputOnArray[1].toUpperCase();

                            if (userWord.length() != 5){
                                writter.println("La palabra debe tener tan solo 5 caracteres");

                            } else if (userWord.equalsIgnoreCase(word)) {
                                //Mensaje de ganar el juego
                                writter.println("win the game, insert command 'CORRECTION' to send and specific email of your game reports");
                                words.add(userWord);
                                winner = true;
                                playing = false;
                            } else {
                                words.add(userWord);
                                lives--;

                                if (lives==0){
                                    //Mensaje de perder el juego
                                    writter.println("lose the game, insert command 'CORRECTION' to send and specific email of your game reports and the correct word");
                                    playing = false;
                                }else {

                                    //Convertimos la palabra generada por el servidor en charArray
                                    char[] serverWordArray = word.toCharArray();
                                    //Convertimos la palabra introducida por el usuario en charArray
                                    char[] userWordArray = userWord.toCharArray();

                                    StringBuilder sb = new StringBuilder();
                                    //Se comparan ambos arrays con un bucle for
                                    for (int i = 0; i < userWordArray.length; i++) {
                                        if (userWordArray[i] == serverWordArray[i]){
                                            sb.append(ANSI_GREEN).append(userWordArray[i]).append(ANSI_RESET).append(" ");
                                        }else{
                                            boolean isAdjacent = false;

                                            if (i > 0 && userWordArray[i] == serverWordArray[i-1])
                                                isAdjacent = true;
                                            else if (i < userWordArray.length -1 && userWordArray[i] == serverWordArray[i+1])
                                                isAdjacent = true;


                                            if (isAdjacent)
                                                sb.append(ANSI_YELLOW).append(userWordArray[i]).append(ANSI_RESET).append(" ");
                                            else
                                                sb.append(userWordArray[i]).append(" ");
                                        }
                                    }
                                    //Se devuelve el StringBuilder coloreado
                                    writter.println(sb);
                                }
                            }
                        }
                        break;

                    case "correction":
                        if (playing)
                            writter.println("You cant do this yet, first finish the game");
                        else {
                            String email = userInputOnArray[1];

                            Thread sendMailTask = new Thread(new SendReportMail(winner,words,email, word));
                            sendMailTask.start();
                            writter.println("Se ha enviado un email al correo especificado con los reportes del juego");
                        }
                        break;

                    case "help":
                        writter.println("Si necesitas ayuda para jugar a esta mierda es que eres tonto/a");
                        break;

                    case "quit":
                        writter.println("¡Good bye!");
                        break;

                    default:
                        writter.println("Unknow command, please try again");
                        break;
                }

                if (command.equalsIgnoreCase("quit"))
                    break;
            }

        } catch (IOException e) {
            System.out.println("Error en el worker del servidor: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public  static String fetchWordFromApi (){
        String word;

        try {
            URL url = new URI("https://random-word-api.herokuapp.com/word?length=5").toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            BufferedReader apiReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String[] inputFromAPI = apiReader.readLine().split("\"");
            word = inputFromAPI[1];

        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error de acceso a la API: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en la recoleccion de datos de la API: "+e.getMessage());
            throw new RuntimeException(e);
        }
        return word;
    }
}
