package marcos.psp.examen.busReservation.ftp;

import com.jcraft.jsch.*;

import java.io.File;
import java.util.concurrent.Callable;

public class UploadedReportToSftpServer implements Callable<Boolean> {
    private final File file;

    public UploadedReportToSftpServer(File file) {
        this.file = file;
    }

    public static final int PORT = 60000;
    public static final String HOST = "192.168.1.9";
    public static final String USER = "tester";
    public static final String PASSWORD = "password";
    /**
     * Computes a result, or throws an exception if unable to do so.
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Boolean call(){
        JSch jSch = new JSch();

        Session session = null;
        try {
            session = jSch.getSession(USER,HOST,PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("se ha conectado con el servidor");

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.put(file.getPath(), file.getName());
            sftpChannel.disconnect();
            session.disconnect();
            return true;
        } catch (JSchException | SftpException e) {
            System.out.println("Error en la subida del archivo a servidor sftp: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
