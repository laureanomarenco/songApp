package com.songFormatter.DAO.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Conexion a base de datos songFormatter
  getInstance()    <- Instancia una conexión
  closeInstance()  <- Cierra una instancia
 */

public class ConexionDB {
    private static String urlConexion = "jdbc:mysql://localhost:3306/song_formatter";
    private static String usuariodb = "root";
    private static String password = "";

    private static Connection connection;


    /**
     * Instanciar conexion
     */
    public static Connection getInstance() throws SQLException {
        if(connection == null){
            connection = DriverManager.getConnection(urlConexion, usuariodb, password);
        }
        return connection;
    }

    /**
     * Cerrar conexion
     */
    public static Connection closeInstance() throws SQLException {
        if(connection != null) {
            connection.close();
        }
        return null;
    }
}
