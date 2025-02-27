package com.ejemplo.wikipedia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.json.JSONObject;

public class ExampleCode {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Ingrese el código de país (por ejemplo, es, en, de): ");
        String countryCode = scanner.nextLine().trim();

        System.out.print("Ingrese la fecha (formato YYYY-MM-DD): ");
        String dateInput = scanner.nextLine().trim();

        // Validar y parsear la fecha
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput, DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            System.out.println("La fecha ingresada no es válida. Use el formato YYYY-MM-DD.");
            scanner.close();
            return;
        }
        scanner.close();

        // Construir la URL de la API de Wikipedia
        // Ejemplo de URL:
        // https://wikimedia.org/api/rest_v1/metrics/pageviews/top/es.wikipedia/all-access/2025/02/25
        String project = countryCode + ".wikipedia";  // Por ejemplo: "es.wikipedia"
        String access = "all-access";
        String year = String.format("%04d", date.getYear());
        String month = String.format("%02d", date.getMonthValue());
        String day = String.format("%02d", date.getDayOfMonth());
        String apiUrl = String.format(
                "https://wikimedia.org/api/rest_v1/metrics/pageviews/top/%s/%s/%s/%s/%s",
                project, access, year, month, day
        );

        System.out.println("Conectándose a la API: " + apiUrl);

        // Realizar la petición HTTP GET a la API
        String jsonResponse = fetchAPI(apiUrl);
        if (jsonResponse == null) {
            System.out.println("No se pudo obtener la respuesta de la API.");
            return;
        }

        // Parsear la respuesta a un objeto JSON para formatearlo adecuadamente
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonResponse);
        } catch (Exception e) {
            System.out.println("Error al parsear la respuesta a JSON: " + e.getMessage());
            return;
        }
        // Convertir el objeto JSON a una cadena formateada (indentada)
        String formattedJson = jsonObject.toString(4);

        // Guardar la respuesta en un archivo JSON
        String fileName = String.format("top_articles_%s_%s.json", countryCode, dateInput);
        Path filePath = Paths.get(fileName);
        try (FileWriter writer = new FileWriter(filePath.toFile())) {
            writer.write(formattedJson);
            System.out.println("Datos guardados en " + filePath.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo JSON: " + e.getMessage());
            return;
        }

        // Imprimir el contenido del archivo JSON en consola
        System.out.println("Contenido del archivo JSON:");
        System.out.println(formattedJson);

        // Subir el archivo al servidor FTP local de Serva (no se usa usuario anónimo)
        String ftpServer = "localhost";
        int ftpPort = 21;
        String ftpUser = "tuUsuario";      // Reemplaza por tu usuario FTP
        String ftpPass = "tuContraseña";     // Reemplaza por tu contraseña FTP

        boolean uploadSuccess = uploadFileToFTP(ftpServer, ftpPort, ftpUser, ftpPass, filePath.toFile(), fileName);
        if (uploadSuccess) {
            System.out.println("Archivo subido exitosamente al servidor FTP.");
        } else {
            System.out.println("Error al subir el archivo al servidor FTP.");
        }
    }

    /**
     * Realiza una petición GET a la API y retorna la respuesta en formato String.
     */
    private static String fetchAPI(String apiUrl) {
        StringBuilder result = new StringBuilder();
        HttpURLConnection conn = null;
        try {
            URL url = new URL(apiUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // Es recomendable establecer un User-Agent
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");

            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Error HTTP: " + responseCode);
                return null;
            }

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
            }
            return result.toString();
        } catch (IOException e) {
            System.out.println("Error al conectarse a la API: " + e.getMessage());
            return null;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    /**
     * Sube un archivo al servidor FTP usando las credenciales proporcionadas.
     */
    private static boolean uploadFileToFTP(String server, int port, String user, String pass,
                                           File localFile, String remoteFileName) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Conexión fallida al servidor FTP. Código de respuesta: " + replyCode);
                return false;
            }
            boolean loggedIn = ftpClient.login(user, pass);
            if (!loggedIn) {
                System.out.println("Error de autenticación en el servidor FTP.");
                return false;
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            try (InputStream inputStream = new FileInputStream(localFile)) {
                boolean done = ftpClient.storeFile(remoteFileName, inputStream);
                if (!done) {
                    System.out.println("No se pudo subir el archivo al servidor FTP.");
                }
                return done;
            }
        } catch (IOException ex) {
            System.out.println("Error en FTP: " + ex.getMessage());
            return false;
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException ex) {
                    System.out.println("Error al desconectar del FTP: " + ex.getMessage());
                }
            }
        }
    }
}
