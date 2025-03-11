package marcos.psp.exercise10;

import com.jcraft.jsch.*;

import java.io.File;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PicsumApp {
    //Conexion
    public static final String URL = "https://picsum.photos/200/300";
    public static final String LOCAL_PATH = "src/main/resources/Exercise10";
    //Servidor
    public static final String HOST = "192.168.56.1";
    public static final int PORT = 60000;
    public static final String USER = "tester";
    public static final String PASSWORD = "password";

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int iteraciones = random.nextInt(30);
        ExecutorService pool = Executors.newFixedThreadPool(16);

        File directory = new File(LOCAL_PATH);
        File[] imagenes = directory.listFiles();

        JSch jsch = new JSch();
        Session session;

        //Establecer conexion SSH
        try {
            session = jsch.getSession(USER, HOST, PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            showSftpServerLogs(session);
        } catch (JSchException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < iteraciones; i++) {
//            Runnable task = new DownloadImage(URL, LOCAL_PATH, i);
//            pool.execute(task);

            Thread th = new Thread(new DownloadImage(URL, LOCAL_PATH, i));
            th.start();

            File imagen = imagenes[i];
            System.out.println(imagen.getName());
            uploadImageToServer(imagen, session);

            imagen.delete();
        }

        session.disconnect();
    }


    private static void uploadImageToServer(File imagen, Session session) {

        try {
            //Abrir canal SFTP
            Channel canal = session.openChannel("sftp");
            canal.connect();
            //Conversion a canal sftp
            ChannelSftp canalSftp = (ChannelSftp) canal;

            canalSftp.put(imagen.getPath(), imagen.getName());
            showSftpServerLogs(session);
            System.out.println("imagen subida correctamente");

        } catch (JSchException | SftpException e) {
            System.out.println("Error en la subida de archivos al servidor");
            throw new RuntimeException(e);
        }
    }

    private static void showSftpServerLogs(Session session) {
        // Habilitar logging de JSch (opcional)
        JSch.setLogger(new Logger() {
            public void log(int level, String message) {
                System.out.println("SSH Log: " + message);
            }
            public boolean isEnabled(int level) {
                return true;
            }
        });

        // Obtener mensajes de error de la sesión (si hay)
        if (!session.isConnected()) {
            System.out.println("Error en conexión SSH: " + session.getHost());
        }
    }
}
