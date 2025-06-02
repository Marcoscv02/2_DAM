package marcos.psp.examen.clemenRaffle_examen.ftp;

import com.jcraft.jsch.Session;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SaveMessgesOnServer implements Runnable{
    public static final String HOST = "192.168.1.9";
    public static final int PORT = 21;
    public static final String USER = "marcos";
    public static final String PASSWORD = "marcos";

    private File file;

    public SaveMessgesOnServer(File file) {
        this.file = file;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        FTPClient cliente = new FTPClient();

        try {
            cliente.connect(HOST,PORT);
            showServerReply(cliente);

            int replyCode = cliente.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " +
                        replyCode);
                return;
            }
            boolean success = cliente.login(USER, PASSWORD);
            showServerReply(cliente);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
                boolean isUploaded = uploadSingleFile(cliente, file.getPath(), file.getName());

                if (isUploaded)
                    System.out.println("Un archivo subido al servidor con éxito");

            }
        } catch (IOException e) {
            System.out.println("Error de conexión con el servidor ftp: "+e.getMessage());
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
