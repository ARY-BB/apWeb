package mx.edu.utez.proyecto1c.service.usuario;


import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1c.EXCEPTION.customExceptions.BadRequestException;
import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestCreaUsuarioDTO;
import mx.edu.utez.proyecto1c.model.persona.Persona;
import mx.edu.utez.proyecto1c.model.usuario.Roles;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.repositori.persona.PersonaRepository;
import mx.edu.utez.proyecto1c.repositori.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    ///instancia del repo la interfas y constructor
    /// inyeccion de dependencias
    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    ///metodo q consulte todos los usuarios
    ///regresa una lista
    /// y trae a todos esos usuarios por el punto .findall
    /// Servicios
    public List<Usuario> getAllUsers(){
        usuarioRepository.findAll();
        return usuarioRepository.findAll();
    }
    ///para q el sefgicio sea una transaccion completa de bd
   @Transactional
    public Usuario createUser(RequestCreaUsuarioDTO payload){
        ///validar si el username ya existe
        if ( usuarioRepository.findByUsername(payload.getUssername())
                .isPresent()){
            throw new BadRequestException("ese usuario ya existe");
        }
        ////registrar persona
        Persona newPersona= new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());
        newPersona.setCorreo(payload.getCorreo());
        newPersona.setCurp(payload.getCurp());

        ////creamos registro de persona y obteniendo sus datos como registro existe como el id
        newPersona = personaRepository.save(newPersona);


        ///crear instancia de usuario y llenarla a base de la info de payload
        Usuario newUser=new Usuario();
        newUser.setUsername(payload.getUssername());
        newUser.setPassword(payload.getPassword());
        newUser.getDescripccion(payload.getDescripccion());
        newUser.setEnable(true);
        newUser.setRol(
                Roles.valueOf(payload.getRol())
        );
        ////relacionar la persona registrada con el nuevo usuario
        newUser.setPersona(newPersona);

        return usuarioRepository.save(newUser);
    }
}
