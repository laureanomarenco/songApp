package com.songFormatter.servicios;

import com.songFormatter.DAO.UsuarioDAO;
import com.songFormatter.entidades.Usuario;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.ArrayList;

@Named
public class UsuarioServicioImpl implements ServiciosUsuario {
    @Override
    public ArrayList<Usuario> listarServicio() {
        ArrayList<Usuario> usuarios = new UsuarioDAO().listar();
        return usuarios;
    }

    @Override
    public Usuario porIdServicio(Integer id) {
        Usuario usuario = new UsuarioDAO().porId(id);
        return usuario;
    }

    @Override
    public void crearServicio(Usuario usuario) throws SQLException {
        new UsuarioDAO().crear(usuario);
    }

    @Override
    public void actualizarServicio(Usuario usuario) throws SQLException {
        new UsuarioDAO().actualizar(usuario);
    }

    @Override
    public void eliminarServicio(Integer id) {
        new UsuarioDAO().eliminar(id);
    }
}
