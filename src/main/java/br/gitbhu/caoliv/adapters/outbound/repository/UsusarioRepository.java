package br.gitbhu.caoliv.adapters.outbound.repository;

import br.gitbhu.caoliv.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsusarioRepository extends JpaRepository<Usuario, Long> {

//    @Query(value="update Usuario u set u.name =:name where u.age =:age", nativeQuery = true)
//    void updateUsers(@Param("name")String name, @Param("age")Integer age);
}
