package marcos.psp.examen.jokes.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class SaveJokesFtp implements Callable<Boolean> {
    private final File[] directory;

    public SaveJokesFtp(File[] directory) {
        this.directory = directory;
    }

    public static final String HOST = "192.168.1.9";
    public static final int PORT = 21;
    public static final String USER = "marcos";
    public static final String PASSWORD = "marcos";

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Boolean call() throws Exception {
        FTPClient cliente = new FTPClient();
        cliente.connect(HOST,PORT);
        showServerReply(cliente);
        cliente.login(USER,PASSWORD);
        showServerReply(cliente);

        cliente.enterLocalPassiveMode();

        for (File f: directory){
            boolean success = uploadSingleFile(cliente, f.getPath(),f.getName());

            if (!success) {
                cliente.logout();
                cliente.disconnect();
                return false;
            }else
                f.delete();
        }
        showServerReply(cliente);
        cliente.logout();
        cliente.disconnect();
        return true;
    }

    /**
     * Metodo para subir un archivo al servidor ftp
     * @param ftpClient
     * @param localFilePath
     * @param remoteFilePath
     * @return boolean success
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

    /**
     * Metodo para obtener y mostar las respuestas del servidor
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
}
