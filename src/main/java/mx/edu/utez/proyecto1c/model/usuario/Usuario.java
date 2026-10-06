package mx.edu.utez.proyecto1c.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private String username;
    private String password;

    private boolean isEnable;


    //config para el enum
    @Enumerated(EnumType.STRING)
    private Roles rol;

}
