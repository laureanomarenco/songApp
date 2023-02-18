package com.songFormatter.interfaces;

import com.songFormatter.entidades.Cancion;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz DAO con los métodos del CRUD.
 */
public interface DAO<T> {
    public ArrayList<T> listar();
    public T porId(Integer id);
    public void crear(T t) throws SQLException;
    public void actualizar(Integer id, T t) throws SQLException;
    public void eliminar(Integer id);
}
