package mx.edu.utez.proyecto1c.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.proyecto1c.model.persona.Persona;

@Entity
@Table(name="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(
            name = "username1",
            ///para campo obligatorio en la bd
            nullable = false,
            unique=true
    )
    private String username;
    private String password;

    private boolean isEnable;


    //config para el enum
    @Enumerated(EnumType.STRING)
    private Roles rol;


    ///para q el atributo no se genere en la base de datos
    @Transient
    private String campoPrueba;

    ///en vez de varchar para q sea text
    @Column(columnDefinition = "TEXT")
    private String descripccion;

    //////////va a tener la foreingkey de personas/////////
    
    @OneToOne
    @JoinColumn(name="persona_id")
    private Persona persona;

}
