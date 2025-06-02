package marcos.psp.examen.harryPotter.tcp;

import com.google.gson.Gson;
import marcos.psp.examen.harryPotter.model.Book;
import marcos.psp.examen.harryPotter.model.Character;
import marcos.psp.examen.harryPotter.model.House;
import marcos.psp.examen.harryPotter.model.Spell;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class HarryPotterServer {
    public static final int PORT = 59999;

    private static Book[] books;
    private static Character[] strings;
    private static House[] houses;
    private static Spell[] spells;

    public static void main(java.lang.String[] args) {
        //Properties can be specified by code
        System.setProperty("javax.net.ssl.keyStore", "ServerKeys.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "abc123.");

        SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(PORT)){
            System.out.println("Servidor escuchando en puerto "+PORT);
            loadData();//Cargar los datos en el servidor

            while (true){
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Se ha conectado un nuevo cliente");
                new Thread(new HarryPotterServerWorker(clientSocket, books, strings, houses, spells)).start();
            }

        } catch (IOException e) {
            System.out.println("Error en el servidor: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo para cargar todos los datos de la Api una vez se inicia el servidor.
     * Es una forma más óptima que hacer que cada hilo de forma independiente acceda a la API.
     */
    private static void loadData(){
        try {

            Gson gson = new Gson();

            //Obtener libros
            URL booksUrl = new URI("https://potterapi-fedeperin.vercel.app/es/books").toURL();
            HttpURLConnection bookConection = (HttpURLConnection) booksUrl.openConnection();
            BufferedReader readerBooks = new BufferedReader(new InputStreamReader(bookConection.getInputStream()));
            books = gson.fromJson(readerBooks, Book[].class);

            //Obtener personajes
            URL characterUrl = new URI("https://potterapi-fedeperin.vercel.app/es/characters").toURL();
            HttpURLConnection characterConection = (HttpURLConnection) characterUrl.openConnection();
            BufferedReader readerCharacters = new BufferedReader(new InputStreamReader(characterConection.getInputStream()));
            strings = gson.fromJson(readerCharacters, Character[].class);

            //Obtener Casas
            URL houseUrl = new URI("https://potterapi-fedeperin.vercel.app/es/houses").toURL();
            HttpURLConnection houseConection = (HttpURLConnection) houseUrl.openConnection();
            BufferedReader readerHouses = new BufferedReader(new InputStreamReader(houseConection.getInputStream()));
            houses = gson.fromJson(readerHouses, House[].class);

            //Obtener hechizos
            URL spellUrl = new URI("https://potterapi-fedeperin.vercel.app/es/spells").toURL();
            HttpURLConnection spellConection = (HttpURLConnection) spellUrl.openConnection();
            BufferedReader readerspells = new BufferedReader(new InputStreamReader(spellConection.getInputStream()));
            spells = gson.fromJson(readerspells, Spell[].class);


        } catch (URISyntaxException | IOException e) {
            System.out.println("Error en la carga de datos: "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
