package br.gitbhu.caoliv.adapters.inbound;

import br.gitbhu.caoliv.ports.SocialRequestPort;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerController {

    private SocialRequestPort requestPort;

    public FollowerController(SocialRequestPort requestPort){
        this.requestPort = requestPort;
    }
}
