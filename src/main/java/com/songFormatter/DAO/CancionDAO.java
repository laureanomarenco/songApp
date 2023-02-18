package com.songFormatter.DAO;

import com.songFormatter.DAO.utils.ConexionDB;
import com.songFormatter.entidades.Cancion;
import com.songFormatter.entidades.Usuario;
import com.songFormatter.interfaces.DAO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Interacción DB tabla de Cancion, métodos para obtener lista de usuarios, usuario por su id, y CRUD.
 */
public class CancionDAO implements DAO<Cancion> {
    private Integer idGenerado;
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    private Connection closeConnection() throws SQLException{
        return ConexionDB.closeInstance();
    }

    @Override
    public ArrayList listar() {
        ArrayList<Cancion> canciones = new ArrayList<>();
        Cancion cancion = null;

        try {
            String allSQLstring = "SELECT idUsuario, idAutor, titulo, detalles, anio, letra FROM Cancion";
            PreparedStatement selectAll = this.getConnection().prepareStatement(allSQLstring);

            ResultSet resultado = selectAll.executeQuery();
            while (resultado.next()){
                cancion = cancionRs(resultado);
                canciones.add(cancion);
            }

        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        }

        return canciones;
    }
    @Override
    public void crear(Cancion cancion) throws SQLException {
        try {
            String sqlInsert = "INSERT INTO Cancion (idUsuario, idAutor, titulo, detalles, anio, letra) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement comandoSQL = this.getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setInt(1, cancion.getIdUsuario());
            comandoSQL.setString(2, cancion.getTitulo());
            comandoSQL.setString(3, cancion.getDetalles());
            comandoSQL.setInt(4, cancion.getAnio());
            comandoSQL.setString(5, cancion.getLetra());

            comandoSQL.execute();

            ResultSet consultaID = comandoSQL.getGeneratedKeys();

            if(consultaID.next()){
                idGenerado = consultaID.getInt(1);
                System.out.println("ID Generado " + idGenerado);
            }

        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Integer id, Cancion cancion) throws SQLException {
        try {
            String updateSQLstring = "UPDATE Cancion SET titulo = ?, detalles = ?, anio = ?, letra = ? WHERE idCancion =?";

            PreparedStatement updateSQL = this.getConnection().prepareStatement(updateSQLstring);

            updateSQL.setString(1, cancion.getTitulo());
            updateSQL.setString(2, cancion.getDetalles());
            updateSQL.setInt(3, cancion.getAnio());
            updateSQL.setString(4, cancion.getLetra());
            updateSQL.setInt(5, cancion.getIdCancion());
            updateSQL.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error generico");
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void eliminar(Integer id) {
        try {
            String deleteSQLstring = "DELETE FROM Cancion WHERE idCancion = ?";

            PreparedStatement deteleSQL = this.getConnection().prepareStatement(deleteSQLstring);

            deteleSQL.setInt(1, id);
            int rowsMod = deteleSQL.executeUpdate(); //retorna la cantidad de registros eliminados.
            System.out.println("Rows modificadas: " + rowsMod);
        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Cancion porId(Integer id){
        Cancion cancion = null;

        try {
            String consultaSQLstring = "SELECT idCancion, idAutor, idUsuario, titulo, detalles, anio, letra FROM Cancion WHERE idCancion = ?";

            PreparedStatement consultaSQL = this.getConnection().prepareStatement(consultaSQLstring);

            consultaSQL.setInt(1, id);

            ResultSet resultado = consultaSQL.executeQuery();


            if(resultado.next()){
                cancion = new Cancion();
                cancion.setIdCancion(resultado.getInt("idCancion"));
                cancion.setIdAutor(resultado.getInt("idAutor"));
                cancion.setTitulo(resultado.getString("titulo"));
                cancion.setAnio(resultado.getInt("anio"));
            }



        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        } finally {
            try {
                closeConnection();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return cancion;
    }

    public Cancion cancionRs(ResultSet rs) throws SQLException {
        Cancion cancion = null;
        Integer idUsuario = rs.getInt(1);
        Integer idAutor = rs.getInt(2);
        String titulo = rs.getString(3);
        String detalles = rs.getString(4);
        Integer anio = rs.getInt(5);
        String letra = rs.getString(6);

        cancion = new Cancion(idUsuario, idAutor, titulo, detalles, anio, letra);

        return cancion;
    }

}
