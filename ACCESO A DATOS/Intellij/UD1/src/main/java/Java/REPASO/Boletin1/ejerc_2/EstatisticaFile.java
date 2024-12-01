package Java.REPASO.Boletin1.ejerc_2;

import java.io.*;

public class EstatisticaFile {
    private File archivo;
    private int linhas=0;
    private int letras=0;
    private int espazos=0;

    public EstatisticaFile (File Archivo) {
        this.archivo = Archivo;
        calcularEstadisticas();
    }

    // Métodos para obtener estadísticas
    public boolean existe() {
        return archivo.exists();
    }

    public String lastModified(){
        if (!archivo.exists()) System.out.println("El archivo no existe");
        return String.valueOf(archivo.lastModified());
    }

    public String getRuta(){
        return archivo.getAbsolutePath();
    }

    //Metodo para calcular las espadisticas del texto
    private void calcularEstadisticas(){

        try (var br= new BufferedReader(new FileReader(archivo))){
        String linea;

            while ((linea=br.readLine())!=null){
                linhas++; //aumenta lineas
                for (char c: linea.toCharArray()){
                    if (Character.isLetter(c)){
                        letras++; //aumenta letras
                    }

                    if(Character.isWhitespace(c)){
                        espazos++; //aumnenta espacios
                    }
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getLinhas() {
        return linhas;
    }

    public int getLetras() {
        return letras;
    }

    public int getEspazos() {
        return espazos;
    }
}
