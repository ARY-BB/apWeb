package mx.edu.utez.proyecto1c.controller.usuario.dto;

import jakarta.validation.constraints.Size;

public class RequestUpdateUsuarioDTO {

    @Size(min = 3, max = 50, message = "El username debe tener entre 3 y 50 caracteres")
    private String username;

    private String descripccion;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescripccion() {
        return descripccion;
    }

    public void setDescripccion(String descripccion) {
        this.descripccion = descripccion;
    }
}