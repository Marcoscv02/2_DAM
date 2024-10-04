package org.example;

public class LaunchProcessDir {
    public static void main(String[] args) {
        ProcessBuilder pb= new ProcessBuilder("cmd.exe", "/c", "dir"); //Se crea el processBuilder con el comando a ejecutar

        String rutadir= pb.directory().getAbsolutePath();
        System.out.println("Ruta predeterminada de ejecución: "+rutadir);
    }
}
