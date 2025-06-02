package marcos.psp.examen.trivialQuiz.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UploadToFtp implements Runnable{
   private File file;

   //Datos de servidor Serva
    public static final String HOST= "192.168.1.9";
    public static final int PORT = 21;
    public static final String USER = "marcos";
    public static final String PASSWORD = "marcos";


    public UploadToFtp(File file) {
        this.file = file;
    }

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Iniciando subida a servidor ftp");
        FTPClient client = new FTPClient();

        try {
            //Conectarse al servidor y loguearse
            client.connect(HOST,PORT);
            client.login(USER,PASSWORD);
            showServerReply(client);

            client.enterLocalPassiveMode();
            System.out.println("Servidor ftp conectado");

            boolean isUploaded = uploadSingleFile(client, file.getPath(), file.getName());
            showServerReply(client);
            if (isUploaded){
                System.out.println("Archivo subido a servidor fpt con éxito");
                file.delete();
            }
            else {
                System.out.println("Ha habido un problema en la subida del archivo al servidor ftp");
            }



        } catch (IOException e) {
            System.out.println("Error en el proceso de conectarse al servidor SMTP: "+e.getMessage());
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
            ftpClient.setFileType(FTP.ASCII_FILE_TYPE);
            return ftpClient.storeFile(remoteFilePath, inputStream);
        } finally {
            inputStream.close();
        }
    }
}
