package br.gitbhu.caoliv.adapters.inbound;

import br.gitbhu.caoliv.model.Usuario;
import br.gitbhu.caoliv.ports.SocialRequestPort;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    private SocialRequestPort socialRequestPort;

    public UsuarioController(SocialRequestPort socialRequestPort){
        this.socialRequestPort = socialRequestPort;
    }

    @POST
    public Response createUser(@Valid Usuario usuario){
        return this.socialRequestPort.createUsuario(usuario);
    }

    @GET
    public Response listAllUsers(){
        return this.socialRequestPort.listAllUsers();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id){
        return this.socialRequestPort.deletaUser(id);
    }

    @PUT
    @Path("{id}")
    public Response updateUsers(@PathParam("id") Long id, Usuario usuario){
        return this.socialRequestPort.updateUsers(id, usuario);
    }
}
