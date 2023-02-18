package com.songFormatter.servicios;

import com.songFormatter.entidades.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaz de servicios CRUD de Usuario.
 */
public interface ServiciosUsuario {
    public ArrayList<Usuario> listarServicio();
    public Usuario porIdServicio(Integer id);
    public void crearServicio(Usuario usuario) throws SQLException;
    public void actualizarServicio(Integer id, Usuario usuario) throws SQLException;
    public void eliminarServicio(Integer id);
}
