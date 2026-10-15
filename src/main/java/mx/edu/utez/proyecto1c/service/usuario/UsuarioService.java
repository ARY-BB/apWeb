package mx.edu.utez.proyecto1c.service.usuario;

import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1c.EXCEPTION.customExceptions.BadRequestException;
import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestCreaUsuarioDTO;
import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestUpdateUsuarioDTO;
import mx.edu.utez.proyecto1c.model.persona.Persona;
import mx.edu.utez.proyecto1c.model.usuario.Roles;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.repositori.persona.PersonaRepository;
import mx.edu.utez.proyecto1c.repositori.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, PersonaRepository personaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.personaRepository = personaRepository;
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario createUser(RequestCreaUsuarioDTO payload){
        if (usuarioRepository.findByUsername(payload.getUssername()).isPresent()){
            throw new BadRequestException("Ese usuario ya existe");
        }

        Persona newPersona = new Persona();
        newPersona.setNombres(payload.getNombres());
        newPersona.setPrimerApellido(payload.getPrimerApellido());
        newPersona.setSegundoApellido(payload.getSegundoApellido());
        newPersona.setFechaNacimiento(payload.getFechaNacimiento());
        newPersona.setCorreo(payload.getCorreo());
        newPersona.setCurp(payload.getCurp());

        newPersona = personaRepository.save(newPersona);

        Usuario newUser = new Usuario();
        newUser.setUsername(payload.getUssername());
        newUser.setPassword(payload.getPassword());
        newUser.setDescripccion(payload.getDescripccion());
        newUser.setEnable(true);
        newUser.setRol(Roles.valueOf(payload.getRol()));
        newUser.setPersona(newPersona);

        return usuarioRepository.save(newUser);
    }

    // 1. Activar / Desactivar usuario por ID
    @Transactional
    public Usuario toggleEstadoUsuario(long id, boolean estado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con ID " + id + " no existe"));

        usuario.setEnable(estado);
        return usuarioRepository.save(usuario);
    }

    // 2. Consultar usuario por ID
    public Usuario getUsuarioById(long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con ID " + id + " no existe"));
    }

    // 3. Actualizar username y descripcion (conserva Persona y demás datos)
    @Transactional
    public Usuario updateUsuario(long id, RequestUpdateUsuarioDTO payload) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("El usuario con ID " + id + " no existe"));

        if (payload.getUsername() != null && !payload.getUsername().isBlank()) {
            if (!payload.getUsername().equals(usuario.getUsername()) &&
                    usuarioRepository.findByUsername(payload.getUsername()).isPresent()) {
                throw new BadRequestException("El username '" + payload.getUsername() + "' ya está registrado");
            }
            usuario.setUsername(payload.getUsername());
        }

        if (payload.getDescripccion() != null) {
            usuario.setDescripccion(payload.getDescripccion());
        }

        return usuarioRepository.save(usuario);
    }
}