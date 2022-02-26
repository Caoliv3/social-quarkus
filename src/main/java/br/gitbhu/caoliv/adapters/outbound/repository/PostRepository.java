package br.gitbhu.caoliv.adapters.outbound.repository;

import br.gitbhu.caoliv.model.Posts;
import br.gitbhu.caoliv.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface PostRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p where p.usuario = :usuario " +
           " order by p.dateTime desc")
    List<Posts> findUserId(@Param("usuario") Usuario usuario);
}
