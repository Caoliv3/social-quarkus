package br.gitbhu.caoliv.adapters.outbound.repository;

import br.gitbhu.caoliv.model.Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioRepositoryAdapter {

    @Inject
    UsusarioRepository usuarioRepository;

    public Response createUsuario(Usuario usuario) {
        Usuario user = new Usuario();
        user.setName(usuario.getName());
        user.setAge(usuario.getAge());
        usuarioRepository.save(user);
        return Response.ok(usuario).build();
    }

    public Response listAllUsers() {
        List<Usuario> query = usuarioRepository.findAll();
        return Response.ok(query).build();
    }

    public Response deletaUser(Long id) {
        try {
            usuarioRepository.deleteById(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Response updateUsers(Usuario usuario) {
        try{
            usuarioRepository.save(usuario);
            return Response.ok().build();
        }catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public Usuario findUsuario(Long id){
            Optional<Usuario> optional = usuarioRepository.findById(id);
            if(optional.isPresent()){
                return optional.get();
            }
            return null;
    }
}
