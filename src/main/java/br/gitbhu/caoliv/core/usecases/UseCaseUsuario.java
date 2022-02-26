package br.gitbhu.caoliv.core.usecases;

import br.gitbhu.caoliv.adapters.outbound.repository.UsuarioRepositoryAdapter;
import br.gitbhu.caoliv.model.Usuario;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class UseCaseUsuario {

    private UsuarioRepositoryAdapter usuarioRepository;

    public UseCaseUsuario(UsuarioRepositoryAdapter usuarioRepositoryAdapter){
        usuarioRepository = usuarioRepositoryAdapter;
    }

    public Response createUsuario(Usuario usuario) {
        usuarioRepository.createUsuario(usuario);
        return Response.ok(usuario).build();
    }

    public Response listAllUsers() {
        return  usuarioRepository.listAllUsers();
    }

    public Response deletaUser(Long id) {
        try {
           Usuario usuario = usuarioRepository.findUsuario(id);
            if(usuario != null) {
                usuarioRepository.deletaUser(usuario.getId());
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Response updateUsers(Long id, Usuario usuario) {
        try{
            Usuario user = usuarioRepository.findUsuario(id);

            if(user != null) {
                user.setName(usuario.getName());
                user.setAge(usuario.getAge());
                usuarioRepository.updateUsers(user);
                return Response.ok().build();
            }
            return Response.status(Response.Status.NOT_FOUND).build();
        }catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
