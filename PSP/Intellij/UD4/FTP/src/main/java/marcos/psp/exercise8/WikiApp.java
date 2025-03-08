package marcos.psp.exercise8;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.json.JSONException;
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
        //Crea un objeto escaner y obtener los datos introducidos por el usuario;
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduce codigo del pais del que se desean obtener los artículos (ejemplo : es, en, us)");
        String countryCode= sc.nextLine();

        System.out.println("Introduce la fecha en formato 'YYYY-MM-DD'");
        String dateInput= sc.nextLine();

        //Validar la fecha obtenida
        LocalDate date;
        try{
            date= LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            System.out.println("La fecha introducida no está en el formato correcto");
            sc.close();
            return;
        }
        sc.close(); //Cerrar escaner para libear recursos

        //Crear la url de acceso a la API
        String genearalUrl= "https://wikimedia.org/api/rest_v1/metrics/pageviews/top/";

        StringBuilder fullUrlSb= new StringBuilder();
        fullUrlSb.append(genearalUrl);
        fullUrlSb.append(countryCode).append(".wikipedia/all-access/");
        fullUrlSb.append(date.getYear()).append("/");
        fullUrlSb.append(String.format("%02d",date.getMonthValue())).append("/");
        fullUrlSb.append(String.format("%02d", date.getDayOfMonth()));

        String fullUrl = fullUrlSb.toString(); //Url de acceso a la Api

        //Se llama al metodo que se conecta a la API y devuelve una cadena de texto con el JSON obtenido
        System.out.println("Conectandose a la API" + fullUrl);
        String jsonResponse = fetchApi(fullUrl);
        if (jsonResponse==null) System.out.println("No se pudieron obtener datos de la api");

        JSONObject jsonObject;

        //Se transforma la cadena obtenida a formato json
        try{
            jsonObject= new JSONObject(jsonResponse);
        } catch (JSONException e) {
            System.out.println("Error al parsear la respuesta de la API a Json, "+e.getMessage());
            return;
        }

        //Se vuelve a parsear a String ya formateado y se declara un archivo.json en el que se guardará
        String formattedJson= jsonObject.toString(4);
        File jsonFile= new File("top_Articles_"+countryCode+"_"+dateInput+".json");

        //se escribe el json en el archivo
        try(FileWriter writter= new FileWriter(jsonFile)){
            writter.write(formattedJson);
            System.out.println("Datos guardados en: "+jsonFile.getPath());
        } catch (IOException e) {
            System.out.println("Error al escribir los datos en el archivo. "+e.getMessage());
            throw new RuntimeException(e);
        }

        //Se envia archivo al metodo encargado de subir el archivo
        boolean isUploadOk = uploadFileToserver(jsonFile.getName());

        if (isUploadOk) System.out.println("Proceso realizadon con éxito");
        else System.out.println("No se ha podido subir el archivo");

        jsonFile.delete();//Eliminar el archivo después de ser subido al servidor

    }

    /**
     *  Metodo que accede al api a través de una url proporcionada y obtener los datos de la misma
     * @return String
    */
    public  static String fetchApi (String url){
        StringBuilder result= new StringBuilder(); //Resultado
        HttpURLConnection connection=null; //Objeto de conexion

        try{//Crear url y abrir conexión
            URL url1= new URL(url);
            connection= (HttpURLConnection) url1.openConnection();

            //Obtener codigo de respuesta de la conexion http y validación de errores
            int responseCode= connection.getResponseCode();
            if (responseCode!=HttpURLConnection.HTTP_OK){
                System.out.println("Error en la conexión http "+ responseCode);
                return null;
            }

            //Lee cada línea de la api y la agrega en un stringBuilder
            try (var reader= new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                String linea;
                while ((linea=reader.readLine())!=null){
                    result.append(linea);
                }
            }

            return result.toString();

        } catch (IOException e) {
            System.out.println("Error en la conexion y lectura con la API: "+e.getMessage());
            throw new RuntimeException(e);
        }finally {
            //Se cierra la conexión para liberar recursos
            if (connection!=null)  connection.disconnect();
        }
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

    private static boolean uploadFileToserver(String fileName){
        FTPClient cliente = new FTPClient();
        boolean success = false;

        try {
            cliente.connect(HOST);
            showServerReply(cliente);
            cliente.login(USER, PASSWORD);
            cliente.enterLocalPassiveMode();
            showServerReply(cliente);
            cliente.setFileType(FTP.BINARY_FILE_TYPE);
            showServerReply(cliente);

            File file= new File(fileName);

            try (InputStream fileIS = new FileInputStream(file)){
                success = cliente.storeFile(fileName, fileIS);
                showServerReply(cliente);
            }

        } catch (IOException e) {
            System.out.println("Error en la subida del archivo" + e.getMessage());
        }finally {
            try {
                cliente.logout();
                cliente.disconnect();
            } catch (IOException e) {
                System.out.println("Error en la desconexión del servidor" + e.getMessage());
            }
        }

        return success;
    }
}
