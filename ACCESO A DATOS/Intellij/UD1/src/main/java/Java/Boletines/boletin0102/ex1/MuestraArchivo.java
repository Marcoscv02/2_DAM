package Java.Boletines.boletin0102.ex1;
import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MuestraArchivo {
    public static void main(String[] args) {
        // Crear un JFileChooser para seleccionar el archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo");
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Obtener el archivo seleccionado
            Path filePath = fileChooser.getSelectedFile().toPath();
            String fileName = filePath.getFileName().toString();
            int lastDotIndex = fileName.lastIndexOf(".");

            // Mostrar nombre del archivo y su extensión
            String nameWithoutExtension = (lastDotIndex == -1) ? fileName : fileName.substring(0, lastDotIndex);
            String extension = (lastDotIndex == -1) ? "Sin extensión" : fileName.substring(lastDotIndex + 1);

            JOptionPane.showMessageDialog(null,
                    "Nombre del archivo: " + nameWithoutExtension + "\n" +
                            "Extensión: " + extension,
                    "Detalles del archivo",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}