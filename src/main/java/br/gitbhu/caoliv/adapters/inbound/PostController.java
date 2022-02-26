package br.gitbhu.caoliv.adapters.inbound;

import br.gitbhu.caoliv.model.PostEntrada;
import br.gitbhu.caoliv.ports.SocialRequestPort;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users/{userid}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostController {

    private SocialRequestPort socialService;

    public PostController(SocialRequestPort socialService) {
        this.socialService = socialService;
    }

    @POST
    public Response savePost(@PathParam("userid") Long id, PostEntrada entrada){
        return socialService.savePost(id,entrada);
    }

    @GET
    public Response listPosts(@PathParam("userid") Long id){
        return socialService.listPosts(id);
    }


}
