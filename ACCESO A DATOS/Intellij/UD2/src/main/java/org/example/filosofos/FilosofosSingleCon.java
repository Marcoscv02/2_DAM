package org.example.filosofos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FilosofosSingleCon {
    private static FilosofosSingleCon instance;
    private Connection conexion;

    public static final String URL="jdbc:h2:C:\\Users\\Usuario\\Documentos\\DAM\\2_DAM\\2_DAM\\ACCESO A DATOS\\DB\\filosofos\\filosofosv2.3"
            + ";IFEXISTS=TRUE;DATABASE_TO_UPPER=FALSE;DB_CLOSE_ON_EXIT=TRUE;FILE_LOCK=NO";

    private FilosofosSingleCon() {
        try {
            conexion= DriverManager.getConnection(URL);
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Fallo en la conexion a db");
            throw new RuntimeException(e);
        }
    }

    public static FilosofosSingleCon getInstance(){
        if (instance==null){
           instance=new FilosofosSingleCon();
        }else {
            System.out.println("Ya existe una instancia de esta clase");
        }
        return instance;
    }

    public Connection getConexion(){
        return conexion;
    }


}
