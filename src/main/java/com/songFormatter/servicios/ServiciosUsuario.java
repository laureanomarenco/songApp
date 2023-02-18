package com.songFormatter.servicios;

import com.songFormatter.entidades.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ServiciosUsuario {
    public ArrayList<Usuario> listarServicio();
    public Usuario porIdServicio(Integer id);
    public void crearServicio(Usuario usuario) throws SQLException;
    public void actualizarServicio(Usuario usuario) throws SQLException;
    public void eliminarServicio(Integer id);
}
