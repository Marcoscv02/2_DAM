package marcos.psp.exercise8;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WikiApp {
    public static void main(String[] args) {
        //Crea un objeto escaner y obtener los datos introducidos por el usuario;
        Scanner sc= new Scanner(System.in);

        System.out.println("Introduce codigo del pais del que se desean obtener los artículos (ejemplo : ES, EN, US)");
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
        fullUrlSb.append(date.getMonth()).append("/");
        fullUrlSb.append(date.getDayOfMonth());

        String fullUrl = fullUrlSb.toString();

        System.out.println("Conectandose a la API");
        String jsonResponse = fetchApi(fullUrl);
        if (jsonResponse==null) System.out.println("No se pudieron obtener datos de la api");

        JSONObject jsonObject;

        jsonObject= new JSONObject(jsonResponse);
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
     * Subir el archivo al servidor FTP usando las credenciales proporcionadas
     */
    private static boolean uploadFileToserver (String server, int port, String user, String pass,
                                               File localFile, String remoteFileName){



        return false;
    }


}
