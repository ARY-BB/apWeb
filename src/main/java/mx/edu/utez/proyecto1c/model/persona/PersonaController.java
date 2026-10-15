package mx.edu.utez.proyecto1c.model.persona;

import jakarta.validation.Valid;

import mx.edu.utez.proyecto1c.model.persona.Persona;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
@CrossOrigin({"*"})
public class PersonaController {

    private final PersonaCervice personaService;

    public PersonaController(PersonaCervice personaService) {
        this.personaService = personaService;
    }

    // 4. Actualizar la información de una persona
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(
            @PathVariable long id,
            @RequestBody @Valid RequestUpdatePersonaDTO payload) {
        return ResponseEntity
                .status(200)
                .body(this.personaService.updatePersona(id, payload));
    }
}