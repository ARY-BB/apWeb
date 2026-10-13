package mx.edu.utez.proyecto1c.service.usuario;


import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestCreaUsuarioDTO;
import mx.edu.utez.proyecto1c.model.usuario.Roles;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.repositori.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    ///instancia del repo la interfas y constructor
    /// inyeccion de dependencias
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    ///metodo q consulte todos los usuarios
    ///regresa una lista
    /// y trae a todos esos usuarios por el punto .findall
    /// Servicios
    public List<Usuario> getAllUsers(){
        usuarioRepository.findAll();
        return usuarioRepository.findAll();
    }

    public Usuario createUser(RequestCreaUsuarioDTO payload){
        ///validar si el username ya existe


        ///crear instancia de usuario y llenarla a base de la info de payload
        Usuario newUser=new Usuario();
        newUser.setUsername(payload.getUssername());
        newUser.setPassword(payload.getPassword());
        newUser.getDescripccion(payload.getDescripccion());
        newUser.setEnable(true);
        newUser.setRol(
                Roles.valueOf(payload.getRol())
        );
        return usuarioRepository.save(newUser);
    }
}
