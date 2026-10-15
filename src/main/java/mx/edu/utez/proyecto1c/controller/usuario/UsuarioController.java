package mx.edu.utez.proyecto1c.controller.usuario;

import jakarta.validation.Valid;
import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestCreaUsuarioDTO;
import mx.edu.utez.proyecto1c.controller.usuario.dto.RequestUpdateUsuarioDTO;
import mx.edu.utez.proyecto1c.model.usuario.Usuario;
import mx.edu.utez.proyecto1c.service.usuario.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@CrossOrigin({"*"})
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<Usuario> createUser (@RequestBody @Valid RequestCreaUsuarioDTO payload){
        return ResponseEntity
                .status(201)
                .body(this.usuarioService.createUser(payload));
    }

    // 1. Activar / Desactivar usuario
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Usuario> toggleEstadoUsuario(
            @PathVariable long id,
            @RequestParam boolean estado) {
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.toggleEstadoUsuario(id, estado));
    }

    // 2. Consultar información por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable long id) {
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.getUsuarioById(id));
    }

    // 3. Actualizar username y descripcion
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(
            @PathVariable long id,
            @RequestBody @Valid RequestUpdateUsuarioDTO payload) {
        return ResponseEntity
                .status(200)
                .body(this.usuarioService.updateUsuario(id, payload));
    }
}