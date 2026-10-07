package mx.edu.utez.proyecto1c.model.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cursos {

    @Id
    ///autoincrementable
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private int noUnidades;


}
