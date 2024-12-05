package org.example.filosofos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FilosofosViewDao {

    /**
     * URL de conexión a la base de datos H2.
     */
    public static final String URL = "jdbc:h2:C:\\Users\\a24marcoscv\\Documents\\2_DAM\\ACCESO A DATOS\\DB\\filosofos\\filosofosv2.3"
            + ";IFEXISTS=TRUE;DATABASE_TO_UPPER=FALSE;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    /**
     * Metodo para establecer conexión con base de datos
     */
    public static Connection getConn(){
        try {
            Connection conn= DriverManager.getConnection(URL);
            System.out.println("Conexion realizada");
            return conn;
        } catch (SQLException e) {
            System.out.println("Error al cargar la base de datos");
            throw new RuntimeException(e);
        }
    }

    public void createGUI(){
        Connection conn= getConn();

        JFrame ventana= new JFrame("Gestion filósofos");
        ventana.setSize(600, 500);


    }

    public static void main(String[] args) {
        getConn();
    }

}
