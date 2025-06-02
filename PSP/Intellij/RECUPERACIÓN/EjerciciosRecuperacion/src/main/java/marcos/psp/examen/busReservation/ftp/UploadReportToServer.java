package marcos.psp.examen.busReservation.ftp;


import com.jcraft.jsch.Session;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class UploadReportToServer implements Callable<Boolean> {
    private final File file;

    public UploadReportToServer(File file) {
        this.file = file;
    }


    //FTP
    public static final int PORT = 21;
    public static final String IP = "192.168.1.16";
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
        System.out.println("Se accede al hilo UploadReportToServer");
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(IP, PORT);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " +
                        replyCode);
            }
            boolean success = ftpClient.login(USER, PASSWORD);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
            } else {
                System.out.println("LOGGED IN SERVER");

                return uploadSingleFile(ftpClient, file.getPath(), file.getName());
            }
        } catch (IOException ex) {
            System.out.println("Something wrong happened");
            ex.printStackTrace();
        }finally {
            ftpClient.logout();
            ftpClient.disconnect();
        }
       return false;
    }


    /**
     * Metodo para mostrar la respuesta del servidor
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
     * Metodo para subir un archivo a un servidor ftp
     * @param ftpClient
     * @param localFilePath
     * @param remoteFilePath
     * @return boolean: success
     * @throws IOException
     */
    public static boolean uploadSingleFile(FTPClient ftpClient,
                                           String localFilePath, String
                                                   remoteFilePath) throws IOException {
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

