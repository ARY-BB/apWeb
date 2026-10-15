package mx.edu.utez.proyecto1c.model.persona;

import jakarta.transaction.Transactional;
import mx.edu.utez.proyecto1c.EXCEPTION.customExceptions.BadRequestException;

import mx.edu.utez.proyecto1c.model.persona.Persona;
import mx.edu.utez.proyecto1c.model.persona.RequestUpdatePersonaDTO;
import mx.edu.utez.proyecto1c.repositori.persona.PersonaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaCervice {

    private final PersonaRepository personaRepository;

    public PersonaCervice(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    // 4. Actualizar la información de una persona
    @Transactional
    public Persona updatePersona(long id, RequestUpdatePersonaDTO payload) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("La persona con ID " + id + " no existe"));

        if (payload.getNombres() != null && !payload.getNombres().isBlank()) {
            persona.setNombres(payload.getNombres());
        }
        if (payload.getPrimerApellido() != null && !payload.getPrimerApellido().isBlank()) {
            persona.setPrimerApellido(payload.getPrimerApellido());
        }
        if (payload.getSegundoApellido() != null) {
            persona.setSegundoApellido(payload.getSegundoApellido());
        }
        if (payload.getFechaNacimiento() != null) {
            persona.setFechaNacimiento(payload.getFechaNacimiento());
        }
        if (payload.getCorreo() != null && !payload.getCorreo().isBlank()) {
            persona.setCorreo(payload.getCorreo());
        }
        if (payload.getCurp() != null && !payload.getCurp().isBlank()) {
            persona.setCurp(payload.getCurp());
        }

        return personaRepository.save(persona);
    }
}