package marcos.psp.examen.gestorTareas.tcp;

import marcos.psp.examen.gestorTareas.ftp.UploadTaskftp;
import marcos.psp.examen.gestorTareas.ftp.UploadTasksftp;
import marcos.psp.examen.gestorTareas.model.Task;
import marcos.psp.examen.gestorTareas.pop3.GetMails;
import marcos.psp.examen.gestorTareas.smtp.SendMailToBoss;

import javax.net.ServerSocketFactory;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TaskServer {
    public static final int PORT = 59999;

    public static List<Task> tareas = new ArrayList<>();
    public static int taskId = 0;

    public static void main(String[] args) {
        ServerSocketFactory factory = ServerSocketFactory.getDefault();

        try (ServerSocket serverSocket = factory.createServerSocket(PORT)){
            System.out.println("Servidor escuchando en el puerto "+PORT);

            while (true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Se ha conectado un nuevo cliente");

                new Thread(new TaskServerWorker(clientSocket,tareas)).start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor");
            throw new RuntimeException(e);
        }
    }


    /**
     * Metodo para marcar una tarea como completada y mandar un mail al administrador de que la tarea ha sido completada
     * @param id
     * @return boolean success
     */
    public synchronized static boolean completeTask (int id, String userName){
        for (Task t: tareas){
            if (t.getId() == id){
                if (t.getWorker().equalsIgnoreCase(userName)){
                    t.setRealizada(true);
                    new Thread(new SendMailToBoss(t)).start();
                    return true;
                }else
                    return false;
            }
        }
     return false;
    }

    /**
     * Metodo para crear una nueva tarea
     * @param name
     * @param description
     * @param worker
     */
    public synchronized static void createNewTask (String name, String description, String worker){
        Task task = new Task(taskId, false,name,description, worker);
        tareas.add(task);
        taskId++;
    }

    /**
     * Metodo que devueve una lista de tareas incompletas
     * @return ArrayList
     */
    public synchronized static List<Task> getIncompleteTasks (){
        List<Task> incompleteTasks = new ArrayList<>();

        for (Task t: tareas){
            if (!t.getRealizada())
                incompleteTasks.add(t);
        }

        return incompleteTasks;
    }


    /**
     * Metodo que se encarga de subir los archivos al servidor ftp cuando se ejecuta el comando upload
     * @throws InterruptedException
     */
    public synchronized static void uploadMails () throws InterruptedException {
        Thread getMailsTask = new Thread(new GetMails()); // Esto sería para recopilar los mails por pop3 y subirlos al servidor ftp, pero el servidor no lo permite
        getMailsTask.start();
        getMailsTask.join();


        File [] directory = new File("src/main/resources/gestorTareas/reportFiles").listFiles();

        new Thread( new UploadTaskftp(directory)).start();
//        new Thread( new UploadTasksftp(directory)).start(); //para sftp

    }


}
