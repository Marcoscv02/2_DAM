package marcos.psp.examen.gestorTareas.ftp;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UploadTaskftp implements Runnable{
    private File [] directory;

    public UploadTaskftp(File[] directory) {
        this.directory = directory;
    }

    public static final int PORT = 21;
    public static final String HOST = "192.168.1.9";
    public static final String USER = "marcos";
    public static final String PASSWORD = "marcos";

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        FTPClient cliente = new FTPClient();

        try {
            cliente.connect(HOST,PORT);
            cliente.login(USER, PASSWORD);

            // use local passive mode to pass firewall
            cliente.enterLocalPassiveMode();

            System.out.println("Connected");

            for (File file: directory) {
                System.out.println("entrada en el bucle directorio");
                boolean res =uploadSingleFile(cliente, file.getPath(), file.getName());
                showServerReply(cliente);
                file.delete();
                if (res)
                    System.out.println("El archivo se ha subido");
                else
                    System.out.println("El archivo no se ha subido");
            }


            // log out and disconnect from the server
            cliente.logout();
            cliente.disconnect();
            System.out.println("Disconnected, se ha finalizado el proceso de subida al servidor ftp");


        } catch (IOException e) {
            System.out.println("Error en el cliente ftp: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para subir un archivo a un servidor ftp
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
     * Metodo para mostrar las respuestas del servidor
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
