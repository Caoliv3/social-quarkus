package br.gitbhu.caoliv.core.usecases;

import br.gitbhu.caoliv.adapters.outbound.repository.PostRepositoryAdapter;
import br.gitbhu.caoliv.adapters.outbound.repository.UsuarioRepositoryAdapter;
import br.gitbhu.caoliv.model.PostEntrada;
import br.gitbhu.caoliv.model.Usuario;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class UseCasePost {

    private UsuarioRepositoryAdapter usuarioRepository;
    private PostRepositoryAdapter postRepository;

    public UseCasePost(UsuarioRepositoryAdapter usuarioRepository, PostRepositoryAdapter postRepository) {
        this.usuarioRepository = usuarioRepository;
        this.postRepository = postRepository;
    }

    public Response savePost(Long id, PostEntrada entrada) {
        Usuario usuario = usuarioRepository.findUsuario(id);
        if(usuario != null){
            postRepository.savePost(entrada, usuario);
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response listPosts(Long id) {
        Usuario usuario = usuarioRepository.findUsuario(id);
        if(usuario != null){
            return postRepository.listPosts(usuario);
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
