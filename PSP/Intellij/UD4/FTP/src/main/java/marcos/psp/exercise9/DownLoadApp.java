package marcos.psp.exercise9;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;
import java.net.SocketException;
import java.util.Scanner;

public class DownLoadApp {
    public static final String HOST = "ftp.scene.org";
    public static final int PORT = 21;
    public static final String USER = "anonymous";
    public static final String PASSWORD = "a24marcoscv@iessanclemente.net";
    public static String currentPath = "/pub";

    public static void main(String[] args) throws SocketException {
        FTPClient cliente = new FTPClient();

        try{
            cliente.connect(HOST);
            showServerReply(cliente);
            cliente.login(USER, PASSWORD);
            cliente.enterLocalPassiveMode();

            FTPFile file;
            do {
                file = navigateServer(cliente);
            }while (file.isDirectory());

            if ( file.isFile() && file!=null) {
                boolean done = downloadFile(cliente, file);

                if (done) System.out.println("descarga realizada con éxito");
                else System.out.println("No se ha podido realizar la descarga");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static FTPFile navigateServer (FTPClient cliente) throws IOException {
        Scanner sc= new Scanner(System.in);
        FTPFile [] listOfFiles = cliente.listFiles(currentPath);

        System.out.println("--- Listado de archivos en: "+currentPath+" ---");

        for (int i = 0; i < listOfFiles.length; i++) {
            FTPFile currentFile = listOfFiles[i];

            if (currentFile.isDirectory()){

                System.out.println(i+" [DIR] "+ currentFile.getName()+" size: "+currentFile.getSize()+"kb. ");

            }else {

                System.out.println(i+" [FILE] "+ currentFile.getName()+" size: "+currentFile.getSize()+"kb. ");

            }
        }
        System.out.println("Seleccione un archivo");
        int selectedFileIndex = sc.nextInt();

        FTPFile selectedFile = listOfFiles[selectedFileIndex];
        currentPath += "/"+selectedFile.getName();

        return selectedFile;
    }


    private static boolean downloadFile (FTPClient cliente, FTPFile archivo) throws IOException {
        String remoteFile = currentPath;
        File localFile = new File(archivo.getName());

        OutputStream os = new FileOutputStream(localFile);
        boolean success = cliente.retrieveFile(remoteFile, os);

        return success;
    }

    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
}
