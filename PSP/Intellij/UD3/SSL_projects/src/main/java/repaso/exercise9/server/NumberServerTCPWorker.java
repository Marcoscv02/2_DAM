package repaso.exercise9.server;

import javax.net.ssl.SSLSocket;
import java.io.*;
import java.net.*;

public class NumberServerTCPWorker  implements Runnable{
    public static final String BASE_URL = "http://numbersapi.com/";
    SSLSocket socket;

    public NumberServerTCPWorker(SSLSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            var writter = new PrintWriter( socket.getOutputStream());

            while (true){

                String userInput = reader.readLine();
                userInput = userInput.toLowerCase(); //Segunda verificacion de que el comando esta en minúsculas
                String [] splitInput = userInput.split(" ");
                String command = splitInput[0];

                switch (command) {
                    case "number":
                        StringBuilder fullUrl = new StringBuilder();
                        fullUrl.append(BASE_URL);
                        String number_letters = splitInput[1];
                        String type = splitInput[2];

                        if (number_letters != null && type!=null) {

                            //Validación primer argumento
                            if (isNumeric(number_letters) || number_letters.equalsIgnoreCase("random")) {

                                fullUrl.append(number_letters);
                                fullUrl.append("/");

                            } else {
                                writter.write("Argumento 1 no válido ");
                                writter.flush();
                                break;
                            }

                            //Validación segundo argumento
                            if (type.equalsIgnoreCase("trivia") || type.equalsIgnoreCase("math") || type.equalsIgnoreCase("year")) {
                                fullUrl.append(type);

                            } else {
                                writter.write("Argumento 2 no válido ");
                                writter.flush();
                                break;
                            }

                            String apiResponse = fetchAPI(fullUrl.toString());
                            writter.println(apiResponse);
                            writter.flush();
                            break;

                        }else {
                            writter.write("Debe haber 2 argumentos");
                            writter.flush();
                            break;
                        }

                    case "end":
                        writter.println("Cerrando programa...");
                        writter.flush();
                        break;

                    default:
                        writter.println("Este comando no existe");
                        writter.flush();
                        break;

                }

                if (command.equalsIgnoreCase("end"))
                    break;

            }

        } catch (IOException | URISyntaxException e) {
            System.out.println("Error en el hilo del sevidor");
            throw new RuntimeException(e);
        }
    }

    private static String fetchAPI (String url) throws URISyntaxException, IOException {
        StringBuilder apiResponse = new StringBuilder();
        URL url2 = new URI(url).toURL();

        HttpURLConnection connection = (HttpURLConnection) url2.openConnection();

        var reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null){
            apiResponse.append(line);
        }

        return apiResponse.toString();
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
