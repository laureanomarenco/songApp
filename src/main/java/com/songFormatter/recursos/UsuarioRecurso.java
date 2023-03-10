package com.songFormatter.recursos;

import com.songFormatter.entidades.Usuario;
import com.songFormatter.servicios.UsuarioServicioImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.Collection;


/**
 * Endpoints CRUD de usuarios. /api/usuarios/{id}
 */
@Path("/usuarios")
public class UsuarioRecurso {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario() throws SQLException {
        Collection<Usuario> users = new UsuarioServicioImpl().listarServicio();
        return Response.ok().status(Response.Status.OK).entity(users).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Integer id){
        Usuario usuario = new UsuarioServicioImpl().porIdServicio(id);
        return Response.ok().status(Response.Status.OK).entity(usuario).build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postUsuario(Usuario usuario) throws SQLException {
        new UsuarioServicioImpl().crearServicio(usuario);
        return Response.ok().status(Response.Status.CREATED).entity("Creado").build();
    }


    @Path("/{id}")
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putUsuario(@PathParam("id") Integer id, Usuario usuario) throws SQLException {
        new UsuarioServicioImpl().actualizarServicio(id, usuario);
        return Response.ok().status(Response.Status.ACCEPTED).entity("Actualizado").build();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUsuario(@PathParam("id") Integer id) throws SQLException {
        new UsuarioServicioImpl().eliminarServicio(id);
        return Response.ok().status(Response.Status.ACCEPTED).entity("Eliminado").build();
    }
}
