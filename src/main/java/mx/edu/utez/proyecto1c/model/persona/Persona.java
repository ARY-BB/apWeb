package mx.edu.utez.proyecto1c.model.persona;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

///identificar q sera tabla
@Entity
@Table(name="personas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    ///para q sea incrementable
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nombres;
    private String primerApellido;
    private String segundoApellido;



    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    private String correo;
    private String curp;



}
