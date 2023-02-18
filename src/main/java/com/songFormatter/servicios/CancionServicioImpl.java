package com.songFormatter.servicios;


import com.songFormatter.DAO.CancionDAO;
import com.songFormatter.entidades.Cancion;


import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementación de los servicios de Usuario.
 */
public class CancionServicioImpl implements ServiciosCancion{

    @Override
    public ArrayList<Cancion> listarServicio() {
        ArrayList<Cancion> canciones = new CancionDAO().listar();
        return canciones;
    }

    @Override
    public Cancion porIdServicio(Integer id) {
        Cancion cancion = new CancionDAO().porId(id);
        return cancion;
    }

    @Override
    public void crearServicio(Cancion cancion) throws SQLException {
        new CancionDAO().crear(cancion);
    }

    @Override
    public void actualizarServicio(Integer id, Cancion cancion) throws SQLException {
        new CancionDAO().actualizar(id, cancion);
    }

    @Override
    public void eliminarServicio(Integer id) {
        new CancionDAO().eliminar(id);
    }
}
