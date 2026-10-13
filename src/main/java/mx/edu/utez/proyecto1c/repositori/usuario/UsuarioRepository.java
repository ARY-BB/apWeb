package mx.edu.utez.proyecto1c.repositori.usuario;

import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

///interfas de realizar las acciones basicas de un crud
///para q reconoscaa el repositorio
@Repository
//extender y q entidad pertenece
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {
////cunsulta para trear usuario por medio del username
    //optional para objetos que pueden existir o no
///es una colsulta
/// select * from usuarios where username = ?
    Optional<Usuario> findByUsername (String username);
}
