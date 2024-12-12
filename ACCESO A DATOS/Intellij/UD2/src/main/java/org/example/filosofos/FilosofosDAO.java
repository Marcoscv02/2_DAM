package org.example.filosofos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilosofosDAO {
    FilosofosSingleCon fsc= FilosofosSingleCon.getInstance();

    Connection con= fsc.getConexion();

    public void saveFilosofo(Filosofo filosofo){
        String sentencia= "INSERT INTO Filosofo (nome, apelidos, idade, dataNacemento, foto) VALUES (?,?,?,?,?)";

        try (var ps = con.prepareStatement(sentencia);){

            ps.setString(1, filosofo.getNombre());
            ps.setString(2, filosofo.getApellido());
            ps.setInt(3, filosofo.getEdad());
            ps.setDate(4, Date.valueOf(filosofo.getFechaNac()));
            ps.setBytes(5,filosofo.getFoto());

            int rows = ps.executeUpdate();

            if (rows>0) System.out.println("operacionRealizada con éxito");
            else System.out.println("No se han podido insertar los datos");

        } catch (SQLException e) {
            System.out.println("Error SQL en método saveFilosofo");
            throw new RuntimeException(e);
        }
    }

    public Filosofo getFilosofobyname(String name){
        String statement= "SELECT * FROM Filosofo WHERE nome = ?";

        Filosofo filosofo= new Filosofo();
        try(var ps= con.prepareStatement(statement)){
            ps.setString(1,name);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                filosofo.setId(rs.getInt(1));
                filosofo.setNombre(rs.getString(2));
                filosofo.setApellido(rs.getString(3));
                filosofo.setEdad(rs.getInt(4));
                filosofo.setFechaNac(rs.getDate(5).toLocalDate());
                filosofo.setFoto(rs.getBytes(6));

                System.out.println("Filosofo obtenido con éxito");
            }else System.out.println("Filósofo no encontrado");

        } catch (SQLException e) {
            System.out.println("error de SQL");
            throw new RuntimeException(e);
        }

        return filosofo;
    }

    public List<Filosofo> getAll(){
        List<Filosofo>filosofos= new ArrayList<>();

        String statement= "SELECT * FROM Filosofo";

        try(var ps = con.prepareStatement(statement)){

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Filosofo filosofo = new Filosofo();

                filosofo.setNombre(rs.getString(2));
                filosofo.setApellido(rs.getString(3));
                filosofo.setEdad(rs.getInt(4));
                filosofo.setFechaNac(rs.getDate(5).toLocalDate());
                filosofo.setFoto(rs.getBytes(6));

                filosofos.add(filosofo);
            }

            System.out.println("operación realizada con éxito");

            return  filosofos;

        } catch (SQLException e) {
            System.out.println("error de SQL");
            throw new RuntimeException(e);
        }
    }

    public void updateFilosofo (Filosofo filosofo ){
        String statement = "UPDATE Filosofo SET idFilosofo=?, nome=?, apelidos=?, idade=?, dataNacemento=?, foto=? WHERE idFilosofo=? ";

        try(var st= con.prepareStatement(statement)){
            st.setInt(1,filosofo.getId());
            st.setString(2, filosofo.getNombre());
            st.setString(3, filosofo.getApellido());
            st.setInt(4, filosofo.getEdad());
            st.setDate(5, Date.valueOf(filosofo.getFechaNac()));
            st.setBytes(6,filosofo.getFoto());
            st.setInt(7, filosofo.getId());

            int rows = st.executeUpdate();

            if (rows>0) System.out.println("Elemento actualizado con éxito");
            else System.out.println("No se ha podido actualizar el elemento");

        } catch (SQLException e) {
            System.out.println("error de SQL");
            throw new RuntimeException(e);
        }
    }

    public void deleteFilosofo (int id){
        String statement = "DELETE FROM Filosofo WHERE idFilosofo=?";

        try (var ps= con.prepareStatement(statement)){
            ps.setInt(1,id);

            int rows= ps.executeUpdate();

            if (rows>0) System.out.println("Elemento eliminado con exito");
            else System.out.println("No se ha podido eliminar el elemento");

        } catch (SQLException e) {
            System.out.println("error de SQL");
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        LocalDate fechaNacimiento = LocalDate.of(469, 1, 1); // Año 469 a.C.
        Filosofo f= new Filosofo(13,"Raphaela ", "Carrá", 77, fechaNacimiento);
        List<Filosofo>filosofos;


        FilosofosDAO ff= new FilosofosDAO();

//        ff.saveFilosofo(f); //Prueba guardar
//        Filosofo f2= ff.getFilosofobyname("Sócrates"); //prueba obtener por nombre
//        filosofos=ff.getAll();
//
//        System.out.println("Lista de filósofos:");
//
//        if(filosofos.isEmpty()){
//            System.out.println("lista vacia");
//        }
//
//        for (Filosofo fff: filosofos){
//            System.out.println(fff.toString());
//        }

//        ff.updateFilosofo(f);
//        ff.deleteFilosofo(13);



    }
}
