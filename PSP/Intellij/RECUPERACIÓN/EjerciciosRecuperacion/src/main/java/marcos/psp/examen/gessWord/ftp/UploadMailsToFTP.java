package marcos.psp.examen.gessWord.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UploadMailsToFTP implements Runnable{
    private File file;

    public UploadMailsToFTP(File file) {
        this.file = file;
    }

    public static final int PORT = 21;
    public static final String HOST = "192.168.1.9";
    public static final String USER = "marcos";
    public static final String  PASSWORD = "marcos";


    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Iniciando subida al servidor ftp");
        FTPClient client = new FTPClient();
        // connect and login to the server
        try {
            client.connect(HOST, PORT);
            client.login(USER, PASSWORD);
            showServerReply(client);
            // use local passive mode to pass firewall
            client.enterLocalPassiveMode();

            uploadSingleFile(client, file.getPath(), file.getName());
            System.out.println("Archivo subido a servidor sftp con éxito");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }

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
