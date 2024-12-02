package org.example.Gestion_Biblioteca.model;

import java.util.List;

public interface DAO<T>{

    //Métodos CRUD básicos
    T get(int id); //Obtener un objeto a través de id
    List<T>getAll(); //Obtener todos los objetos de tipo T
    void save (T t); //insertar objeto
    void update(T t); //Actualizar objeto
    void delete (T t); //Borrar objeto

    //Métodos CRUD Aanzados
    public void deleteById (long id); //Borrar objeto por id
    public void updateImage( T t, String f); //Actualizar imagen a través de objeto y string
    public void updateImageById(long id, String f); ////Actualizar imagen a través de objeto y string
    void deleteAll(); //Borrar todos los objetos


}
