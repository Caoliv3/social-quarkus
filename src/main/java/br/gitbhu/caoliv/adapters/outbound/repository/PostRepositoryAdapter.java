package br.gitbhu.caoliv.adapters.outbound.repository;

import br.gitbhu.caoliv.model.PostEntrada;
import br.gitbhu.caoliv.model.PostResponse;
import br.gitbhu.caoliv.model.Posts;
import br.gitbhu.caoliv.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PostRepositoryAdapter {
    
    @Inject
    private PostRepository postRepository;
    
    public PostRepositoryAdapter(PostRepository repository){
        this.postRepository=repository;
    }

    public void savePost(PostEntrada entrada, Usuario usuario) {
        Posts post = new Posts();
        post.setMensagem(entrada.getMensagem());
        post.setUsuario(usuario);
        post.setDateTime(LocalDateTime.now());

        postRepository.save(post);
    }

    public Response listPosts(Usuario usuario) {
        List<Posts> list = postRepository.findUserId(usuario);
        var postResponselist = list.stream()
//                .map(post -> PostResponse.fromEntity(post))
                .map(PostResponse::fromEntity)
                .collect(Collectors.toList());

        return Response.ok(postResponselist).build();

    }
}
