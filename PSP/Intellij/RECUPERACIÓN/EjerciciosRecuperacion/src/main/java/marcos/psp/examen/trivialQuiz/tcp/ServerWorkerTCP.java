package marcos.psp.examen.trivialQuiz.tcp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import marcos.psp.examen.trivialQuiz.model.Result;
import marcos.psp.examen.trivialQuiz.model.Trivial;
import marcos.psp.examen.trivialQuiz.model.TrivialTypeAdapter;
import marcos.psp.examen.trivialQuiz.model.report.QuestionReport;
import marcos.psp.examen.trivialQuiz.smtp.SendMessage;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerWorkerTCP implements Runnable{
    Socket socket;

    public ServerWorkerTCP(Socket socket) {
        this.socket = socket;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        String userName = null;
        int category = 0;
        int numQuestions = 0;
        String difficult = null;
        boolean playing = false;
        List<QuestionReport> resultados = new ArrayList<>();


        try(BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writter = new PrintWriter(socket.getOutputStream(),true)) {

            while (true){
                String userInput = reader.readLine().trim().toLowerCase();
                String [] userInputOnArray = userInput.split(" ");
                String command = userInputOnArray[0];

                switch (command){

                    case "new":
                        if (!playing){
                            playing=true;
                            if (userInputOnArray.length!=2){
                                writter .println("NOT ACCEPT: User Input format incorrect");
                                break;
                            }else {
                                System.out.println("Empieza nuevo juego");
                                userName = userInputOnArray[1];
                                writter.println("ACCEPT: Hello "+userName);
                                break;
                            }
                        }else{
                           writter.println("No se puede iniciar un nuevo juego mientras se está dentro de uno");
                        }

                    case "trivial":
                        if (playing){
                            if (userInputOnArray.length!=4){
                                writter .println("NOT ACCEPT: User Input format incorrect");
                                break;
                            }else {
                                category= Integer.parseInt(userInputOnArray[1]);
                                difficult= userInputOnArray[2];
                                numQuestions= Integer.parseInt(userInputOnArray[3]);

                                Trivial trivial = fetchApi(category,numQuestions,difficult);
                                if (trivial.getResposeCode()==0){
                                    List<Result> questions = trivial.getQuestions();

                                    for (int i = 0; i < questions.size(); i++) {
                                        boolean acertada =showQuestion(reader,writter, questions.get(i));

                                        QuestionReport qs = new QuestionReport(questions.get(i), acertada);
                                        resultados.add(qs);
                                    }

                                    writter.println("El trivial ha terminado, inserte el comando 'CORRECTION' para continuar");
                                    break;

                                }else {
                                    //Esto maneja el responseCode = 1 que se da cuando no hai suficientes preguntas en la api en esa categoria y dificultad
                                    writter.println("No hai suficientes preguntas en esta configuracion de trivial, intente de nuevo");
                                    break;
                                }
                            }
                        }else {
                            writter.println("Necesitas iniciar un nuevo juego para usar este comando");
                            break;
                        }

                    case "correction":
                        if (userInputOnArray.length!= 2){
                            writter .println("NOT ACCEPT: User Input format incorrect");
                            break;
                        }else {
                            String email = userInputOnArray[1];
                            Thread sendMailTask = new Thread(new SendMessage(socket,email,resultados));
                            sendMailTask.start();
                            writter.println("ACCEPT: Se ha enviado el correo con el numero de aciertos al correo especificado");
                            break;
                        }
                    case "exit":
                        writter.println("Good Bye "+userName);

                    default:
                        writter.println("Este comando es incorrecto");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error de IO en el hilo del servidor: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }



    /**
     * Metodo para acceder a la APi
     * @return  objeto de tipo Trivial con as características especificadas
     */
    public static Trivial fetchApi (int category, int numQuestions, String difficult){
        Trivial trivial;
        try {
            URL apiUrl = new URI("https://opentdb.com/api.php?amount="+numQuestions+"&category="+category+"&difficulty="+difficult).toURL();
            InputStream connection = apiUrl.openStream();


            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Trivial.class, new TrivialTypeAdapter())
                    .create();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection))) {
                // Deserializar el JSON a un objeto Trivial
                 trivial= gson.fromJson(br, Trivial.class);

                 return trivial;

            } catch (IOException e) {
                System.out.println("Error al serializar el objeto trivial: "+e.getMessage());
                throw new RuntimeException(e);
            }


        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println("Error en la url: "+e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error de IO en el acceso a API: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }



    /**
     * Metodo para enviar una pregunta al cliente y comprobar si la ha acertado
     * @return booleano que infica si ha sido acertada o no
     * @Params reader, writter, Result
     */
    public static Boolean showQuestion (BufferedReader reader, PrintWriter writer, Result result) throws IOException {
        //Añadir todas las opciones a un array de strings para presentarselas al usuario
        List<String> options = new ArrayList<>();
        options.add(result.getCorrectAnswer());
        options.addAll(result.getIncorrectAnswers());
        //Reordena el arrayList de forma aleatoria
        Collections.shuffle(options);

        StringBuilder sb = new StringBuilder();
        sb.append("(").append(result.getCategory()).append(")").append(result.getQuestion()).append(": ");

        for (String option : options) {
            sb.append(option).append(" | ");
        }

        System.out.println(sb);
        writer.println(sb);

        String userResponse = reader.readLine();
        if (userResponse.equalsIgnoreCase(result.getCorrectAnswer().trim().toLowerCase())) {
            System.out.println("El cliente ha acertado la pregunta");
            return true;
        }else {
            System.out.println("El cliente ha fallado la pregunta");
            return false;
        }
    }



}
