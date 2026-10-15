package mx.edu.utez.proyecto1c.model.persona;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.util.Date;

public class RequestUpdatePersonaDTO {

    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private Date fechaNacimiento;

    @Email(message = "El formato del correo es inválido")
    private String correo;

    @Size(min = 18, max = 18, message = "El CURP debe tener exactamente 18 caracteres")
    private String curp;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }
}