package mx.edu.utez.proyecto1c.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
////recibe los datos del dto del body el json sus datos y su formate
public class RequestBodyDTO {
    @NotBlank
            (message = "el nombre es obligatorio")
    @Size
            (min = 3, message = "el nombre debe tener 3 caracteres")
    private String nombre;

    @Min
            (value = 18, message = "debe ser mayor de edad")
    private int edad;

    @Email(message = "el formato no valido")
    private String email;

    @Pattern(
            regexp = "^[A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TL|TS|VZ|YN|ZS|NE)[BCDFGHJKLMNPQRSTVWXYZ]{3}[A-Z\\d]\\d$",
            message = "La CURP no tiene un formato válido"
    )
    private String curp;
}
