package com.songFormatter;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * songFormatter.
 * Esta api está pensada para disponer de una estructura para realizar operaciones CRUD destinadas a manipular las entidades Usuario, Cancion, Autor y Cancionero.
 *
 * Se conecta a una database SQL interactuando con ella a través de las clases en la carpeta DAO, los metodos de las clases específicas implementan los métodos en el interfaz DAO.
 *
 * Estos métodos de DAO son ejecutados en el servicio correspondiente a cada tabla.
 *
 * Los servicios son ejecutados por las rutas (recursos) destinadas a ser consumidas en un frontend.
 *
 * Las entidades sirven de modelo para las distintas instancias donde el modelo de la tabla es requerido.
 */
@ApplicationPath("/api")
public class songApp extends Application {

}