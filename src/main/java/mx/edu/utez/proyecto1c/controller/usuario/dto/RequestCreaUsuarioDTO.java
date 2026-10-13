package mx.edu.utez.proyecto1c.controller.usuario.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreaUsuarioDTO {
    ///evitar nulos y vacio
    @NotBlank(message = "el username es obligatorio")
    //maximo o mini de caracteres
    @Size(min = 4, max = 20, message ="debe ser entre 4 y 20 caracteres")
    private String ussername;

    @NotBlank(message = "la contraseña  es obligatorio")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d).{8,}$",
            message = "La contraseña debe tener al menos 8 caracteres, una mayúscula y un número"
    )
    private String password;

    @NotBlank(message = "el rol es obligatorio")
    @Pattern(
            regexp = "^(ADMIN|GESTOR|ESTUDIANTE)$",
            message = "El rol debe ser ADMIN, GESTOR o ESTUDIANTE"
    )
    private String rol;

    private String descripccion;

}
