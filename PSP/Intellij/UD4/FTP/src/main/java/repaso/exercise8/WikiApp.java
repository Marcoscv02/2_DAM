package repaso.exercise8;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.json.JSONObject;

import java.io.*;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WikiApp {
    public static final String HOST = "192.168.56.1";
    public static final String USER = "marcos";
    public static final String PASSWORD = "marcos";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("___WELCOME TO WIKIAPP___");
        System.out.println("Escribe el codigo binario de un pais. Ex: es,us...");
        String countryCode = sc.nextLine();

        System.out.println("Esribe la fecha de la que se obtendran los artículos en formato 'yyy-mm-dd'");
        String dateString = sc.nextLine();


        //Parsear fecha a formato localDate
        LocalDate date;
        try {
            date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            System.out.println("formato de la fecha incorrecto");
            sc.close();
            return;
        }
        sc.close();

        String month = String.format("%02d", date.getMonthValue());
        String day = String.format("%02d", date.getDayOfMonth());
        String fullUrl = "https://wikimedia.org/api/rest_v1/metrics/pageviews/top/"+countryCode+".wikipedia/" +
                "all-access/"+date.getYear()+"/"+month+"/"+day;

        //Obtener respuesta de la APi
        String apiResponse = fetchApi(fullUrl);
        if (apiResponse==null)
            return;

        //Parsear respuesta a formato json
        JSONObject json;

        json = new JSONObject(apiResponse);

        String formattedJson = json.toString(3);
        File jsonFile = new File("src/main/resources/exercise8/TopArticles_"+countryCode+"_"+date+".json");

        //Escribir el json en un archivo
        try (FileWriter writer = new FileWriter(jsonFile)){
            writer.write(formattedJson);

        } catch (IOException e) {
            System.out.println("Error en la escritura del archivo json");
            throw new RuntimeException(e);
        }

        boolean success = uploadFtpFile(jsonFile);
        jsonFile.delete();

        if (success) {
            System.out.println("Archivo subido con éxito");

        }else
            System.out.println("No se ha podido subir el archivo al servidor");



    }

    /**Metodo para obtener el objeto json de la api*/
    private static String fetchApi (String urlText) {
        StringBuilder apiResponse = new StringBuilder();

        try {
            URL url = new URI(urlText).toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){

                BufferedReader urlReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String linea;
                while ((linea = urlReader.readLine()) != null){
                    apiResponse.append(linea);
                }

                return apiResponse.toString();

            }else {
                System.out.println("No se ha podido conectar con la API");
                return null;
            }

        } catch (MalformedURLException | URISyntaxException e) {
            System.out.println("Error en conexion con API");
            throw new RuntimeException(e);

        } catch (IOException e) {
            System.out.println("Error de IO en el método fetchApi");
            throw new RuntimeException(e);
        }
    }




    /**Metodo para subir un archivo al servidor FTP*/
    private static boolean uploadFtpFile (File file){
        boolean succes;
        FTPClient cliente = new FTPClient();
        try {
            cliente.connect(HOST);
            showServerReply(cliente);
            cliente.login(USER,PASSWORD);
            showServerReply(cliente);
            cliente.enterLocalPassiveMode();
            showServerReply(cliente);

            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            showServerReply(cliente);

            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
            succes = cliente.storeFile(file.getName(), reader);


        } catch (IOException e) {
            System.out.println("Error en la subida del archivo");
            throw new RuntimeException(e);
        }finally {
            try {
                cliente.logout();
                cliente.disconnect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return succes;
    }


    /**
     * Metodo que muestra las respuestas del servidor
     */
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }

}
