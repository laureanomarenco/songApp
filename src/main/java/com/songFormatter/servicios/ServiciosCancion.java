package com.songFormatter.servicios;

import com.songFormatter.entidades.Cancion;
import com.songFormatter.entidades.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz de servicios CRUD de Cancion.
 */
public interface ServiciosCancion {
    public ArrayList<Cancion> listarServicio();
    public Cancion porIdServicio(Integer id);
    public void crearServicio(Cancion cancion) throws SQLException;
    public void actualizarServicio(Integer id, Cancion cancion) throws SQLException;
    public void eliminarServicio(Integer id);
}
