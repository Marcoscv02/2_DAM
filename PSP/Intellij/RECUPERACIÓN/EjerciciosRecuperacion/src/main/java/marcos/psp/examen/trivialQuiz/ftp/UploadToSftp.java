package marcos.psp.examen.trivialQuiz.ftp;

import com.jcraft.jsch.*;
import java.io.File;

public class UploadToSftp implements Runnable {
    private File file;

    // Configuración del servidor SFTP (FileZilla)
    private static final String HOST = "192.168.61.244 ";
    private static final int PORT = 60000 ;
    private static final String USER = "tester";
    public static final String PASSWORD = "password";
    private static final String PRIVATE_KEY_PATH = "src/main/resources/Trivial/MarcosPrivate.ppk"; // Ruta a tu clave privada

    public UploadToSftp(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        System.out.println("Iniciando subida a servidor SFTP");

        JSch jsch = new JSch();
        Session session = null;


        try {
            //Crear sesión SSH
            session = jsch.getSession(USER, HOST, PORT);
            session.setPassword(PASSWORD);
            session.setConfig("StrictHostKeyChecking", "no"); // Para entornos de prueba
            session.connect();
            System.out.println("Conexión SSH establecida");

            //Abrir canal SFTP
            Channel channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;
            System.out.println("Canal SFTP abierto");

            //Subir archivo
            boolean isUploaded = uploadSingleFile(sftpChannel, file.getPath(), file.getName());

            if (isUploaded) {
                System.out.println("Archivo subido a servidor SFTP con éxito");
                file.delete();
            } else {
                System.out.println("Error en la subida del archivo");
            }

            //Cerrar ambas conexiones para liberar recursos
            sftpChannel.disconnect();
            session.disconnect();
        } catch (JSchException e) {
            System.out.println("Error en la conexión con el servidor sftp: "+e.getMessage());
            e.printStackTrace();
        }
    }

    private boolean uploadSingleFile(ChannelSftp sftpChannel, String localFilePath, String remoteFileName) {
        try {
            sftpChannel.put(localFilePath, remoteFileName);
            return true;

        } catch (Exception e) {
            System.out.println("Error en la subida del archivo: "+e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
