package mx.edu.utez.proyecto1c.controller.usuario;


import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestCreaUsuarioDTO;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin({"*"})
public class UsuarioController {

    ///inyeccion de dependencias
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    ///exposicion de servicios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity
                .status(200)
                .body(
                        this.usuarioService.getAllUsers()
                );
    }
    ///creacion de nuevo recurso
    @PostMapping
    public ResponseEntity<Usuario> createUser (@RequestBody @Valid RequestCreaUsuarioDTO payload){
        return ResponseEntity.status(201).body(
                this.usuarioService.createUser(payload)
        );
    }
}
///en postman se puso http://localhost:33666/usuario y metodo GET el servicio contesto sin rpoblemas