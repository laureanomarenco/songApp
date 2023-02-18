package com.songFormatter.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz DAO con los metodos del CRUD.
 */
public interface DAO<T> {
    public ArrayList<T> listar();
    public T porId(Integer id);
    public void crear(T t) throws SQLException;
    public void actualizar(T t) throws SQLException;
    public void eliminar(Integer id);
}
