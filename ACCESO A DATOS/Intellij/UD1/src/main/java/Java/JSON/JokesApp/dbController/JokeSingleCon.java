package Java.JSON.JokesApp.dbController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JokeSingleCon {

    public  static JokeSingleCon instance;

    public static final String DB_URL="jdbc:sqlite:C:\\Users\\Usuario\\Documentos\\DAM\\2_DAM\\2_DAM\\ACCESO A DATOS\\DB\\jokes\\jokeapi.sqlite3";


    public JokeSingleCon() {
        try (Connection conn = DriverManager.getConnection(DB_URL)){

            System.out.println("Conexión establecida con éxito");

        } catch (SQLException e) {
            System.out.println("Error en la conexión a la base de datos");
            throw new RuntimeException(e);
        }
    }

    public static JokeSingleCon getInstance() {


        if (instance==null){
            instance=new JokeSingleCon();
            return instance;

        }
        System.out.println("Ya existe una instancia de esta clase");
        return null;
    }
}
