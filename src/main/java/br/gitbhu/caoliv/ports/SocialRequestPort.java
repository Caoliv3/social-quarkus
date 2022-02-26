package br.gitbhu.caoliv.ports;


import br.gitbhu.caoliv.model.PostEntrada;
import br.gitbhu.caoliv.model.Usuario;

import javax.ws.rs.core.Response;

public interface SocialRequestPort {

    Response createUsuario(Usuario usuario);

    Response listAllUsers();

    Response deletaUser(Long id);

    Response updateUsers(Long id, Usuario usuario);

    Response savePost(Long id, PostEntrada entrada);

    Response listPosts(Long id);
}
