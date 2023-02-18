package com.songFormatter.DAO;

import com.songFormatter.DAO.utils.ConexionDB;
import com.songFormatter.entidades.Usuario;
import com.songFormatter.interfaces.DAO;

import java.sql.*;
import java.util.ArrayList;

/**
 * Interacción DB tabla de Usuario, métodos para obtener lista de usuarios, usuario por su id, y CRUD.
 */
public class UsuarioDAO implements DAO<Usuario> {
    private Integer idGenerado;
    private Connection getConnection() throws SQLException{
        return ConexionDB.getInstance();
    }
    private Connection closeConnection() throws SQLException{
        return ConexionDB.closeInstance();
    }

    @Override
    public Usuario porId(Integer id){
        Usuario usuario = null;

        try {
            String consultaSQLstring = "SELECT idUsuario, nickname, img, password, mail FROM Usuario WHERE idUsuario = ?";

            PreparedStatement consultaSQL = this.getConnection().prepareStatement(consultaSQLstring);

            consultaSQL.setInt(1, id);

            ResultSet resultado = consultaSQL.executeQuery();

            if(resultado.next()){
                usuario = new Usuario();
                usuario.setId(resultado.getInt("idUsuario"));
                usuario.setNickname(resultado.getString("nickname"));
                usuario.setImg(resultado.getString("img"));
                usuario.setPassword(resultado.getString("password"));
                usuario.setMail(resultado.getString("mail"));
            }


        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = null;

        try {
            String allSQLstring = "SELECT idUsuario, nickname, img, password, mail FROM Usuario";
            PreparedStatement selectAll = this.getConnection().prepareStatement(allSQLstring);

            ResultSet resultado = selectAll.executeQuery();
            while (resultado.next()){
                usuario = usuarioRs(resultado);
                usuarios.add(usuario);
            }

        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        }

        return usuarios;
    }

    @Override
    public void crear(Usuario usuario) {
        try {
            String sqlInsert = "INSERT INTO Usuario (nickname, img, password, mail) VALUES (?, ?, ?, ?)";

            PreparedStatement comandoSQL = this.getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);

            comandoSQL.setString(1, usuario.getNickname());
            comandoSQL.setString(2, usuario.getImg());
            comandoSQL.setString(3, usuario.getPassword());
            comandoSQL.setString(4, usuario.getMail());
            comandoSQL.execute();

            ResultSet consultaID = comandoSQL.getGeneratedKeys();

            if(consultaID.next()){
                idGenerado = consultaID.getInt(1);
                usuario.setId(idGenerado);
                System.out.println("ID Generado " + idGenerado);
            }

            // En la clase hizo un select para mostrar todos los productos

        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            String updateSQLstring = "UPDATE Usuario SET nickname = ?, img = ?, password = ?, mail = ? WHERE idUsuario =?";

            PreparedStatement updateSQL = this.getConnection().prepareStatement(updateSQLstring);

            updateSQL.setString(1, usuario.getNickname());
            updateSQL.setString(2, usuario.getImg());
            updateSQL.setString(3, usuario.getPassword());
            updateSQL.setString(4, usuario.getMail());

            updateSQL.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error generico");
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        try {
            String deleteSQLstring = "DELETE FROM Usuario WHERE idUsuario = ?";

            PreparedStatement deteleSQL = this.getConnection().prepareStatement(deleteSQLstring);

            deteleSQL.setInt(1, id);
            int rowsMod = deteleSQL.executeUpdate(); //retorna la cantida de registros eliminados.
            System.out.println("Rows modificadas: " + rowsMod);
        } catch (SQLException e){
            System.err.println("Error en SQL");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("Error generico");
            e.printStackTrace();
        }
    }

    public Usuario usuarioRs(ResultSet rs) throws SQLException {
        Usuario usuario = null;
        Integer idUsuario = rs.getInt(1);
        String nickname = rs.getString(2);
        String img = rs.getString(3);
        String password = rs.getString(4);
        String mail = rs.getString(5);

        usuario = new Usuario(idUsuario, nickname, img, password, mail);

        return usuario;
    }
//    public Integer nuevoUsuario(Usuario usuario) {
//        try {
//            String sqlInsert = "INSERT INTO Usuario (nickname, img) VALUES (?, ?)";
//
//            PreparedStatement comandoSQL = this.getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
//
//            comandoSQL.setString(1, usuario.getNickname());
//            comandoSQL.setString(2, usuario.getImg());
//            comandoSQL.execute();
//
//            ResultSet consultaID = comandoSQL.getGeneratedKeys();
//
//            if(consultaID.next()){
//                idGenerado = consultaID.getInt(1);
//                System.out.println("ID Generado " + idGenerado);
//            }
//
//            // En la clase hizo un select para mostrar todos los productos
//
//        } catch (SQLException e){
//            System.err.println("Error en SQL");
//            e.printStackTrace();
//        } catch (Exception e){
//            System.err.println("Error generico");
//            e.printStackTrace();
//        } finally {
//            try {
//                closeConnection();
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//        return this.idGenerado;
//    }
//
//    public void actualizarUsuario(Usuario usuario){
//            try {
//                String updateSQLstring = "UPDATE Usuario SET nickname = ?, img = ? WHERE idUsuario =?";
//
//                PreparedStatement updateSQL = this.getConnection().prepareStatement(updateSQLstring);
//
//                updateSQL.setString(1, usuario.getNickname());
//                updateSQL.setString(2, usuario.getImg());
//                updateSQL.setInt(3, usuario.getId());
//                updateSQL.executeUpdate();
//
//
//            } catch (SQLException e) {
//                System.err.println("Error en SQL");
//                e.printStackTrace();
//            } catch (Exception e) {
//                System.err.println("Error generico");
//                e.printStackTrace();
//        } finally {
//            try {
//                closeConnection();
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }
//

//    public void borrarUsuario(Integer id) {
//        try {
//            String deleteSQLstring = "DELETE FROM Usuario WHERE idUsuario = ?";
//
//            PreparedStatement deteleSQL = this.getConnection().prepareStatement(deleteSQLstring);
//
//            deteleSQL.setInt(1, id);
//            int rowsMod = deteleSQL.executeUpdate(); //retorna la cantida de registros eliminados.
//            System.out.println("Rows modificadas: " + rowsMod);
//        } catch (SQLException e){
//            System.err.println("Error en SQL");
//            e.printStackTrace();
//        } catch (Exception e){
//            System.err.println("Error generico");
//            e.printStackTrace();
//        } finally {
//            try {
//                closeConnection();
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//    }


//    public ArrayList<Usuario> recuperarUsuario(){
//        ArrayList<Usuario> usuarios = new ArrayList<>();
//        Usuario usuario = null;
//
//        try {
//            String allSQLstring = "SELECT idUsuario, nickname, img FROM Usuario";
//            PreparedStatement selectAll = this.getConnection().prepareStatement(allSQLstring);
//
//            ResultSet resultado = selectAll.executeQuery();
//            while (resultado.next()){
//                usuario = new Usuario();
//                usuario.setNickname(resultado.getString("nickname"));
//                usuario.setImg(resultado.getString("img"));
//                usuario.setId(resultado.getInt("idUsuario"));
//                usuarios.add(usuario);
//            }
//
//        } catch (SQLException e){
//            System.err.println("Error en SQL");
//            e.printStackTrace();
//        } catch (Exception e){
//            System.err.println("Error generico");
//            e.printStackTrace();
//        } finally {
//            try {
//                closeConnection();
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//
//        return usuarios;
//    }
}
