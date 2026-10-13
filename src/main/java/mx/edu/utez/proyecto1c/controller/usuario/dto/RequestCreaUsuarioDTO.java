package mx.edu.utez.proyecto1c.controller.usuario.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    //////datos de persona////
     @NotBlank(message = "el nombre es obligatorio")
    private String nombres;
    @NotBlank(message = "el primer apellido es obligatorio")
    private String primerApellido;
    private String segundoApellido;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    @NotBlank(message = "el correo es obligatorio")
    @Email(message = "el correo es invalido")
    private String correo;
    @NotBlank(message = "el curp es obligatorio")

    private String curp;

}
