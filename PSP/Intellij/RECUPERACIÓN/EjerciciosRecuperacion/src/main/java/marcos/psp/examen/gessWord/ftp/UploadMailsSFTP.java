package marcos.psp.examen.gessWord.ftp;

import com.jcraft.jsch.*;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;

public class UploadMailsSFTP implements Runnable{
    private File file;

    public UploadMailsSFTP(File file) {
        this.file = file;
    }

    //Declaración de constantes de conexión con el servidor
    public static final String HOST = "192.168.1.9 ";
    public static final int PORT = 60000;
    public static final String USER = "tester";
    public static final String PASSWORD = "password";

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Se inicia subida del archivo al servidor sftp");
        JSch jsch = new JSch();
        Session session;
        try {
            session = jsch.getSession(USER, HOST, 22);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.put(file.getPath(), file.getName());
            sftpChannel.disconnect();
            System.out.println("Archivo subido al servidor sftp con éxito");
            session.disconnect();
        } catch (SftpException | JSchException e) {
            System.out.println("Error en la subida del archivo al servidor sftp");
            e.printStackTrace();
        }
    }
}
