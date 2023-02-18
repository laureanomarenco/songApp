package com.songFormatter.DAO;

import com.songFormatter.DAO.utils.ConexionDB;
import com.songFormatter.entidades.Cancion;
import com.songFormatter.entidades.Usuario;

import java.sql.*;
import java.util.ArrayList;

/**
 * Interacción DB tabla de Cancion, métodos para obtener lista de usuarios, usuario por su id, y CRUD.
 */
public class CancionDAO {
    private Integer idGenerado;
    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    private Connection closeConnection() throws SQLException{
        return ConexionDB.closeInstance();
    }
    public Integer nuevaCancion(Cancion cancion) {
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
        } finally {
            try {
                closeConnection();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        return this.idGenerado;
    }

    public void actualizarCancion(Cancion cancion){
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


    public void borrarCancion(Integer id) {
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

    public ArrayList<Usuario> recuperarUsuario(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;

        try {
            String allSQLstring = "SELECT idUsuario, nickname, img FROM Usuario";
            PreparedStatement selectAll = this.getConnection().prepareStatement(allSQLstring);

            ResultSet resultado = selectAll.executeQuery();
            while (resultado.next()){
                usuario = new Usuario();
                usuario.setNickname(resultado.getString("nickname"));
                usuario.setImg(resultado.getString("img"));
                usuario.setId(resultado.getInt("idUsuario"));
                usuarios.add(usuario);
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

        return usuarios;
    }
}
