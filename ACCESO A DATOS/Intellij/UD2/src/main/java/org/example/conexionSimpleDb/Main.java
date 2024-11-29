package org.example.conexionSimpleDb;

import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        //Conexion SQlite
        Connection con= DriverManager.getConnection("jdbc:sqlite:C:\\Users\\a24marcoscv\\Documents\\2_DAM\\ACCESO A DATOS\\UD2\\db\\zoo.db");
        //Conexion h2
        //Connection con = DriverManager.getConnection("jdbc:h2:C:\\Users\\a24marcoscv\\Documents\\2_DAM\\ACCESO A DATOS\\UD2\\db\\h2\\zoo");
        System.out.println("Conexion establecida");

        Statement st= con.createStatement();

        ResultSet rs= st.executeQuery("Select * From Especie");

        while (rs.next()){
            System.out.println("Especie: "+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
        }
    }
}