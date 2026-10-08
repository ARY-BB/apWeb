package mx.edu.utez.proyecto1c.repositori.usuario;

import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

///interfas de realizar las acciones basicas de un crud
///para q reconoscaa el repositorio
@Repository
//extender y q entidad pertenece
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

}
