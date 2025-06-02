package marcos.psp.examen.gestorTareas.ftp;

import com.jcraft.jsch.*;

import java.io.File;

public class UploadTasksftp implements Runnable{
    private final File [] directory;

    public UploadTasksftp(File[] directory) {
        this.directory = directory;
    }

    public static final String HOST = "192.168.1.9";
    public static final int PORT = 60000;
    public static final String USER = "tester";
    public static final String PASSWORD = "password";

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        System.out.println("Iniciando subida a servidor sftp");
        JSch jSch = new JSch();

        try {
            Session session = jSch.getSession(USER,HOST,PORT);
            session.setPassword(PASSWORD);
            session.connect();
            System.out.println("Se ha accedido al servidor sftp");

            ChannelSftp channel = (ChannelSftp) session.openChannel("spft");
            channel.connect();

            for (File file: directory) {
                channel.put(file.getPath(), file.getName());
                file.delete();
            }

            channel.disconnect();
            session.disconnect();
            System.out.println("Se ha terminado el proceso de subida a servidor sftp");

        } catch (JSchException | SftpException e) {
            System.out.println("Error en el cliente Sftp: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
