package marcos.psp.examen.chuckNorris.ftp;

import marcos.psp.examen.chuckNorris.model.Joke;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;

public class ChuckNorrisDownLoad implements Runnable{
    private Joke joke;

    public ChuckNorrisDownLoad(Joke joke) {
        this.joke = joke;
    }

    public static final String HOST = "192.168.1.16";
    public static final int PORT = 21;
    public static final String USER = "marcos";
    public static final String PASSWORD = "marcos";

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        File f = new File("src/main/resources/chuckNorris/joke"+joke.getId()+"+.txt");
        if (!f.exists())
            f.getParentFile().mkdirs();

        try (BufferedWriter fileWritter = new BufferedWriter(new FileWriter(f));){
            fileWritter.write(joke.getValue());
        } catch (IOException e) {
            System.out.println("Error en la escritura de ña broma en el archivo");
            throw new RuntimeException(e);
        }

        FTPClient cliente = new FTPClient();

        try {
            cliente.connect(HOST,PORT);
            showServerReply(cliente);
            cliente.login(USER,PASSWORD);
            showServerReply(cliente);
            cliente.enterLocalPassiveMode();

            uploadSingleFile(cliente, f.getPath(), f.getName());
            showServerReply(cliente);

            cliente.logout();
            cliente.disconnect();
        } catch (IOException e) {
            System.out.println("Error en la conexión al servidor ftp");
            throw new RuntimeException(e);
        }
    }

    /**
     * Muestra las respuestas del servidor
     * @param ftpClient
     */
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }

    /**
     * Subir un archivo al servidor
     * @param ftpClient
     * @param localFilePath
     * @param remoteFilePath
     * @return success
     * @throws IOException
     */
    public static boolean uploadSingleFile(FTPClient ftpClient, String localFilePath, String remoteFilePath) throws IOException {
        File localFile = new File(localFilePath);
        InputStream inputStream = new FileInputStream(localFile);
        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            return ftpClient.storeFile(remoteFilePath, inputStream);
        } finally {
            inputStream.close();
        }
    }
}