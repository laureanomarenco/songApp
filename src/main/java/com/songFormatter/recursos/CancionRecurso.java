package com.songFormatter.recursos;

import com.songFormatter.entidades.Cancion;
import com.songFormatter.entidades.Usuario;
import com.songFormatter.servicios.CancionServicioImpl;
import com.songFormatter.servicios.UsuarioServicioImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Collection;

@Path("/cancion")
public class CancionRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCancion() throws SQLException {
        Collection<Cancion> canciones = new CancionServicioImpl().listarServicio();
        return Response.ok().status(Response.Status.OK).entity(canciones).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id){
        Cancion cancion = new CancionServicioImpl().porIdServicio(id);
        return Response.ok().status(Response.Status.OK).entity(cancion).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCancion(Cancion cancion) throws SQLException {
        new CancionServicioImpl().crearServicio(cancion);
        return Response.ok().status(Response.Status.CREATED).entity("Creado").build();
    }


    @Path("/{id}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putCancion(@PathParam("id") Integer id, Cancion cancion) throws SQLException {
        new CancionServicioImpl().actualizarServicio(id, cancion);
        return Response.ok().status(Response.Status.ACCEPTED).entity("Actualizado").build();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(@PathParam("id") Integer id) throws SQLException {
        new CancionServicioImpl().eliminarServicio(id);
        return Response.ok().status(Response.Status.ACCEPTED).entity("Eliminado").build();
    }
}
