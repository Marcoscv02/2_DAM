package marcos.psp.examen.jokes.ftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.File;
import java.util.concurrent.Callable;

public class SaveJokesSftp implements Callable<Boolean> {
    private File[] directory;

    public SaveJokesSftp(File[] directory) {
        this.directory = directory;
    }

    public static final String HOST = "192.168.1.9";
    public static final int PORT = 60000;
    public static final String USER = "tester";
    public static final String PASSWORD = "password";

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Boolean call() throws Exception {
        System.out.println("Se inicia la tarea sftp");
        JSch jSch = new JSch();

        Session session = jSch.getSession(USER, HOST, PORT);
        session.setPassword(PASSWORD);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        System.out.println("Se ha conectado al servidor sftp");

        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp sftpChannel = (ChannelSftp) channel;
        for (File f : directory){
            sftpChannel.put(f.getPath(), f.getName());
            f.delete();
        }
        sftpChannel.disconnect();
        session.disconnect();
        System.out.println("La tarea de subir archivos a servidor ftp ha terminado");
        return true;
    }
}
