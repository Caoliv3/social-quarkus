package br.gitbhu.caoliv.service;

import br.gitbhu.caoliv.model.PostEntrada;
import br.gitbhu.caoliv.core.usecases.UseCasePost;
import br.gitbhu.caoliv.core.usecases.UseCaseUsuario;
import br.gitbhu.caoliv.model.Usuario;
import br.gitbhu.caoliv.ports.SocialRequestPort;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

@Service
public class SocialService implements SocialRequestPort {

    private UseCaseUsuario useCaseUsuario;
    private UseCasePost useCasePost;

    public SocialService(UseCaseUsuario usuario, UseCasePost post){
        this.useCaseUsuario = usuario;
        this.useCasePost= post;
    }

    @Override
    public Response createUsuario(Usuario usuario){
        return this.useCaseUsuario.createUsuario(usuario);
    }

    @Override
    public Response listAllUsers() {
        return this.useCaseUsuario.listAllUsers();
    }

    @Override
    public Response deletaUser(Long id) {
        return this.useCaseUsuario.deletaUser(id);
    }

    @Override
    public Response updateUsers(Long id, Usuario usuario) {
        return this.useCaseUsuario.updateUsers(id,usuario);
    }

    @Override
    public Response savePost(Long id , PostEntrada entrada) {
        return useCasePost.savePost(id, entrada);
    }

    @Override
    public Response listPosts(Long id) {
        return useCasePost.listPosts(id);
    }
}
